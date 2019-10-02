<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="section-title">
	<h4>문의내용</h4>
</div>
<div class="section">
	<div id="formDiv">
	<form role="form" method="post" onsubmit="postForm()">
		<div id="subjectDiv">
			<label id="subjectLabel" for="title">제목</label>
			<span class="boardSpan">${serviceboardDTO.subject}</span>
		</div>
		<div id="authorDiv">
			<label id="authorLabel" for="title">작성자</label>
			<span class="boardSpan">${serviceboardDTO.name}</span>
		</div>
		<div id="summernoteDiv">
			<div id="summernote"></div>
		</div>
		<div class="boardViewContent"></div>
		<div id="button">
			<c:if test="${memId == 'admin'}">
				<button type="button" class="btn btn-secondary" onclick="location.href=''">답변</button>
				<button type="button" class="btn btn-secondary" onclick="">삭제</button>
			</c:if>
			<c:if test="${memId == serviceboardDTO.id }">
				<button type="button" class="btn btn-secondary" onclick="">삭제</button>
			</c:if>
			<button type="button" class="btn btn-secondary" onclick="location.href='/project/service/serviceBoardList.do?pg=${pg}'">목록</button>
		</div>
	</form>
	</div>
</div>
<script>
$(document).ready(function() {
	$(".boardViewContent").html('${serviceboardDTO.content}');
});

</script>