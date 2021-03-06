package bitcamp.java110.cms.domain;

public class Student extends Member{
    private static final long serialVersionUID = 1L;
    
    protected String school;
    protected boolean working;
    
    public String getSchool() {
        return school;
    }
    public boolean isWorking() {
        return working;
    }
    
    public void setSchool(String school) {
        this.school = school;
    }
    public void setWorking(boolean working) {
        this.working = working;
    }
}
