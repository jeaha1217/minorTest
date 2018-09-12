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
import bitcamp.java110.cms.dao.DuplicationDaoException;
import bitcamp.java110.cms.dao.ManagerDao;
import bitcamp.java110.cms.dao.MandatoryValueDaoExcecption;
import bitcamp.java110.cms.domain.Manager;

@Component
public class ManagerFile2Dao implements ManagerDao {
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
    
    public int insert(Manager manager) throws MandatoryValueDaoExcecption, DuplicationDaoException {
        //  필수 항목이 비었을 때.
        if (manager.getName().length() == 0 ||
            manager.getEmail().length() == 0 ||
            manager.getPassword().length() == 0) {
            //  호출자에게 예외 정보를 만들어 던진다.
            throw new MandatoryValueDaoExcecption("필수 값 누락 오류!");
        }
        //  호출자에게 예외 정보를 만들어 던진다.
        for(Manager item : list) {
            if(item.getEmail().equals(manager.getEmail())) {
                throw new DuplicationDaoException("이메일 중복 오류!");
            }
        }
        list.add(manager);
        save();
        System.out.println("저장했습니다.");
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
/*  Throwable
Exception   :   개발자가 처리해야할 문제.
Error       :   시스템(JVM) 에러. 받아서 처리할 생각 절대 ㄴ
두가지로 받을수 있음.

Exception을 상속 받은 daoException을 사용함.
*/