package bitcamp.java110.cms.control;

import java.util.Scanner;

public interface Control {
    void service(Scanner keyIn);
}
//  인터페이스 생성과 상속으로 Controller들에 새로운 규칙 생성.
//  service 메소드가 호출 될때 Scanner 객체를 인자로 받고,
//  나머지 메소드들이 scanner 객체를 받아서 사용함.