<%@page import="bitcamp.java110.cms.domain.Manager"%>
<%@page import="java.util.List"%>
<%@page import="bitcamp.java110.cms.dao.ManagerDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset='UTF-8'>
<title>매니져 관리(JSP)</title>
<link rel='stylesheet' href='../../css/common.css'>
<style>
table, th, td {
	border: 1px solid gray;
}
</style>
</head>
<body>
<%--<jsp:include page="../header.jsp"/>--%>
    <h1>매니져 목록(MVC1)</h1>
    <p>
        <a href='form.html'>추가</a>
    </p>
    <table>
        <thead>
            <tr>
                <th>번호</th><th>이름</th><th>이메일</th><th>직위</th>
        </tr>
        </thead>
        <tbody>
<%
ManagerDao managerDao = (ManagerDao) this.getServletContext()
.getAttribute("managerDao");

List<Manager> list = managerDao.findAll();

for(Manager m : list) {
%>
            <tr>
                <td><%=m.getNo()%></td>
                <td><a href='detail?no=<%=m.getNo()%>'><%=m.getName()%></a></td>
                <td><%=m.getEmail()%></td>
                <td><%=m.getPosition()%></td>
            </tr>
<%
}
%>
        </tbody>
    </table>
<jsp:include page="../footer.jsp"/>
</body>
</html>

<!-- 
MVC model I
모델1 구조는 사용자의 요청을 "JSP가" 전부 다 처리,
웹브라우저 사용자의 요청을 받은 JSP는 자바빈이나 서비스 클래스를 사용,
웹브라우저가 요청한 작업을 처리하고 그 결과를 출력해줌.
 -->