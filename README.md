# minorTest

비트캠프 자바 110기 복습 프로젝트

## tag : v0.6

- 패키지 활용 및 클래스 접근 범위

## tag : v0.5

- 조건문 반목분 메소드 활용

## tag : v0.4

- 클래스 활용

## tag : v0.3

- 메서드를 활용하려 리팩토링

## tag : v0.2

- 배열 활용

## tag: v0.1

- 반복문 활용


## java110-project-01 minor-revision (Initial Commit)

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