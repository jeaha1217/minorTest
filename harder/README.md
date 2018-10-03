# java110-project minor-division

## v4.6

- 쿠키 적용하기
- 작업
    - 로그인 폼을 제작한다.
    - 아이디 저장 기능을 쿠키로 구현한다.
    
## v4.5

- forward, include 적용
- 작업
    - 여러 서블릿에서 공통적으로 수행하는 작업을 별도의 서블릿으로 분리한다.
    - 그 서블릿으로 포워드를 수행한다.
    - 예1) ErrorServlet 클래스 생성하고 포워드를 적용한다.
    - 예2) HeaderServlet, FooterServlet 클래스를 생성하고 인클루드를 적용한다.

## v4.4

- refresh, redirect 적용
- 작업
    - 등록 or 삭제한 후에 목록 페이지를 자동으로 요청하도록 refresh적용.

## v4.3

- HTMl 출력하기
- 작업
    - 서블릿의 출력 콘텐트를 일반 텍스트에서 html로 바꾼다.

## v4.2

- 리스너를 이용하여 공용 자원을 준비하기
- 작업
    - ContextLoaderListener 클래스 생성
    - 이 리스너에서 DAO 준비하기
    
## v4.1

- 서블릿의 loadOnStartup 배치 속성을 이용하여 공용 자원을 준비하기
- ServletContext를 이용하여 공용자원을 공유하기
- 작업
    - InitServlet 클래스 생성 
    - InitServlet에서 DAO와 DataSource 준비하기
    - ServletContext에 DAO 보관하기

## v4.0

- 서블릿 기술을 적용하여 서버 애플리케이션 만들기
- 작업
    - 클라이언트 요청을 처리하는 컨트롤러를 서블릿으로 전환한다.

-----------------------------------------------------------

## v3.1 

- 웹서버를 중계 서버로 사용하기
- 서블릿 컨테이너 적용
    - 톰캣 서버 설치
    - build.gradle 에 servlet-api 라이브러리 추가 
    
## v3.0

- 웹브라우저를 클라이언트로 사용하기
- 서버에 HTTP 프로토콜을 처리하는 기능 추가
- ServerApp 클래스를 HTTP 프로토콜 요청과 응답을 처리하는 방식으로 변경한다.

## v2.9 

- Command 패턴으로 분할된 메서드를 한 클래스로 합치기
- 관련된 컨트롤러 클래스를 한 클래스로 만든다.
    - ManagerListController, ManagerAddController, ManagerDetailController, ManagerDeleteController 클래스를 ManagerController 클래스로 합친다.
    - 학생 관리와 강사 관리도 마찬가지이다.
    - 각각의 컨트롤러가 크지 않을 때는 관리하기 쉽게 한 클래스로 합치기도 한다.
    
## v2.8 (Stateless)

- 멀티스레드 적용하기(Connection-Oriented에서 Stateless 방식으로 요청 처리)

## v2.7 (Stateful)

- 멀티스레드 적용하기(Connection-Oriented에서 Stateful 방식으로 요청 처리)
- 별도의 스레드를 만들어 클라이언트의 요청을 처리하게 한다.
- 즉 동시에 여러 클라이언트 요청을 처리한다.

## v2.6

- client/Server 구조로 변경.
- 소켓 프로그래밍 구현.
- 멀티 쓰레딩 구현.
- 프로토콜 개념 이해


gradle build
/Users/Sorrowkissed/git/java110/java110-project/build/libs
java110-project.jar 생성.


gradle clean
gradle build

dir에서 ./java110-project

## v2.5

- Client/Server 구조로 변경
- 소켓 프로그래밍 구현
- 멀티스레딩 구현
- 프로토콜 개념 이해

## v2.5

- Spring IoC 컨테이너 도입
- 기존에 만들었던 ApplicationContext 대신에 Spring 프레임워크에서 제공하는 ApplicationContext 사용하기
- 작업
    - Spring IoC 컨테이너 라이브러리 추가(build.gradle 파일 편집)
        - "spring context" 로 mvnrepository.com에서 검색한다.
        - 명령창에서 "gradle eclipse" 실행한다.
        - 이클립스에서 프로젝트를 "refresh" 한다.
    - 스프링 설정 파일 추가(application-context.xml)
        - bitcamp/java110/cms/conf/application-context.xml
    - 기존의 ApplicationContext 관련 클래스들을 제거한다.
    - 기존의 @Autowired, @Component 애노테이션을 제거한다.
    - 기존 클래스에서 사용한 애노테이션을 Spring 프레임워크에서 제공하는 것으로 바꾼다.

## v2.4

- DB 커넥션 공유하기
- DB 연결 객체를 재사용하여 가비지를 줄이고, 실행 속도를 높이기 위함

## v2.3

- DAO에 JDBC 적용
- 작업 
    - Data Modeling과 forward engineering 수행
    - 테이블 준비
    - JDBC API 활용
    - 트랜잭션 다루기
    
## v2.2

- 예외처리 적용
- 예외처리 문법이 없던 시절
    - 리턴 값으로 예외 상황을 호출자에게 알렸다.
    - 특정 타입의 값을 리턴하는 경우 이 방법을 쓰기 곤란하다.
- 예외처리 문법이 등장
    - 리턴 값이 아닌 별도의 경로로 예외 상황을 호출자에게 알린다.
    - 이전 방식에 비해 메서드의 리턴 타입에 영향을 받지 않는다.
    - 예외 상황을 자세하게 호출자에게 알릴 수 있다.

## v2.1

- 객체 Serialize / Deserialixe 적용
- java.io.Serializable 인터페이스 적용
- transient modifier 사용법

## v2.0

- DAO에 파일 입출력 도입
- DAO에 인터페이스 적용
- 작업
    - DAO에 데이터를 파일로 저장하고 읽는 기능 추가

## v1.9
- IoC 컨테이너가 객체 생성 후에 수행하는 작업을 별도의 클래스로 분리한다.
- 향후 객체 생성 후에 또 다른 작업을 추가하기 쉽도록 한다.

## v1.8

- 의존 객체 주입하기 
- 미니 IoC 컨테이너 개선
- 작업
    - 의존 객체를 주입 받을 수 있도록 setter를 준비한다.
    - IoC 컨테이너가 setter를 자동으로 호출하도록 애노테이션으로 표시한다.

## v1.7

- DAO(Data Access Object) 도입하기
    - 데이터를 저장하는 방식이 바뀌더라도 기존 클래스에 영향을 주지 않게 하려면, 데이터를 다루는 부분을 List가 아니라 별도의 클래스로 정의해야 한다.
    - 즉 List를 통해 데이터를 메모리에 저장하는 대신에 파일이나 데이터베이스에 저장한다면 기존 코드를 변경해야 하는 문제가 있다. 
    - 이 부분을 해결하기 위함이다.
- 작업
    - 학생관리, 강사관리, 매니저관리 각각에 사용할 DAO 클래스를 정의한다.
    
## v1.6

- Command 디자인 패턴 적용
- 컨트롤러 구조 변경

## v1.5

- 리플렉션 API 활용 II
- 애노테이션 활용
- 미니 IoC 컨테이너 개선
- 작업
    - 자동으로 생성되어야 할 객체에 붙일 애노테이션 정의
    - 컨트롤러 객체에 애노테이션 적용
    - 애노테이션이 붙은 클래스만 객체를 생성 
    
## v1.4

- 리플랙션 API 활용
- File 클래스로 디렉토리 및 파일 다루기
- 미니 IoC 컨테이너 작성

## v1.3

- 인터페이스 활용
- App클래스와 Controller들 사이의 호출 규칙(사용규칙)을 인터페이스로 정의한다.

## v1.2

- 자바 컬렉션 API사용
- 직접 제작한 List, ArrayList, LinkedList대신에 JAVA API에서 제공하는 Util을 사용한다.


## v1.1

- 인터페이스 적용
- 데이터 목록을 다룰 때 호출하는 메서드의 규칙을 정의한다.
    - 다양한 방법으로 구현한 객체를 사용할 수 있다.
    - 즉, 규칙을 따르기만 한다면 어떤 객체라도 대체할 수 있다.
- Interface에 default Method 활용.

## v1.0

- LinkedList 구동 원리 및 적용
- LinkedList 만들기

## v0.9

- 제네릭 활용법
- ArrayList에 generic 활용하기

## v0.8

- 목록을 다루는 클래스들을 리팩토링 하기.
- 다형적 변수 활용법.
- List 클래스들을 한 클래스로 합친다.
- 다형적 변수를 사용하여 세 객체를 모두 저장 할 수 있게 한다.
- 생성자 사용.

## v0.7

- 목록 다루기
- 배열에 항목을 추가하고 삭제하는 기능을 추가.
- 배열의 값 목록을 다루는 기능을 별도의 클래스로 분리.

## v0.6

- 패키지 활용 및 클래스 접근 범위

## v0,5

- 조건문, 반복문, 메소드 활용
- 강사, 학생, 매니져를 구분하여 입력받고 출력한다.

## v0.4

- 여러 속성의 값을 다루기 쉽도록 클래스를 이용하여 사용자 정의 데이터 타입을 만든다. 또한 그 데이터를 다룰 연산자를 정의한다.

## v0.3

- 관련 명령들을 재사용하기 쉽도록 메서드 블록으로 묶는다.

## v0.2

- 배열을 이용하여 여러 회원의 정보를 저장하기

## v0.1

- 반복문을 이용하여 회원정보 입력 받아 출력하기
- 작업
- App.java변경

## v0.0 

-   자바 프로젝트 디렉토리 구성하기

```
1) github - repository 생성
2 - 3) terminal - dir에서 git Clone [url]
        cd dir 들어가기
        mkdir 작업 폴더 만들기
        cd 작업 폴더 들어가기
        $ gradle init --type java-application
4) VisualStudioCode(이하 VS) 에서 gradle 설정파일 (build.gradle)에
        id 'eclipse' 플러그인 추가 + mavenCentral() 옵션
        .gitignore 파일 생성
            .gradle/ .setting/ bin/ build/ .classpath .project
5) terminal : 작업 폴더에서 이클립스 설정파일 생성
             $ gradle eclipse
6) 이클립스에서 프로젝트 임포트.

    이렇게 하는 이유.
    gradle : 프로젝트를 형상화 해주는 빌드 도구. IDE에 종속되지 않도록 하는 개발.
    VS : 이클립스에서 할 수 없는 설정을 할 수 있음.
        
```