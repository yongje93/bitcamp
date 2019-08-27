// 회원가입 창에서 유효성 검사
function checkWrite() {
	if (document.writeForm.name.value == "") {
		alert("이름을 입력하세요");
		document.writeForm.name.focus();
	} else if (document.writeForm.id.value == "") {
		alert("아이디를 입력하세요");
		document.writeForm.id.focus();
	} else if(document.writeForm.idDuplication.value != "idCheck") {
		alert("중복체크 하세요")
	} else if (document.writeForm.pwd.value == "") {
		alert("비밀번호를 입력하세요");
		document.writeForm.pwd.focus();
	} else if (document.writeForm.repwd.value == "") {
		alert("비밀번호를 입력하세요");
		document.writeForm.repwd.focus();
	} else if (document.writeForm.pwd.value != document.writeForm.repwd.value) {
		alert("비밀번호가 맞지 않습니다");
	} else {
		document.writeForm.submit();
	}
}

// 아이디 중복체크
function checkId() {	//자바스크립트는 자료형이없다
	var sId = document.writeForm.id.value;
	if(sId == "")
		alert("먼저 아이디를 입력하세요");
	else
		window.open("http://localhost:8080/memberJSP/member/checkId.jsp?id="+sId,
					"",	"width=400 height=100 left=500 top=150 locations=yes");
}

function inputIdChk() {
	document.writeForm.idDuplication.value = "idUncheck";
}

// 중복 체크 후 창닫기
function checkIdClose(id) {
	opener.writeForm.id.value= id;
	opener.writeForm.idDuplication.value = "idCheck";
	window.close();
	opener.writeForm.pwd.focus();
}

// 회원가입 창에서 주소 검색
function checkPost() {
	console.log("주소 검색");
}

// 로그인 화면에서 로그인 유효성 검사
function checkLogin() {
	if (document.loginForm.id.value == "") {
		alert("아이디를 입력하세요");
		document.loginForm.id.focus();
	} else if (document.loginForm.pwd.value == "") {
		alert("비밀번호를 입력하세요");
		document.loginForm.pwd.focus();
	} else
		document.loginForm.submit();
}

