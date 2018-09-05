package bitcamp.java110.cms.domain;

public class Manager extends Member{
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