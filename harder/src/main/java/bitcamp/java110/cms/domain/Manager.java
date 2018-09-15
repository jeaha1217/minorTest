package bitcamp.java110.cms.domain;

public class Manager extends Member{
    private static final long serialVersionUID = 1L;
    //  super클래스에서 인터페이스 상속받으면 하위클래스는 자동 상속받지만 git에 올리면
    //  SerialVersion이 바뀌므로 defaultSerial 주기.
    protected String position;
    protected String tel;

    public String getPosition() {
        return position;
    }
    public String getTel() {
        return tel;
    }
    public void setPosition(String position) {
        this.position = position;
    }
    public void setTel(String tel) {
        this.tel = tel;
    }
}