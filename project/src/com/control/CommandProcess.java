package com.control;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface CommandProcess {
	// jsp 파일명을 리턴해주는 함수
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable; //Exception의 부모인 Throwable
	
}
