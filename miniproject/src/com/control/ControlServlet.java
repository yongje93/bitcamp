package com.control;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ControlServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private Map<String, Object> map = new HashMap<String, Object>();

	@Override
	public void init(ServletConfig config) throws ServletException {
		String propertyConfig = config.getInitParameter("propertyConfig");
		System.out.println("propertyConfig="+propertyConfig);
		
		FileInputStream fin = null;
		Properties properties = new Properties();	//외부에서 설정한 환경설정 파일의 내용을 보관
		
		try {
			fin = new FileInputStream(propertyConfig);
			properties.load(fin);
			System.out.println("properties="+properties);
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				fin.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		Iterator it = properties.keySet().iterator();
		while(it.hasNext()) {
			String key = (String) it.next();
			System.out.println("key="+key);
			
			String className = properties.getProperty(key);
			System.out.println("className="+className);
			
			try {
				Class classType = Class.forName(className);
				Object ob = classType.newInstance();
				System.out.println("ob="+ob);
				
				map.put(key, ob);
				
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (InstantiationException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		execute(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		execute(request, response);
	}
	
	protected void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println();
		
		//한글처리
		if(request.getMethod().equals("POST")) {
			request.setCharacterEncoding("UTF-8");
		}
		
		String category = request.getServletPath();
		System.out.println("category="+category);
		
		CommandProcess commandProcess = (CommandProcess) map.get(category);
		System.out.println("commandProcess="+commandProcess);
		
		String view = null;
		try {
			view = commandProcess.requestPro(request, response);
		} catch (Throwable e) {
			e.printStackTrace();
		}
		
		// forward
		RequestDispatcher dispatcher = request.getRequestDispatcher(view);// 상대번지
		dispatcher.forward(request, response);// 제어권 넘기기
	}

}
