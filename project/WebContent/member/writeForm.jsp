<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
<!-- jQuery library -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<!-- Popper JS -->
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
<!-- Latest compiled JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>

<div class="container">
    <form class="form-horizontal" name="writeForm" role="form" method="post" action="/project/member/write.do">
    	<br><br>
          <div class="form-group" id="divTitle">
          	<label for="title" class="col-lg-2 control-label">
          		<h3>회원가입</h3>
          	</label>
          </div>
          <hr>
          <div class="form-group" id="divId">
              <label for="inputId" class="col-lg-2 control-label">아이디</label>
              <div class="col-lg-10">
                  <input type="text" class="form-control" name="id" id="id" placeholder="4자이상 12자내의 알파벳, 숫자만 입력 가능합니다." maxlength="12" required>
              	<div class="check_font" id="id_check"></div>
              </div>
          </div>
          <div class="form-group" id="divPassword">
              <label for="inputPassword" class="col-lg-2 control-label">패스워드</label>
              <div class="col-lg-10">
                  <input type="password" class="form-control" name="pwd" id="pwd" placeholder="패스워드" maxlength="30" required>
              	<div class="check_font" id="pwd_check"></div>
              </div>
          </div>
          <div class="form-group" id="divPasswordCheck">
              <label for="inputPasswordCheck" class="col-lg-2 control-label">패스워드 확인</label>
              <div class="col-lg-10">
                  <input type="password" class="form-control" name="pwd2" id="pwd2" placeholder="패스워드 확인" maxlength="30" required>
              	<div class="check_font" id="pwd2_check"></div>
              </div>
          </div>
          <div class="form-group" id="divName">
              <label for="inputName" class="col-lg-2 control-label">이름</label>
              <div class="col-lg-10">
                  <input type="text" class="form-control" id="name" name="name" placeholder="한글만 입력 가능합니다." maxlength="15" required>
             		<div class="check_font" id="name_check"></div>
              </div>
          </div>
          <div class="form-group" id="divEmail">
              <label for="inputEmail" class="col-lg-2 control-label">이메일</label>
              <div class="col-lg-10">
                  <input type="email" class="form-control" id="email" name="email" placeholder="이메일" maxlength="40" required>
              	<div class="check_font" id="email_check"></div>
              </div>
          </div>
          <div class="form-group" id="divTel">
              <label for="inputTel" class="col-lg-2 control-label">휴대폰 번호</label>
              <div class="col-lg-10">
                  <input type="tel" class="form-control" id="tel" name="tel" placeholder="-를 제외하고 숫자만 입력하세요." maxlength="11" required>
              	<div class="check_font" id="tel_check"></div>
              </div>
          </div>
          <div class="form-group" id="divBirth">
		<label for="inputEmail" class="col-lg-2 control-label">생년월일</label>
          	<div class="col-lg-10">
          		<input type="text" class="form-control" id="birthday" name="birthday" placeholder="ex)yyyymmdd" maxlength="8" required>
          		<div class="check_font" id="birth_check"></div>
          	</div>
          </div>
          <div class="form-group" id="divAddress">
          	<label for="inputAddress" class="col-lg-2 control-label">주소</label>
          	<div class="col-lg-10">
          		<input type="button" class="btn btn-dark" value="우편번호검색" onclick="checkPost()">
          		<input type="text" name="zipcode" id="daum_zipcode" class="form-control" placeholder="우편번호" readonly required>
          		<input type="text" name="addr1" id="daum_addr1" class="form-control" placeholder="주소" readonly required>
      			<input type="text" name="addr2" id="daum_addr2" class="form-control" placeholder="상세 주소" required>
          	</div>
          </div>
          <div class="form-group">
              <div class="col-lg-offset-2 col-lg-10">
                  <button type="submit" id="submit" class="btn btn-dark">확인</button>
                  <button type="button" class="btn btn-dark" onclick="location.href='/project/main/index.do'">취소</button> 
              </div>
          </div>
	</form>
</div>

<script src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>
<script src="../js/member.js" type="text/javascript"></script>
<script type="text/javascript">
//모든 공백 체크 정규식
var empJ = /\s/g;
//아이디 정규식
var idJ = /^[a-z0-9]{4,12}$/;
// 비밀번호 정규식
var pwJ = /^[A-Za-z0-9]{4,12}$/; 
// 이름 정규식
var nameJ = /^[가-힣]{2,6}$/;
// 이메일 검사 정규식
var mailJ = /^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}$/i;
// 휴대폰 번호 정규식
var phoneJ = /^01([0|1|6|7|8|9]?)?([0-9]{3,4})?([0-9]{4})$/;
//생일 유효성 검사
var birthJ = false;

$(function() {
	// 아이디
	$("#id").blur(function(){
		if(idJ.test($(this).val())) {
			$("#id_check").text("");
		} else {
			$("#id_check").text("이름을 확인해주세요");
			$("#id_check").css("color", "red");
			$("#id_check").css("font-size", "9pt");
		}
	});
	
	// 아이디 중복확인
	$("#id").blur(function(){
		$.ajax({
			type	: "post",
			url		: "/project/member/checkId.do",
			data	: "id="+$("#id").val(),
			dataType: "text",
			success : function(data){
				if(data.trim() == "ok") {
					$("#id_check").text("아이디 사용가능");
					$("#id_check").css("color", "blue");
					$("#id_check").css("font-size", "9pt");
				} else if(data.trim() == "fail") {
					$("#id_check").text("아이디 중복 사용불가");
					$("#id_check").css("color", "red");
					$("#id_check").css("font-size", "9pt");
					$("#id").focus();
				}
			}
		});
	});
	
	// 패스워드
	$("#pwd").blur(function(){
		if(pwJ.test($(this).val())) {
			$("#pwd_check").text("");
		} else {
			$("#pwd_check").text("비밀번호를 확인해주세요");
			$("#pwd_check").css("color", "red");
			$("#pwd_check").css("font-size", "9pt");
		}
	});
	// 패스워드 확인
	$("#pwd2").blur(function(){
		if(pwJ.test($(this).val())) {
			$("#pwd2_check").text("");
		} else {
			$("#pwd2_check").text("비밀번호를 확인해주세요");
			$("#pwd2_check").css("color", "red");
			$("#pwd2_check").css("font-size", "9pt");
		}
	});
	// 이름
	$("#name").blur(function(){
		if(nameJ.test($(this).val())) {
			$("#name_check").text("");
		} else {
			$("#name_check").text("이름을 확인해주세요");
			$("#name_check").css("color", "red");
			$("#name_check").css("font-size", "9pt");
		}
	});
	// 이메일
	$("#email").blur(function(){
		if(mailJ.test($(this).val())) {
			$("#email_check").text("");
		} else {
			$("#email_check").text("이메일을 확인해주세요");
			$("#email_check").css("color", "red");
			$("#email_check").css("font-size", "9pt");
		}
	});
	// 전화번호
	$("#tel").blur(function(){
		if(phoneJ.test($(this).val())) {
			$("#tel_check").text("");
		} else {
			$("#tel_check").text("전화번호를 확인해주세요");
			$("#tel_check").css("color", "red");
			$("#tel_check").css("font-size", "9pt");
		}
	});
	// 생년월일	birthJ 유효성 검사
	$("#birthday").blur(function(){
		var dateStr = $(this).val();		
	    var year = Number(dateStr.substr(0,4)); // 입력한 값의 0~4자리까지 (연)
	    var month = Number(dateStr.substr(4,2)); // 입력한 값의 4번째 자리부터 2자리 숫자 (월)
	    var day = Number(dateStr.substr(6,2)); // 입력한 값 6번째 자리부터 2자리 숫자 (일)
	    var today = new Date(); // 날짜 변수 선언
	    var yearNow = today.getFullYear(); // 올해 연도 가져옴
		
	    if (dateStr.length <=8) {
			// 연도의 경우 1900 보다 작거나 yearNow 보다 크다면 false를 반환합니다.
		    if (1900 > year || year > yearNow){
		    	
		    	$("#birth_check").text("생년월일을 확인해주세요");
				$("#birth_check").css("color", "red");
				$("#birth_check").css("font-size", "9pt");
		    	
		    } else if (month<1 || month>12) {
		    		
		    	$("#birth_check").text("생년월일을 확인해주세요");
				$("#birth_check").css("color", "red"); 
				$("#birth_check").css("font-size", "9pt");
		    
		    }else if (day<1 || day>31) {
		    	
		    	$("#birth_check").text("생년월일을 확인해주세요");
				$("#birth_check").css("color", "red"); 
				$("#birth_check").css("font-size", "9pt");
		    	
		    }else if ((month==4 || month==6 || month==9 || month==11) && day==31) {
		    	 
		    	$("#birth_check").text("생년월일을 확인해주세요");
				$("#birth_check").css("color", "red"); 
				$("#birth_check").css("font-size", "9pt");
		    	 
		    }else if (month == 2) {
		    	 
		       	var isleap = (year % 4 == 0 && (year % 100 != 0 || year % 400 == 0));
		       	
		     	if (day>29 || (day==29 && !isleap)) {
		     		
		     		$("#birth_check").text("생년월일을 확인해주세요");
					$("#birth_check").css("color", "red"); 
					$("#birth_check").css("font-size", "9pt");
		    	
				}else{
					$("#birth_check").text("");
					birthJ = true;
				}//end of if (day>29 || (day==29 && !isleap))
		     	
		    }else{
		    	
		    	$("#birth_check").text(""); 
				birthJ = true;
			}//end of if
			
			}else{
				//1.입력된 생년월일이 8자 초과할때 :  auth:false
				$("#birth_check").text("생년월일을 확인해주세요");
				$("#birth_check").css("color", "red");  
				$("#birth_check").css("font-size", "9pt");
			}
		}); //End of method /*
		
});
</script>