package bitcamp.java110.cms.domain;

public class Teacher extends Member{
    private static final long serialVersionUID = 1L;
    
    protected int pay;
    protected String subject;
    
    public int getPay() {
        return pay;
    }
    public String getSubject() {
        return subject;
    }
    
    public void setPay(int pay) {
        this.pay = pay;
    }
    public void setSubject(String subject) {
        this.subject = subject;
    }
}
