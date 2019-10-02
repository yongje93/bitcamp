<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<div class="section-title">
	<h4>문의하기</h4>
</div>
<div class="section">
	<div id="formDiv">
	<form role="form" method="post" onsubmit="return postForm();" action="/project/service/serviceBoardWrite.do">
		<div id="subjectDiv">
			<label id="subjectLabel" for="title">제목</label>
			<input type="text" name="subject" id="subject" placeholder="제목을 입력하세요" style="width: 960px" required>
		</div>
		<div id="authorDiv">
			<label id="authorLabel" for="title">작성자</label>
			<input type="text" name="name" id=name style="width: 960px" value="${memName}" required>
		</div>
		<textarea name="content" style="display: none;"></textarea>
		<div id="summernoteDiv">
			<div id="summernote"></div>
		</div>
		<div id="button">
			<button type="submit" id="submit" class="btn btn-secondary">확인</button>
			<button type="button" class="btn btn-secondary" onclick="location.href='/project/service/serviceBoardList.do?pg=1'">취소</button>
		</div>
	</form>
	</div>
</div>

<script>
$(document).ready(function() {
    $("#summernote").summernote({
    	placeholder: "문의하실 내용을 입력하세요",
        height: 330,
        disableResizeEditor: true,
    });
});

function postForm() {
	if ($("#summernote").summernote("isEmpty")) {
		alert("내용을 입력하세요");
		$("#summernote").summernote("focus");
		return false;
	} else {
		var content = $("textarea[name='content']").val($("#summernote").summernote("code"));
		return true;
	}
}
</script>