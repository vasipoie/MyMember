<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%
		String memId = request.getParameter("memId");
	%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 정보 수정</title>
    <script src="https://code.jquery.com/jquery-3.6.4.min.js"></script>

</head>
<body>
	<form action="<%=request.getContextPath() %>/update.do" method="post" enctype="multipart/form-data">
	<!-- 번호, 사진은 필수 아님  -->
		<input type="text" name="memId" value=<%=memId %> style="display: none;">
		<table id="t1" border='1'>
			<tr>
				<td>회원ID</td>
				<td><%=memId%></td>
			</tr>
			
			<tr>
				<td>비밀번호</td>
				<td>
					<input type="password" name="memPass" id="memPass" pattern="[a-zA-Z0-9]+" maxlength="30" required>
				</td>
			</tr>

			<tr>
				<td>회원이름</td>
				<td>
					<input type="text" name="memName" pattern="[가-힣]+" maxlength="10" required>
				</td>
			</tr>

			<tr>
				<td>전화번호</td>
				<td>
					<input type="text" name="memTel" >
				</td>
			</tr>

			<tr>
				<td>주소</td>
				<td>
					<input type="text" name="memAddr" pattern="[가-힣]+" maxlength="30" required>
				</td>
			</tr>

			<tr>
				<td>프로필사진</td>
				<td>
					<input type="file" name="memPhoto">
				</td>
			</tr>
			
			<tr>
				<td colspan='2' align ="center">
					<input type="submit" value="저장">
					<input type="button" value="취소" onclick="location.href='./update.do?memId=<%=memId%>'">
					<input type="button" value="회원목록" onclick="location.href='<%=request.getContextPath() %>/list.do'">
				</td>
			</tr>
		</table>
	</form>
</body>
</html>