package bitcamp.java110.cms.server;

import java.util.HashMap;
import java.util.Map;

public class Request {
    String command;
    String appPath;
    String queryString;
    
    Map<String, String> paramMap = new HashMap<>();
    
    public Request(String command) {
        this.command = command;
        
        //  명령어에서 QueryString을 분리한다.
        //  ex) manager/add?name=aaa&email=aaa@text.com&password=1111...
        String[] values = command.split("\\?"); 
            //  ?을 기준으로 나눠야함. 물음표를 문자로 인식 시키기 위해
            //  \   , \를 문자로 인식시키기 위해 \를 써줌 \\?
        
        this.appPath = values[0];   //  manager/add
        if(values.length >= 2) {
            queryString = values[1];    //  name=aaa&email=aaa@text.com&password=1111
            
            parseQueryString(queryString);
        }
    }

    private void parseQueryString(String qs) {
        String[] values = qs.split("&");
        for (String value : values) {
            String[] kv = value.split("=");
            paramMap.put(kv[0], kv[1]);
        }
    }
    
    public String getParameter(String name) {
        return this.paramMap.get(name);
    }

    public String getCommand() {
        return command;
    }

    public String getAppPath() {
        return appPath;
    }

    public String getQueryString() {
        return queryString;
    }
}
/*
    Request 와 Response
    사용자 요청을 받아 명령을 분석해서 필요한 값을 알아내는 놈.
    사용자 요청에 맞게 반응하기 위한놈.
*/