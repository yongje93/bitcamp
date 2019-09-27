<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<link rel="stylesheet" type="text/css" href="../css/top.css">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
<div class="navigation">
	<div class="navigation-menu primary-menu">
		<ul>
			<li><a href="#">Home</a></li>
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
					<a data-toggle="modal" href="#myModal">로그인</a>
				</span>
			</li>
			<li class="bag is-empty">
				<span class="menu-item">
					<a href="">장바구니</a>
				</span>
			</li>
			<li class="search">
				<span class="menu-item search-button">
					<a href="">검색</a>
				</span>
			</li>
		</ul>
	</div>
</div>

<div class="container">
	<div class="modal fade" id="myModal">
		<div class="modal-dialog">
			<div class="modal-content">
	
				<div class="modal-header" style="padding:35px 50px;">
					<h4 class="modal-title">로그인</h4>
					<button type="button" class="close" data-dismiss="modal">&times;</button>
				</div>
			
				<div class="modal-body">
					<form role="form">
			            <div class="form-group">
			              <label for="id"> ID</label>
			              <input type="text" class="form-control" id="id" placeholder="아이디 입력">
			              <div id="idDiv"></div>
			            </div>
			            <div class="form-group">
			              <label for="pwd"> Password</label>
			              <input type="password" class="form-control" id="pwd" placeholder="패스워드 입력">
			           	  <div id="pwdDiv"></div>
			            </div>
			            <div class="checkbox">
			              <label><input type="checkbox" name="remember">&nbsp;아이디 저장</label>
			            </div>
			              <button type="submit" id="login-submit" class="btn btn-dark btn-block"> 로그인</button>
		          	</form>
				</div>

				<div class="modal-footer">
					<button type="button" class="btn btn-dark" onclick="location.href=''"> 회원가입</button>
		          	<button type="button" class="btn btn-danger" data-dismiss="modal">취소</button>
		        </div>
			</div>
		</div>
	</div>
</div>
<script type="text/javascript">
$(document).ready(function(){
	$("#login-submit").click(function(){
		$("#idDiv").empty();
		$("#pwdDiv").empty();
		
		var id = $("#id").val();
		var pwd = $("#pwd").val();
		
		if(id == "") {
			$("#idDiv").text("아이디를 입력하세요").css("color", "tomato").css("font-size", "8pt");
			$("#id").focus();
			return false;
		} else if(pwd == "") {
			$("#pwdDiv").text("비밀번호를 입력하세요").css("color", "tomato").css("font-size", "8pt");
			$("#pwd").focus();
			return false;
		} else {
			$.ajax({
				type	: "post",
				url		: "../member/login_json.jsp",
				data	: {id : $("#id").val(), pwd : $("#pwd").val()},
				dataType: "text",
				success : function(data) {
					if(data.trim() == "ok") {
						alert("로그인 성공");
					} else if(data.trim() == "fail") {
						alert("로그인 실패");
					}
				},
				error	: function(){
					alert("ajax error : "+textStatus +"  " + errorThrown);
				}
			});
		}

	});
	
	$('#myModal').on('hidden.bs.modal', function (e) {
	    $(this).find('form')[0].reset();
		$("#idDiv").empty();
		$("#pwdDiv").empty();
	});

});

</script>

