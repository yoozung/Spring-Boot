package com.work.interceptor;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import lombok.extern.slf4j.Slf4j;

@Component("needToAdminInterceptor")
@Slf4j
public class NeedToAdminInterceptor implements HandlerInterceptor {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		// beforeActionInterceptor 인터셉터에서 요청객체 설정해놓은 
		boolean isLogin = (boolean)request.getAttribute("isLogin");
		boolean isAdmin = (boolean)request.getAttribute("isAdmin");
		log.debug("### needToAdminInterceptor isLogin : " + isLogin);
		log.debug("### needToAdminInterceptor isAdmin : " + isAdmin);
		
		if (!isLogin) {
			response.setContentType("text/html;charset=utf-8");
			PrintWriter out = response.getWriter();		
			out.append("<script>");
			out.append("alert('로그인 인증 후에 이용해주세요');");
			out.append("location.replace('/loginForm');");
			out.append("</script>");
			return false;
		}
		
		if (!isAdmin) {
			response.setContentType("text/html;charset=utf-8");
			PrintWriter out = response.getWriter();		
			out.append("<script>");
			out.append("alert('관리자 인증 후에 이용해주세요');");
			out.append("history.back();");
			out.append("</script>");
			return false;
		}
		
		return HandlerInterceptor.super.preHandle(request, response, handler);
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub
		HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// TODO Auto-generated method stub
		HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
	}

}
