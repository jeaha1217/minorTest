package bitcamp.java110.cms.context;

import java.io.File;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.util.HashMap;

import org.apache.ibatis.io.Resources;


public class ApplicationContext {
    HashMap<String, Object> objPool = new HashMap<>();

    public ApplicationContext(String packageName) throws Exception {
        // 패키지 이름을 파일 경로로 바꾸기.
        String path = packageName.replace(".", "/");
        
        // 패키지 상대경로를 가지고 전체 파일 경로를 알아내기.
        File file = Resources.getResourceAsFile(path);
//        System.out.println(file.getAbsolutePath());
        
        //  패키지 폴더에 들어 있는 클래스를 찾아 인스턴스를 생성, objPool에 보관.
        findClass(file, path);
    }   //  Constructor
    
    private void findClass(File path, String packagePath) throws Exception {
        File[] files = path.listFiles();
        
        for(File file : files) {
            if(file.isDirectory()) {
                findClass(file, packagePath + "/" + file.getName());
            }   else {
                String className =
                        (packagePath + "/" + file.getName())
                        .replace("/", ".")
                        .replace(".class", "");
                
                //  1) 클래스 이름을 가지고 .class파일을 찾아 메모리에 로딩함.
                Class<?> clazz = Class.forName(className);
                
                //  인터페이스인 경우 무시.
                if(clazz.isInterface()) continue;
                
                try {
                    //  2) 로딩된 클래스 정보를 가지고 인스턴스를 생성해야함..
                    //  => 해당 클래스의 생성자 정보를 얻어야함. 
                    Constructor<?> constructor = clazz.getConstructor();
                    
                    //  => 얻어온 생성자로 인스턴스 생성.
                    Object instance = constructor.newInstance();
                    
                    // => 필드요소, 멤버변수 name의 값을 찾음.
                    Field field = clazz.getField("name");
                    
                    Object name = field.get(instance);
                    System.out.println(clazz.getName() + "==>" + name);
                    
                    // =>  필드"name"의 값으로(멤버변수 name의 값으로) 인스턴스를 objPool에 저장함.
                    objPool.put((String)name, instance);
                    
                }   catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }   //  for
    }
    public Object getBean(String name) {
        //  objPool에서 주어진 이름의 객체를 찾아 리턴시킴.
        return objPool.get(name);
    }
}
