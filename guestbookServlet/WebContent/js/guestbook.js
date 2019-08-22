// 글쓰기 버튼 누를떄 제목이랑 내용 유효성 체크
function writeCheck() {
	if (document.guestbookWriteForm.subject.value == "") {
		alert("제목을 입력하세요");
		document.guestbookWriteForm.subject.focus();
	} else if (document.guestbookWriteForm.content.value == "") {
		alert("내용을 입력하세요");
		document.guestbookWriteForm.content.focus();
	} else 
		document.guestbookWriteForm.submit();
}