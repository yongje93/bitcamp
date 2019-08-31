//게시판 글쓰기 유효성 검사
function checkBoardWrite() {
	if(document.boardWriteForm.subject.value == "") {
		alert("제목을 입력하세요")
		document.boardWriteForm.subject.focus();
	} else if(document.boardWriteForm.content.value == "") {
		alert("내용을 입력하세요")
		document.boardWriteForm.content.focus();
	} else {
		document.boardWriteForm.submit();
	}
}

//게시글 눌렀을때 로그인 중인지 확인
function isLogin(id, seq) {
	if(id == null) {
		alert("먼저 로그인하세요");
	} else {
		location.href="boardView.jsp?seq="+seq;
	}
}