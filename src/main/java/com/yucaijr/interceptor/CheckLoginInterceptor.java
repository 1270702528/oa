package com.yucaijr.interceptor;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.servlet.HandlerInterceptor;


public class CheckLoginInterceptor implements  HandlerInterceptor  {

	@Value("${server.servlet.path}")
	private String contextPath;
	
	@Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
		Object obj= request.getSession().getAttribute("user");
		String userAgent=request.getHeader("User-Agent");
		if(obj==null){
			if(userAgent.contains("Windows")){
				response.sendRedirect(contextPath);
			}else if(userAgent.contains("iPhone")){
				response.sendRedirect(contextPath+"mobile/index.html");
			}else if(userAgent.contains("Mac OS")){
				response.sendRedirect(contextPath);
			}else {
				response.sendRedirect(contextPath+"mobile/index.html");
			}
			return false;
		}
        return true;
    }

    
}
