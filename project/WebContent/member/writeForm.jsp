<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<div class="container">
    <form class="form-horizontal" name="writeForm" role="form" method="post" action="/project/member/write.do">
    	<br><br>
          <div class="form-group" id="divTitle">
          	<label for="title" class="col-lg-2 control-label">
          		<h2>회원가입</h2>
          	</label>
          </div>
          <hr>
          <div class="form-group" id="divId">
              <label for="inputId" class="col-lg-2 control-label">아이디</label>
              <div class="col-lg-10">
                  <input type="text" class="form-control" name="id" id="id" placeholder="4자이상 12자내의 소문자,숫자만 입력 가능합니다." maxlength="12" required>
              	<div class="check_font" id="id_check"></div>
              </div>
          </div>
          <div class="form-group" id="divPassword">
              <label for="inputPassword" class="col-lg-2 control-label">비밀번호</label>
              <div class="col-lg-10">
                  <input type="password" class="form-control" name="pwd" id="pwd" placeholder="4자이상 16자내의 대소문자,숫자만 입력 가능합니다." maxlength="16" required>
              	<div class="check_font" id="pwd_check"></div>
              </div>
          </div>
          <div class="form-group" id="divPasswordCheck">
              <label for="inputPasswordCheck" class="col-lg-2 control-label">비밀번호 확인</label>
              <div class="col-lg-10">
                  <input type="password" class="form-control" name="pwd2" id="pwd2" placeholder="4자이상 16자내의 대소문자,숫자만 입력 가능합니다." maxlength="16" required>
              	<div class="check_font" id="pwd2_check"></div>
              </div>
          </div>
          <div class="form-group" id="divName">
              <label for="inputName" class="col-lg-2 control-label">이름</label>
              <div class="col-lg-10">
                  <input type="text" class="form-control" id="name" name="name" placeholder="한글만 입력 가능합니다." maxlength="15" required>
             		<div class="check_font" id="name_check"></div>
              </div>
          </div>
          <div class="form-group" id="divEmail">
              <label for="inputEmail" class="col-lg-2 control-label">이메일</label>
              <div class="col-lg-10">
                  <input type="email" class="form-control" id="email" name="email" placeholder="ex)abc@gmail.com" maxlength="40" required>
              	<div class="check_font" id="email_check"></div>
              </div>
          </div>
          <div class="form-group" id="divTel">
              <label for="inputTel" class="col-lg-2 control-label">휴대폰 번호</label>
              <div class="col-lg-10">
                  <input type="tel" class="form-control" id="tel" name="tel" placeholder="-를 제외하고 숫자만 입력하세요." maxlength="11" required>
              	<div class="check_font" id="tel_check"></div>
              </div>
          </div>
          <div class="form-group" id="divBirth">
		<label for="inputEmail" class="col-lg-2 control-label">생년월일</label>
          	<div class="col-lg-10">
          		<input type="text" class="form-control" id="birthday" name="birthday" placeholder="ex)yyyymmdd" maxlength="8" required>
          		<div class="check_font" id="birth_check"></div>
          	</div>
          </div>
          <div class="form-group" id="divAddress">
          	<label for="inputAddress" class="col-lg-2 control-label">주소</label>
          	<div class="col-lg-10">
          		<input type="button" class="btn btn-secondary" value="우편번호검색" onclick="checkPost()">
          		<input type="text" name="zipcode" id="daum_zipcode" class="form-control" placeholder="우편번호" readonly required>
          		<input type="text" name="addr1" id="daum_addr1" class="form-control" placeholder="주소" readonly required>
      			<input type="text" name="addr2" id="daum_addr2" class="form-control" placeholder="상세 주소" required>
          	</div>
          </div>
          <div class="form-group">
              <div class="col-lg-offset-2 col-lg-10">
                  <button type="submit" id="submit" class="btn btn-secondary">확인</button>
                  <button type="button" class="btn btn-secondary" onclick="location.href='/project/main/index.do'">취소</button> 
              </div>
          </div>
	</form>
</div>

<script src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>
<script src="../js/member.js" type="text/javascript"></script>
