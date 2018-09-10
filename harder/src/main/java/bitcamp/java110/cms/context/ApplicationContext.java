package bitcamp.java110.cms.context;

import java.io.File;
import java.lang.reflect.Constructor;
import java.util.HashMap;
import java.util.Set;

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
                    
                    //  =>  Component 애노테이션에 value가 있으면 그값으로 객체를 저장.
                    //  ->  없다면 클래스 이름으로 객체를 저장.
                    if(anno.value().length() > 0 ) {
                    //  =>  Component 애노테이션 value값으로 인스턴를 objPool에 저장한다.
                        objPool.put(anno.value(), instance);
                    }   else {
                    //  =>  클래스 이름으로 객체를 저장.
                        objPool.put(clazz.getName(), instance);
                    }
                    
                }   catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }   //  for
    }
    public Object getBean(String name) {
        return objPool.get(name);
    }
    
    public String[] getBeanDefinitionNames() {
        Set<String> keySet = objPool.keySet();
        String[] names = new String[keySet.size()];
//        keySet.toArray(names);
//        return names;
        //  한줄로 압축하기.
        return keySet.toArray(names);
        //  
    }
}
