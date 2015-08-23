package cn.com.kington.webapp.security;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.com.kington.common.Constants;
import cn.com.kington.utils.FunctionTools;

public class SecurityFilter implements Filter {

	public void destroy() {
		
	}

	public void doFilter(ServletRequest arg0, ServletResponse arg1,
			FilterChain chain) throws IOException, ServletException {
		HttpServletRequest request=(HttpServletRequest)arg0;
		HttpServletResponse response=(HttpServletResponse)arg1;
		HttpSession session=request.getSession();
		
		String ctxpath = request.getContextPath();
		String uri = request.getRequestURI().substring(ctxpath.length());
		
		if( !uri.endsWith(".css") 
				&& !uri.endsWith(".gif") 
				&& !uri.endsWith(".png") 
				&& !uri.endsWith(".jpg") 
				&& !uri.endsWith(".jpeg") 
				&& !uri.endsWith(".bmp") 
				&& !uri.endsWith(".gif") 
				&& !uri.endsWith(".js") 
				&& !uri.endsWith("/login-index.jsp") 
				&& !uri.endsWith("/image.jsp") ){
			if(session.getAttribute(Constants.DEFAULT_USER_LOGIN)==null){
				FunctionTools.showMsgAndOutFrame(response, "请先登陆后执行该操作！", request.getContextPath()+"/login/index.jhtml");
				return;
			}
		}
		chain.doFilter(request, response);
	}

	public void init(FilterConfig arg0) throws ServletException {
		
	}

}

