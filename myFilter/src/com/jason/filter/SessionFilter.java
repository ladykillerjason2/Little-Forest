package com.jason.filter;

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

public class SessionFilter implements Filter{

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse res,
			FilterChain chain) throws IOException, ServletException {
		HttpServletRequest request=(HttpServletRequest)req;
		HttpSession session=request.getSession();
		HttpServletResponse response=(HttpServletResponse)res;
		String user=(String) session.getAttribute("user");//返回值是objiect，需强制转换
		if(user!=null&&!user.equals("")){
			chain.doFilter(req, res);
		}else{
			String msg="你还没有登录！";
			request.setAttribute("Error", msg);
			request.getRequestDispatcher("/login.jsp").forward(request, response);
		}
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
		
	}

}
