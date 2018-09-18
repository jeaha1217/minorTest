package bitcamp.java110.cms.server;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import bitcamp.java110.cms.context.RequestMappingHandlerMapping;
import bitcamp.java110.cms.context.RequestMappingHandlerMapping.RequestMappingHandler;

public class ServerApp {
    ClassPathXmlApplicationContext iocContainer;
    RequestMappingHandlerMapping requestHandlerMap;

    public ServerApp() throws Exception {
        createIoCContainer();
        logBeansOfContainer();
        processRequestMappingAnnotation();
    }

    private void createIoCContainer() {
        iocContainer = new ClassPathXmlApplicationContext(
                "bitcamp/java110/cms/conf/application-context.xml");
    }

    private void processRequestMappingAnnotation() {
        requestHandlerMap = new RequestMappingHandlerMapping();
        String[] names = iocContainer.getBeanDefinitionNames();
        for (String name : names) {
            Object obj = iocContainer.getBean(name);
            requestHandlerMap.addMapping(obj);
        }
    }

    private void logBeansOfContainer() {
        System.out.println("------------------------");
        String[] nameList = iocContainer.getBeanDefinitionNames();
        for (String name : nameList) {
            System.out.println(name);
        }
        System.out.println("------------------------");
    }

    public void service() throws Exception {
        //  클라이언트의 연결을 기다리는 서버 소켓 준비.
        ServerSocket serverSocket = new ServerSocket(8888);
        System.out.println("Autumn is Comming...");

        while(true) {
            Socket socket = serverSocket.accept();
            RequestWorker worker = new RequestWorker(socket);
            new Thread(worker).start();
        }
    }


    public static void main(String[] args) throws Exception {
        ServerApp serverApp = new ServerApp();
        serverApp.service();
    }

    class RequestWorker implements Runnable{
        Socket socket;

        public RequestWorker(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            // main thread에서 분리하여 독립적으로 수행할 코드.
            try (
                    Socket socket = this.socket;
                    PrintWriter out = new PrintWriter(
                            new BufferedOutputStream(
                                    socket.getOutputStream()));
                    BufferedReader in = new BufferedReader(
                            new InputStreamReader(
                                    socket.getInputStream()));
                    ) {
                System.out.println(in.readLine());
                out.println("Autumn"); out.flush();

                while (true) {
                    String requestLine = in.readLine();
                    if (requestLine.equals("EXIT")) {
                        out.println("The Autumn Has Overloaded...");
                        out.println();
                        out.flush();
                        break;
                    }

                    //  요청 객체와 응답 객체 준비.
                    Request request = new Request(requestLine);
                    Response response = new Response(out);

                    RequestMappingHandler mapping = 
                            requestHandlerMap.getMapping(request.getAppPath());
                    //  Request class에서 분석한 AppPath.
                    if (mapping == null) {
                        out.println("해당 요청을 처리할 수 없습니다.");
                        out.println();
                        out.flush();
                        continue;
                    }

                    try {
                        mapping.getMethod().invoke(mapping.getInstance(), request, response);
                        //  mapping.getInstance() : method 주소를 줌.  만약 static일때는 null;
                    } catch (Exception e) {
                        e.printStackTrace();
                        out.println("요청 처리 중에 오류가 발생했습니다.");
                    }
                    out.println();
                    out.flush();
                }
            }   catch(Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
