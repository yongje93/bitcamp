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