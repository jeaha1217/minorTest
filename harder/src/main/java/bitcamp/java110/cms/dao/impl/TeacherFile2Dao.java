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
import bitcamp.java110.cms.dao.TeacherDao;
import bitcamp.java110.cms.domain.Teacher;

@Component
public class TeacherFile2Dao implements TeacherDao{
    static String defaultFileName = "data/teacher2.dat";
    String fileName;
    
    private List<Teacher> list = new ArrayList<>();
    
    public TeacherFile2Dao() {
        this(defaultFileName);
    }
    
    @SuppressWarnings("unchecked")
    public TeacherFile2Dao(String fileName) {
        this.fileName = fileName;
        File dataFile = new File(fileName);
        
        try(
                ObjectInputStream in
                = new ObjectInputStream(
                        new BufferedInputStream(
                                new FileInputStream(dataFile)
                                ));
        ){
            list = (List<Teacher>)in.readObject();
        }   catch(Exception e) {
            e.printStackTrace();
        }
    }
    
    private void save() {
        File dataFile = new File(fileName);
        try(
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
    
    public int insert(Teacher teacher) throws MandatoryValueDaoExcecption, DuplicationDaoException{
        if (teacher.getName().length() == 0 ||
                teacher.getEmail().length() == 0 ||
                teacher.getPassword().length() == 0) {
                throw new MandatoryValueDaoExcecption("필수 값 누락 오류!");
            }
            for(Teacher item : list) {
                if(item.getEmail().equals(teacher.getEmail())) {
                    throw new DuplicationDaoException("이메일 중복 오류!");
                }
            }
            list.add(teacher);
            save();
            System.out.println("저장했습니다.");
            return 1;
        }

    public List<Teacher> findAll() {
        return list;
    }

    public Teacher findByEmail(String email) {
        for (Teacher item : list) {
            if (item.getEmail().equals(email)) {
                return item;
            }
        }
        return null;
    }

    public int delete(String email) {
        for (Teacher item : list) {
            if (item.getEmail().equals(email)) {
                list.remove(item);
                save();
                return 1;
            }
        }
        return 0;
    }
}
