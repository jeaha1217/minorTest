package bitcamp.java110.cms.util;

public class ArrayList<T> {
    //  개별적으로 관리 해야 할 값이라면 인스턴스 변수를 사용하라.
    //  한개만 만들어서 모두가 쓰느냐 아니면 각각 사용해야 하느냐에 따라 static인지 inst.인지.
    //  개발의 편의성을 위해(확장성을 위해) 보통 Instance로 만듦. 혹시 나중에 따로 쓰게 될 수 있음으로.
    private Object[] list = new Object[5];
    private int index = 0;
    
    public void add(T obj) {
        if(index == list.length) {
            increaseStorage();
        }
        
        list[index++] = obj;
    }
    
    private void increaseStorage() {
        Object[] newList = new Object[list.length + 3];
        for (int i = 0; i < list.length; i++) {
            newList[i] = list[i];
        }
        list = newList;
    }
    
    public void remove(int no) {
        if(no < 0 || no >= index) {
            return;
        }
        
        for(int i = no; i < index - 1; i++){
            list[i] = list[i -1];
        }
        index--;
    }
    
    public int size() {
        return index;
    }
    
    @SuppressWarnings("unchecked")
    public T get(int no) {
        if(no < 0 || no >= index) {
            return null;
        }
        return (T)list[no];
    }
}
