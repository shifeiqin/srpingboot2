package com.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @Description: TODO(用一句话描述该文件做什么)
 * 		Servlet Filter implementation class ServletFilter
 * 		注解注册过滤器：实现 javax.servlet.Filter接口 
 * 		filterName 是过滤器的名字
 * 		urlPatterns 是需要过滤的请求 ，这里只过滤servlet/* 下面的所有请求
 * @author FayQ
 * @date 2018年7月6日
 * @version V1.0
 * @email 1010046660@qq.com
 */
@WebFilter(filterName="ServletFilter",urlPatterns="/*")
public class ServletFilter implements Filter {
	
	//标示符：表示当前用户未登录(可根据自己项目需要改为json样式)
    String NO_LOGIN = "no login";

    //不需要登录就可以访问的路径(比如:注册登录等)
    String[] includeUrls = new String[]{"/login","register"};
    
    /**
     * Default constructor. 
     */
    public ServletFilter() {
        // TODO Auto-generated constructor stub
    }

    /**
     * @see Filter#destroy()
     */
    public void destroy() {
        System.out.println("过滤器被销毁。");
    }

    /**
     * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
     */
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
       
    	HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        HttpSession session = request.getSession(false);
        String uri = request.getRequestURI();

        System.out.println("filter url:"+uri);
        //是否需要过滤
        boolean needFilter = isNeedFilter(uri);


        if (!needFilter) { //不需要过滤直接传给下一个过滤器
            filterChain.doFilter(servletRequest, servletResponse);
        } else { //需要过滤器
            // session中包含user对象,则是登录状态
          if(session!=null&&session.getAttribute("user") != null){
                // System.out.println("user:"+session.getAttribute("user"));
                filterChain.doFilter(request, response);
            }else{
            	 response.getWriter().write(this.NO_LOGIN);
//                String requestType = request.getHeader("X-Requested-With");
//                //判断是否是ajax请求
//                if(requestType!=null && "XMLHttpRequest".equals(requestType)){
//                    response.getWriter().write(this.NO_LOGIN);
//                }else{
//                    //重定向到登录页(需要在static文件夹下建立此html文件)
//                    response.sendRedirect(request.getContextPath()+"/user/login.html");
//                }
                return;
            }
        }
    }
    /**
     * @Author: xxxxx
     * @Description: 是否需要过滤
     * @Date: 2018-03-12 13:20:54
     * @param uri
     */
    public boolean isNeedFilter(String uri) {

        for (String includeUrl : includeUrls) {
            if(includeUrl.equals(uri)) {
                return false;
            }
        }

        return true;
    }
    /**
     * @see Filter#init(FilterConfig)
     */
    public void init(FilterConfig fConfig) throws ServletException {
        System.out.println("初始化过滤器。");
    }

}