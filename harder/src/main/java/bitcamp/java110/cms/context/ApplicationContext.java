package bitcamp.java110.cms.context;

import java.io.File;
import java.lang.reflect.Constructor;
import java.util.HashMap;

import org.apache.ibatis.io.Resources;

import bitcamp.java110.cms.annotaion.Component;


public class ApplicationContext {
    HashMap<String, Object> objPool = new HashMap<>();

    public ApplicationContext(String packageName) throws Exception {
        String path = packageName.replace(".", "/");
        File file = Resources.getResourceAsFile(path);
        
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
                
                Class<?> clazz = Class.forName(className);
                
                if(clazz.isInterface()) continue;
                
                try {
                    Constructor<?> constructor = clazz.getConstructor();
                    
                    Object instance = constructor.newInstance();
                    
                    //  => 클래스에서 component annotation을 추출한다.
                    Component anno = clazz.getAnnotation(Component.class);
/*
                  !!자바에서 컴파일러가 자동으로 .class라는 변수를 생성함!!
클래스의 정보를 담고있는 변수임.
String을 다루는 클래스 String, Integer를 다루는 클래스 Integer, 클래스를 다루는 클래스 class
자바에서 모든 파일은 .class임 (interface, abstract class 뭐든 다 class)임.
*/
                    
                    //  어노테이션 value값으로 인스턴스 objPool에 저장한다.
                    objPool.put(anno.value(), instance);
                    
                }   catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }   //  for
    }
    public Object getBean(String name) {
        return objPool.get(name);
    }
}
