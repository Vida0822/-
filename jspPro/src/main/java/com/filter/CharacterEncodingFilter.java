package com.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class CharacterEncodingFilter implements Filter {// import javax.servlet.Filter; 임 ! 

	private String encoding ;

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		this.encoding = filterConfig.getInitParameter("encoding"); 
	} // init

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// System.out.println(">CharacterEncodingFilter 필터 호출됨");
		request.setCharacterEncoding(this.encoding);
		chain.doFilter(request, response);
	} // doFilter

	@Override
	public void destroy() {
	} // destroy

	
	
	
	
} // CharacterEncodingFilter
