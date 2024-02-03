<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 정보 입력</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>

</head>
<body>
	<form action="<%=request.getContextPath() %>/insert.do" method="post" enctype="multipart/form-data">
		<h3>회원 정보 입력 폼</h3>
        <table border="1">
            <tr>
                <td>회원ID</td>
                <td>
	                <input type="text" id="memId" name="memId" required="required"/>
	                <button id="checkDuplBtn">중복확인</button>
	                <span id="idStatus" class="status-message"></span>
                </td>
            </tr>
            <tr>
                <td>비밀번호</td>
                <td>
                	<input type="password" id="memPass" name="memPass" required="required"/>
                </td>
            </tr>
            <tr>
                <td>비밀번호 확인</td>
                <td>
                	<input type="password" id="confirmPassword" required="required"/>
                	<span id="passStatus" class="status-message"></span>
                </td>
            </tr>
            <tr>
                <td>회원이름</td>
                <td>
                	<input type="text" id="memName" name="memName" required="required"/>
                </td>
            </tr>
            <tr>
                <td>전화번호</td>
                <td>
                	<input type="text" id="memTel" name="memTel"/>
                </td>
            </tr>
            <tr>
                <td>회원주소</td>
                <td>
                	<input type="text" id="memAddr" name="memAddr"/>
                </td>
            </tr>
            <tr>
                <td>프로필 사진</td>
                <td>
                	<input type="file" id="memPhoto" name="memPhoto"/>
                </td>
            </tr>
            <tr align="center">
                <td colspan="2">
                    <button type="submit">저장</button>
                    <button type="submit">취소</button>
                    <button type="submit">회원목록</button>
                </td>
            </tr>
        </table>
	</form>
</body>
<script>
    // 중복 확인 버튼을 클릭했을 때의 동작
    $('#checkDuplBtn').on('click', function(){
        $.ajax({
            url:'/MyMember/checkId.do', // 서블릿의 URL
            data: {memId: $('#memId').val()}, // 입력된 아이디를 전송
            success: function(data){
                console.log(data.rst);
                console.log(data.msg);
                if(data.rst == "ok"){
                    $('#idStatus').text(data.msg).css('color','green');
                } else {
                    $('#idStatus').text(data.msg).css('color','red');
                }
            },
            error: function(xhr){
                alert(xhr.status);
            },
            dataType:'json'
        });
    });

    // 비밀번호 일치여부 확인
    $('#confirmPassword').on('keyup', function(){
        let pass = $('#memPass').val();
        let passChk = $('#confirmPassword').val();

        if(pass == passChk) {
            $('#passStatus').text('비밀번호 일치!').css('color','green');
        } else {
            $('#passStatus').text('비밀번호 불일치!').css('color','red');
        }
    });
</script>
</html>