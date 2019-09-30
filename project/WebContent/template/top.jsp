<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.7.0/css/all.css" integrity="sha384-lZN37f5QGtY3VHgisS14W3ExzMWZxybE1SJSEsQp9S+oqd12jhcu+A56Ebc1zFSJ" crossorigin="anonymous">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>

<div class="header">
<div class="navigation">
	<div class="navigation-menu primary-menu">
		<ul>
			<li><a href="/project/main/index.do">Home</a></li>
			<li><a href="#"><span>Top</span></a>
				<ul>
					<li><a href="#"><span>Outer</span></a></li>
					<li><a href="#"><span>Short Sleeve</span></a></li>
					<li><a href="#"><span>Long Sleeve</span></a></li>
					<li><a href="#"><span>Shirt</span></a></li>
					<li><a href="#"><span>Knit</span></a></li>
				</ul>
			</li>
			<li><a href="#"><span>Bottom</span></a>
				<ul>
					<li><a href="#"><span>Jean</span></a></li>
					<li><a href="#"><span>Pants</span></a></li>
				</ul>
			</li>
			<li><a href="#"><span>Acc</span></a>
				<ul>
					<li><a href="#"><span>Shoes</span></a></li>
					<li><a href="#"><span>Bag</span></a></li>
					<li><a href="#"><span>Accessories</span></a></li>
				</ul>
			</li>
		</ul>
	</div>
	<div class="navigation-menu secondary-menu">
		<ul>
			<li class="account">
				<span class="menu-item">
					<c:if test="${memId == null }">
						<a data-toggle="modal" href="#myModal">
						<i class="fa fa-user"></i>
						</a>					
					</c:if>
					<c:if test="${memId != null }">
						<a href="/project/member/memberInfo.do">
						<i class="fa fa-user"></i>
						</a>					
					</c:if>
				</span>
			</li>
			<li class="bag is-empty">
				<span class="menu-item">
					<a href="">
					<i class="fa fa-shopping-bag"></i>
					</a>
				</span>
			</li>
			<li class="search">
				<span class="menu-item search-button">
					<a href="">
					<i class="fa fa-search"></i>
					</a>
				</span>
			</li>
		</ul>
	</div>
</div>

<div class="container">
	<div class="modal fade" id="myModal">
		<div class="modal-dialog">
			<div class="modal-content">
	
				<div class="modal-header" style="padding:20px 30px;">
					<h4 class="modal-title">로그인</h4>
					<button type="button" class="close" data-dismiss="modal">&times;</button>
				</div>
			
				<div class="modal-body">
					<form role="form" onsubmit="return false;">
			            <div class="form-group">
			              <label for="id"> ID</label>
			              <input type="text" class="form-control" id="login_id" name="id" placeholder="아이디 입력">
			              <div id="idDiv"></div>
			            </div>
			            <div class="form-group">
			              <label for="pwd"> Password</label>
			              <input type="password" class="form-control" id="login_pwd" name="pwd" placeholder="패스워드 입력">
			           	  <div id="pwdDiv"></div>
			            </div>
			            <div class="checkbox">
			              <label><input type="checkbox" id="idRememberCheck" name="idRemember">&nbsp;아이디 저장</label>&nbsp;
			              <label><input type="checkbox" id="keepLogin" name="keepLogin">&nbsp;자동 로그인</label>
			            </div>
			              <div id="loginResultDiv"></div>
			              <button type="submit" id="login-submit" class="btn btn-success btn-block"> 로그인</button>
		          	</form>
				</div>

				<div class="modal-footer">
					<button type="button" class="btn btn-dark" onclick="location.href='/project/member/writeForm.do'"> 회원가입</button>
		          	<button type="button" class="btn btn-dark" data-dismiss="modal">취소</button>
		        </div>
			</div>
		</div>
	</div>
</div>
</div>
<script type="text/javascript">
$(document).ready(function(){
	// 저장된 쿠키값을 가져와서 ID 칸에 넣어준다. 없으면 공백들어감
	var rememberId = getCookie("rememberId");
	$("#login_id").val(rememberId);
	
	// 로그인 유지
	var keepLogin = getCookie("id");	//keepLogin에 hong 들어옴
	if(keepLogin != "") {	// 자동로그인처리된 아이디가 있을때.
	
	}
	
	// 그 전에 ID를 저장해서 처음 페이지 로딩시, 입력칸에 저장된 ID가 표시된 상태라면
	if($("#login_id").val() != "") {
		$("#idRememberCheck").attr("checked", true);
	}
	
	$("#idRememberCheck").change(function(){
		if($("#idRememberCheck").is(":checked")) {
			var rememberId = $("#login_id").val();
			setCookie("rememberId", rememberId, 7);	// 7일 동안 쿠키 보관
		} else { //ID 저장하기 체크 해제 시
			deleteCookie("rememberId");
		}
	});
	
	// ID 저장하기를 체크한 상태에서 ID를 입력하는 경우, 쿠키도 저장
	$("#login_id").keyup(function(){
		$("#loginResultDiv").empty();
		if($("#idRememberCheck").is(":chekced")) {	
			var rememberId = $("#login_id").val();
			setCookie("rememberId", rememberId, 7);	// 7일 동안 쿠키 보관
		}
	});

	// 로그인 액션
	$("#login-submit").click(function(){
		$("#idDiv").empty();
		$("#pwdDiv").empty();
		
		var id = $("#login_id").val();
		var pwd = $("#login_pwd").val();
		var keepLogin = $("#keepLogin").is(":checked");
		
		if(id == "") {
			$("#idDiv").text("아이디를 입력하세요").css("color", "tomato").css("font-size", "8pt");
			$("#login_id").focus();
			return false;
		} else if(pwd == "") {
			$("#pwdDiv").text("비밀번호를 입력하세요").css("color", "tomato").css("font-size", "8pt");
			$("#login_pwd").focus();
			return false;
		} else {
			$.ajax({
				type	: "post",
				url		: "/project/member/login.do",
				data	: {id : $("#login_id").val(), pwd : $("#login_pwd").val(), keepLogin : keepLogin },
				dataType: "text",
				success : function(data) {
					if(data.trim() == "ok") {
						location.replace("/project/member/memberInfo.do");
					} else if(data.trim() == "fail") {
						$("#loginResultDiv").text("아이디 또는 비밀번호 다시 입력하세요!!").css("color", "tomato").css("font-size", "10pt");
						$("#login_pwd").val("");
						$("#login_pwd").focus();
						return false;
					}
				}
			});
		}

	});
	
	$('#myModal').on('hidden.bs.modal', function (e) {
	    $(this).find('form')[0].reset();
		$("#idDiv").empty();
		$("#pwdDiv").empty();
		$("#loginResultDiv").empty();
	});

});

// 아이디 저장 쿠키 관련------------------------------
function setCookie(cookieName, value, exdays) {
	var exdate = new Date();
    exdate.setDate(exdate.getDate() + exdays);
    var cookieValue = escape(value) + ((exdays==null) ? "" : "; expires=" + exdate.toUTCString());
    document.cookie = cookieName + "=" + cookieValue;
}

function deleteCookie(cookieName){
    var expireDate = new Date();
    expireDate.setDate(expireDate.getDate() - 1);
    document.cookie = cookieName + "= " + "; expires=" + expireDate.toUTCString();
}

function getCookie(cookieName) {
    cookieName = cookieName + '=';
    var cookieData = document.cookie;
    var start = cookieData.indexOf(cookieName);
    var cookieValue = '';
    if(start != -1){
        start += cookieName.length;
        var end = cookieData.indexOf(';', start);
        if(end == -1)end = cookieData.length;
        cookieValue = cookieData.substring(start, end);
    }
    return unescape(cookieValue);
}
</script>