<%@page import="vo.MyMemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	MyMemberVO mv = (MyMemberVO) request.getAttribute("mv");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 정보 상세</title>
</head>
<body>
	<div>
	<% 
		if (mv.getMemPhoto() == null || mv.getMemPhoto().isEmpty()) { 
	%>
    <p>프로필 사진이 없습니다.</p>
	<% 
		}else { 
	%>
    <img src="<%=request.getContextPath()%>/profile/<%= mv.getMemPhoto() %>" width="300" height="300">
	<% 	
		} 
	%>
	</div>	
	<table border="1">
		<tr>
			<td>회원ID</td>
			<td><%=mv.getMemId() %></td>
		</tr>
		<tr>
			<td>비밀번호</td>
			<td><%=mv.getMemPass() %></td>
		</tr>
		<tr>
			<td>회원이름</td>
			<td><%=mv.getMemName() %></td>
		</tr>
		<tr>
			<td>전화번호</td>
			<td><%=mv.getMemTel() %></td>
		</tr>
		
		<tr>
			<td colspan="2">
			<a href="<%=request.getContextPath() %>/list.do">[목록]</a>
			<a href="<%=request.getContextPath() %>/update.do?memId=<%=mv.getMemId()%>">[회원정보 수정]</a>
			<a href="<%=request.getContextPath() %>/delete.do?memId=<%=mv.getMemId()%>">[회원정보 삭제]</a>
			</td>
		</tr>
	</table>
</body>
</html>