package edu.kh.hotellala.common.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

import edu.kh.hotellala.common.wrapper.EncryptWrapper;


//암호화를 적용해야 하는 요청의 종류 : 로그인, 회원가입 , 비밀번호 변경 , 회원 탈퇴
//  /member/login  , /member/signUp , /member/~~~

// 필터가 적용되어야 하는 url이 여러개인 경우 String 배열 초기화 형태로 작성하면 된다
// String 배열에서 바로 초기화 하듯이 문자열 배열 형태로 저장하면 된다. {"123", "456", "789"}

@WebFilter(filterName="encryptFilter" , urlPatterns = {"/login",
														"/admin/signUp"})  
public class EncryptFilter extends HttpFilter implements Filter {

	public void destroy() {
	}
	public void init(FilterConfig fConfig) throws ServletException {
		
	}
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		
		HttpServletRequest  req = (HttpServletRequest)request;
		
		EncryptWrapper wrapper = new EncryptWrapper(req);
		
		chain.doFilter(wrapper, response);
	}
}
