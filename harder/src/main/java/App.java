import java.util.Scanner;

import bitcamp.java110.cms.context.ApplicationContext;
import bitcamp.java110.cms.context.RequestMappingHandlerMapping;
import bitcamp.java110.cms.context.RequestMappingHandlerMapping.RequestMappingHandler;

public class App {
/*  Annotation활용.
    RequestMapping을 통해 메소드 호출.

    v1.4.1
    Component와 RequestMapping 두개의 어노테이션으로 객체를 생성,
    Component 어노테이션 student, teacher, manager으로 클래스를 호출해서
    RequestMapping 메소드를 실행시킴. 
	v1.5
    ApplicationContext에서 객체를 저장.
    RequestMappingHandlerMapping 객체의 명령어를 저장함.
    @RequestMapping 얘를 key값으로 메소드를 불러옴ㅇㅇ 시발 어렵네.

*/
    
    static Scanner keyIn = new Scanner(System.in);
    
    public static void main(String[] args) throws Exception {
        ApplicationContext iocContainer = 
                new ApplicationContext("bitcamp.java110.cms.control");
        
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
            
            if(mapping == null) {
                System.out.println("해당 메뉴가 없습니다.");
                continue;
            }
//            Method method = mapping.getMethod();
//            method.invoke(mapping.getInstance(), keyIn);
            
            mapping.getMethod().invoke(mapping.getInstance(), keyIn);
            //  한줄로 만들 수 있음. 익숙해 지는게 좋음.
            
        }
        keyIn.close();
    }

    private static String prompt() {
        System.out.print("\n메뉴> ");
        String menu = keyIn.nextLine();
        return menu;
    }
}
