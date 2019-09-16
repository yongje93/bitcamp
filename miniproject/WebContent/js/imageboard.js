//이미지 게시판 유효성 검사
function checkImageboard() {
	if(document.getElementById("imageId").value == "img_") {
		alert("상품코드를 입력하세요");
		document.getElementById("imageId").focus();
	} else if(document.getElementById("imageName").value == "") {
		alert("상품명을 입력하세요");
		document.getElementById("imageName").focus();
	} else if(document.getElementById("imagePrice").value == "") {
		alert("단가를 입력하세요");
		document.getElementById("imagePrice").focus();
	} else if(document.getElementById("imageQty").value == "") {
		alert("갯수를 입력하세요");
		document.getElementById("imageQty").focus();
	} else if(document.getElementById("imageContent").value == "") {
		alert("상품내용을 입력하세요");
		document.getElementById("imageContent").focus();
	} else
		document.imageboardWriteForm.submit();
}
