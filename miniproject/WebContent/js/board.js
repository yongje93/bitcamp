//게시판 글쓰기, 수정 유효성 검사
function checkBoard() {
	if(document.getElementById("subject").value == "") {
		alert("제목을 입력하세요")
		document.getElementById("subject").focus();
	} else if(document.getElementById("content").value == "") {
		alert("내용을 입력하세요")
		document.getElementById("content").focus();
	} else {
		document.forms[0].submit();
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
