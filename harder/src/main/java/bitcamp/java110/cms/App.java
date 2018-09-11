package bitcamp.java110.cms;
import java.util.Scanner;

import bitcamp.java110.cms.context.ApplicationContext;
import bitcamp.java110.cms.context.RequestMappingHandlerMapping;
import bitcamp.java110.cms.context.RequestMappingHandlerMapping.RequestMappingHandler;

public class App {
/*
    Controller들이 App에 의존 되어 있음,  
        ApplicationContext
            -   객체 생성.
            -   의존 객체를 주입해주는 역할.(Dependency Injection)
            IoC EventController 실행을 역행, DI의 한 예.
*/

    static Scanner keyIn = new Scanner(System.in);

    public static void main(String[] args) throws Exception {
        ApplicationContext iocContainer = 
                new ApplicationContext("bitcamp.java110.cms");

        RequestMappingHandlerMapping requestHandlerMap = 
                new RequestMappingHandlerMapping();

        //  IoC컨테이너에 보관된 객체의 이름 목록을 가져온다.
        String[] names = iocContainer.getBeanDefinitionNames();
        for(String name : names) {
            // => 이름으로 객체를 꺼낸다.
            Object obj = iocContainer.getBean(name);

            //  =>  객체에서 @RequestMapping이 붙은 메서드를 찾아 저장한다.
            requestHandlerMap.addMapping(obj);
        }


        while(true) {
            String menu = prompt();

            if(menu.equals("exit")) {
                System.out.println("Bye!");
                break;
            }
            RequestMappingHandler mapping = requestHandlerMap.getMapping(menu);
            //  keyIn을 인자값으로 강압적으로 준다. list 메소드 keyIn이 필요 없지만 받아야함.
            //  복붙이라도 제대로 해야 취업을 한다고요...

            if(mapping == null) {
                System.out.println("해당 메뉴가 없습니다.");
                continue;
            }
            mapping.getMethod().invoke(mapping.getInstance(), keyIn);
        }
        keyIn.close();
    }

    private static String prompt() {
        System.out.print("\n메뉴> ");
        String menu = keyIn.nextLine();
        return menu;
    }
}
