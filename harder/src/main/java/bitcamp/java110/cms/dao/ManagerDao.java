package bitcamp.java110.cms.dao;

import java.util.List;

import bitcamp.java110.cms.domain.Manager;

public interface ManagerDao {
    int insert(Manager manager)
            throws MandatoryValueDaoExcecption, DuplicationDaoException;;
    List<Manager> findAll();
    Manager findByEmail(String email);
    default Manager findByNo(int no) {return null;}
    default int delete(String email) {return 0;}
    default int delete(int no) {return 0;}
}
