//package bitcamp.java110.cms;
//import java.util.Scanner;
//
//import org.springframework.context.support.ClassPathXmlApplicationContext;
//
//import bitcamp.java110.cms.context.RequestMappingHandlerMapping;
//import bitcamp.java110.cms.context.RequestMappingHandlerMapping.RequestMappingHandler;
//
//public class App {
//    //  복붙이라도 제대로 해야 취업을 한다고요...
///*
//    
//*/
//    static Scanner keyIn = new Scanner(System.in);
//
//    public static void main(String[] args) throws Exception {
//        //  Spring IoC Container 사용
//        ClassPathXmlApplicationContext iocContainer =
//                new ClassPathXmlApplicationContext
//                ("bitcamp/java110/cms/conf/application-context.xml");
//        
//        // IoC 컨테이너가 생성한 객체 조회하기
//        System.out.println("------------------------");
//        String[] nameList = iocContainer.getBeanDefinitionNames();
//        for (String name : nameList) {
//            System.out.println(name);
//        }
//        System.out.println("------------------------");
//        
//        RequestMappingHandlerMapping requestHandlerMap = 
//                new RequestMappingHandlerMapping();
//
//        String[] names = iocContainer.getBeanDefinitionNames();
//        for(String name : names) {
//            Object obj = iocContainer.getBean(name);
//            requestHandlerMap.addMapping(obj);
//        }
//
//
//        while(true) {
//            String menu = prompt();
//
//            if(menu.equals("exit")) {
//                System.out.println("Bye!");
//                break;
//            }
//            RequestMappingHandler mapping = requestHandlerMap.getMapping(menu);
//
//            if(mapping == null) {
//                System.out.println("해당 메뉴가 없습니다.");
//                continue;
//            }
//            
//            try {
//                mapping.getMethod().invoke(mapping.getInstance(), keyIn);
//            }   catch(Exception e) {
//                System.out.println(e);
//                System.out.println(e.getCause());
//            }
//        }
//        keyIn.close();
//        iocContainer.close();
//    }
//    private static String prompt() {
//        System.out.print("\n메뉴> ");
//        String menu = keyIn.nextLine();
//        return menu;
//    }
//}
