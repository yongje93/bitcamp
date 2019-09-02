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

//게시글 누를때 로그인 확인
function isLogin(memId, seq, pg) {
	if(memId=="")
		alert("먼저 로그인하세요");
	else
		location.href="boardView.jsp?seq="+seq+"&pg="+pg;
}

//게시글 삭제
function checkBoardDelete(seq) {
	if(confirm("정말 삭제하시겠습니까?") == true) {
		location.href="boardDelete.jsp?seq="+seq;
	} else
		return false;
}

//게시글 수정
function checkBoardModify() {
	if(document.boardModifyForm.subject.value == "") {
		alert("제목을 입력하세요")
		document.boardModifyForm.subject.focus();
	} else if(document.boardModifyForm.content.value == "") {
		alert("내용을 입력하세요")
		document.boardModifyForm.content.focus();
	} else {
		document.boardModifyForm.submit();
	}
}
