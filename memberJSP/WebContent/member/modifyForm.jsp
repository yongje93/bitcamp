<%@ page import="member.bean.MemberDTO"%>
<%@ page import="member.dao.MemberDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
	// 데이터
	String id = request.getParameter("id");
	
	// DB
	MemberDAO memberDAO = MemberDAO.getInstance();
	MemberDTO memberDTO = memberDAO.getMember(id);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원정보수정</title>
</head>
<script type="text/javascript">
function init() {
	setGender("<%= memberDTO.getGender() %>");
	setEmail("<%= memberDTO.getEmail2() %>");
	setTel("<%= memberDTO.getTel1() %>");
}

function setGender(val) {
	//console.log(val);
	document.modifyForm.gender[val].checked = true;
}

function setEmail(val) {
	//console.log(val);
	document.modifyForm.email2.value = val;
	
}

function setTel(val) {
	//console.log(val);
	var selectTel = document.getElementById("tel1");
	for(i=0, j=selectTel.length; i < j; i++) {
		if(selectTel.options[i].value == val) {
			selectTel.options[i].selected = true;
			break;
		}
	}	
}

</script>
<body onload="init()">
<form name="modifyForm" method="post" action="modify.jsp">
      <h1>회원정보수정</h1>
      <table border="1" cellspacing="0" cellpadding="5">
        <tr>
          <th width="80">이름</th>
          <td><input type="text" id="name" name="name" size="15" value="<%=memberDTO.getName() %>"></td>
        </tr>
        <tr>
          <th width="80">아이디</th>
          <td>
          	<input type="text" id="id" name="id" style="width: 200px;" value="<%=memberDTO.getId() %>" readonly>
          </td>
        </tr>
        <tr>
          <th width="80">비밀번호</th>
          <td><input type="password" id="pwd" name="pwd" style="width: 230px;"></td>
        </tr>
        <tr>
          <th width="80">재확인</th>
          <td><input type="password" id="repwd" name="repwd" style="width: 230px;"></td>
        </tr>
        <tr>
          <th width="80">성별</th>
          <td>
            <input type="radio" name="gender" value="0">남&nbsp;
            <input type="radio" name="gender" value="1">여
          </td>
        </tr>
        <tr>
          <th width="80">이메일</th>
          <td>
            <input type="text" name="email1" style="width: 120px;" value="<%=memberDTO.getEmail1() %>">
            &nbsp;@&nbsp;
            <input type="text" name="email2" list="list">
            <datalist id="list">
              <option value="naver.com"></option>
              <option value="gmail.com"></option>
              <option value="daum.net"></option>
              <option value="nate.net"></option>
            </datalist>
          </td>
        </tr>
        <tr>
          <th width="80">핸드폰</th>
          <td>
            <select id="tel1" name="tel1" style="width: 55px;">
              <option value="010">010</option>
              <option value="016">016</option>
              <option value="019">019</option>
            </select>
            -
            <input type="text" name="tel2" style="width: 50px;" value="<%=memberDTO.getTel2() %>">
            -
            <input type="text" name="tel3" style="width: 50px;" value="<%=memberDTO.getTel3() %>">
          </td>
        </tr>
        <tr>
          <th width="80">주소</th>
          <td>
            <input type="text" name="zipcode" id="daum_zipcode" style="width: 70px;" readonly value="<%=memberDTO.getZipcode() %>">
            <input type="button" value="우편번호검색" onclick="checkPost()"><br>
            <input type="text" name="addr1" id="daum_addr1" placeholder="주소" style="width: 350px;" readonly value="<%=memberDTO.getAddr1() %>"><br>
            <input type="text" name="addr2" id="daum_addr2" placeholder="상세 주소" style="width: 350px;" value="<%=memberDTO.getAddr2() %>">
          </td>
        </tr>
        <tr>
          <td colspan="2" align="center">
            <input type="button" value="회원정보수정" onclick="checkModify()">
            <input type="reset" value="다시작성">
          </td>
        </tr>
      </table>
    </form>
</body>
<script src="../js/member.js" type="text/javascript"></script>
</html>