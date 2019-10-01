<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!-- <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.7.0/css/all.css" integrity="sha384-lZN37f5QGtY3VHgisS14W3ExzMWZxybE1SJSEsQp9S+oqd12jhcu+A56Ebc1zFSJ" crossorigin="anonymous">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script> -->

<div class="page-header">
	<div class="outer-margin">
		<h2>My Page</h2>
	</div>
</div>

<div class="page-container mypage" data-page-title="dashboard">
	<div class="outer-margin">
		<div class="page-navigation">
			<ul>
				<li data-page-target="dashboard">
					<a href="/project/member/memberInfo.do">마이페이지</a>
				</li>
				<li data-page-target="orders">
					<a href="">주문내역</a>
				</li>
				<li data-page-target="points">
					<a href="">적립금</a>
				</li>
				<li data-page-target="inquiries">
					<a href="/project/service/serviceBoardList.do?pg=1">고객센터</a>
				</li>
			</ul>
		</div>
		<div class="page-content" id="myDisplay">
			<jsp:include page="${myDisplay}"/>
		</div>
	</div>
</div>

<div class="container">
	<div class="modal fade" id="passwordModal">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header" style="padding:20px 30px;">
					<h4 class="modal-title">비밀번호 확인</h4>
					<button type="button" class="close" data-dismiss="modal">&times;</button>
				</div>
				
				<div class="modal-body">
					<form role="form" onsubmit="return false;">
						<div class="form-group">
							<label for="pwd"> Password</label>
							<input type="password" class="form-control" id="check_pwd" name="pwd" placeholder="패스워드 입력">	
							<div id="ResultDiv"></div>
						</div>
					</form>
				</div>
				<div class="modal-footer">
			        <button type="submit" id="pwd-submit" class="btn btn-dark">확인</button>
		          	<button type="button" class="btn btn-dark" data-dismiss="modal">취소</button>
		        </div>
			</div>
		</div>
	</div>
</div>

<script type="text/javascript">
$(document).ready(function(){
	var id = "${sessionScope.memId}";
	
	$("#check_pwd").keyup(function(){
		$("#ResultDiv").empty();
	});
	
	$("#pwd-submit").click(function(){
		$("#ResultDiv").empty();
		
		var pwd = $("#check_pwd").val();
		
		if(pwd == "") {
			$("#ResultDiv").text("비밀번호를 입력하세요").css("color", "tomato").css("font-size", "8pt");
			$("#check_pwd").focus();
			return false;
		} else {
			$.ajax({
				type	: "post",
				url		: "/project/member/checkPwd.do",
				data	: {id : id, pwd : $("#check_pwd").val()},
				dataType: "json",
				success : function(data) {
					if(data.result == "ok") {
						location.replace("/project/member/modifyForm.do");
					} else if(data.result == "fail") {
						$("#ResultDiv").text("비밀번호가 틀렸습니다!!").css("color", "tomato").css("font-size", "10pt");
						$("#check_pwd").val("");
						$("#check_pwd").focus();
						return false;
					}
				}
			});
		}
	});
	
	$('#passwordModal').on('hidden.bs.modal', function (e) {
	    $(this).find('form')[0].reset();
		$("#ResultDiv").empty();
	});

});
</script>
