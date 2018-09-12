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
import bitcamp.java110.cms.dao.MandatoryValueDaoExcecption;
import bitcamp.java110.cms.dao.StudentDao;
import bitcamp.java110.cms.domain.Student;

@Component
public class StudentFile2Dao implements StudentDao{
    static String defaultFileName = "data/student2.dat";
    String fileName;
    
    private List<Student> list = new ArrayList<>();
    
    public StudentFile2Dao() {
        this(defaultFileName);
    }
    
    @SuppressWarnings("unchecked")
    public StudentFile2Dao(String fileName) {
        this.fileName = fileName;
        File dataFile = new File(fileName);
        
        try (
            ObjectInputStream in
            = new ObjectInputStream(
                    new BufferedInputStream(
                            new FileInputStream(dataFile)
                            ));
        ){
            list = (List<Student>)in.readObject();
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
    
    public int insert(Student student) {
        if (student.getName().length() == 0 ||
                student.getEmail().length() == 0 ||
                student.getPassword().length() == 0) {
                throw new MandatoryValueDaoExcecption("필수 값 누락 오류!");
            }
            for(Student item : list) {
                if(item.getEmail().equals(student.getEmail())) {
                    throw new DuplicationDaoException("이메일 중복 오류!");
                }
            }
            list.add(student);
            save();
            System.out.println("저장했습니다.");
            return 1;
        }
    
    public List<Student> findAll() {
        return list;
    }
    
    public Student findByEmail(String email) {
        for(Student item : list) {
            if(item.getEmail().equals(email)) {
                return item;
            }
        }
        return null;
    }
    
    public int delete(String email) {
        for(Student item : list) {
            if(item.getEmail().equals(email)) {
                list.remove(item);
                save();
                return 1;
            }
        }
        return 0;
    }
}
