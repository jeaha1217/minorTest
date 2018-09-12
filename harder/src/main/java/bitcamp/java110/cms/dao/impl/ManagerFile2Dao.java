package bitcamp.java110.cms.dao.impl;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import bitcamp.java110.cms.annotaion.Component;
import bitcamp.java110.cms.dao.ManagerDao;
import bitcamp.java110.cms.domain.Manager;

@Component
public class ManagerFile2Dao implements ManagerDao{
    static String defaultFileName = "data/manager2.dat";
    String fileName;
    
    private List<Manager> list = new ArrayList<>();
    
    public ManagerFile2Dao() {
        this(defaultFileName);
    }
    
    @SuppressWarnings("unchecked")
    public ManagerFile2Dao(String fileName) {
        this.fileName = fileName;
        File dataFile = new File(fileName);
        
        try (
            ObjectInputStream in
            = new ObjectInputStream(
                    new BufferedInputStream(
                            new FileInputStream(dataFile)
                            ));
        ){
            list = (List<Manager>)in.readObject();
        }   catch(Exception e) {
            e.printStackTrace();
        } 
    }
    
    private void save() {
        File dataFile = new File(fileName);
        try (
                ObjectOutputStream out
                = new ObjectOutputStream(
                        new BufferedOutputStream(
                                new FileOutputStream(dataFile)
                                ));
        ){
            out.writeObject(list);
        }   catch(Exception e) {
            e.printStackTrace();
        }
    }
    //  예외 처리 문법이 없던 시절에는 리턴 값으로 예외 상황을 호출자에게 알렸음.
    public int insert(Manager manager) {
        //  필수 항목이 비었을 때.
        if (manager.getName().length() == 0 ||
            manager.getEmail().length() == 0 ||
            manager.getPassword().length() == 0) {
            return -1;
        }
        //  같은 이메일 주소가 있을 경우.
        for(Manager item : list) {
            if(item.getEmail().equals(manager.getEmail())) {
                return -2;
            }
        }
        list.add(manager);
        save();
        return 1;
    }
    
    public List<Manager> findAll() {
        return list;
    }
    
    public Manager findByEmail(String email) {
        for(Manager item : list) {
            if(item.getEmail().equals(email)) {
                return item;
            }
        }
        return null;
    }
    
    public int delete(String email) {
        for(Manager item : list) {
            if(item.getEmail().equals(email)) {
                list.remove(item);
                save();
                return 1; 
            }
        }
        return 0;
    }
}
