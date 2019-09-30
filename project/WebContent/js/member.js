// 회원가입 창에서 주소 검색
function checkPost() {
	new daum.Postcode({
		oncomplete : function(data) {
			// 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.

			// 각 주소의 노출 규칙에 따라 주소를 조합한다.
			// 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
			var addr = ''; // 주소 변수
			var extraAddr = ''; // 참고항목 변수

			// 사용자가 선택한 주소 타입에 따라 해당 주소 값을 가져온다.
			if (data.userSelectedType === 'R') { // 사용자가 도로명 주소를 선택했을 경우
				addr = data.roadAddress;
			} else { // 사용자가 지번 주소를 선택했을 경우(J)
				addr = data.jibunAddress;
			}

			// 사용자가 선택한 주소가 도로명 타입일때 참고항목을 조합한다.
			if (data.userSelectedType === 'R') {
				// 법정동명이 있을 경우 추가한다. (법정리는 제외)
				// 법정동의 경우 마지막 문자가 "동/로/가"로 끝난다.
				if (data.bname !== '' && /[동|로|가]$/g.test(data.bname)) {
					extraAddr += data.bname;
				}
				// 건물명이 있고, 공동주택일 경우 추가한다.
				if (data.buildingName !== '' && data.apartment === 'Y') {
					extraAddr += (extraAddr !== '' ? ', ' + data.buildingName
							: data.buildingName);
				}
				// 표시할 참고항목이 있을 경우, 괄호까지 추가한 최종 문자열을 만든다.
				if (extraAddr !== '') {
					extraAddr = ' (' + extraAddr + ')';
				}
				// 조합된 참고항목을 해당 필드에 넣는다.
				// document.getElementById("sample6_extraAddress").value =
				// extraAddr;

			} else {
				// document.getElementById("sample6_extraAddress").value = '';
			}

			// 우편번호와 주소 정보를 해당 필드에 넣는다.
			document.getElementById('daum_zipcode').value = data.zonecode;
			document.getElementById("daum_addr1").value = addr;
			// 커서를 상세주소 필드로 이동한다.
			document.getElementById("daum_addr2").focus();
		}
	}).open();
}

// 회원 가입시 유효성 및 정규식
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
		} else {
			$("#id_check").text("아이디를 확인해주세요");
			$("#id_check").css("color", "red");
			$("#id_check").css("font-size", "9pt");
		}
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
