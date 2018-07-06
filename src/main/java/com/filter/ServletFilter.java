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
 * @Description: TODO(��һ�仰�������ļ���ʲô)
 * 		Servlet Filter implementation class ServletFilter
 * 		ע��ע���������ʵ�� javax.servlet.Filter�ӿ� 
 * 		filterName �ǹ�����������
 * 		urlPatterns ����Ҫ���˵����� ������ֻ����servlet/* �������������
 * @author FayQ
 * @date 2018��7��6��
 * @version V1.0
 * @email 1010046660@qq.com
 */
@WebFilter(filterName="ServletFilter",urlPatterns="/*")
public class ServletFilter implements Filter {
	
	//��ʾ������ʾ��ǰ�û�δ��¼(�ɸ����Լ���Ŀ��Ҫ��Ϊjson��ʽ)
    String NO_LOGIN = "no login";

    //����Ҫ��¼�Ϳ��Է��ʵ�·��(����:ע���¼��)
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
        System.out.println("�����������١�");
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
        //�Ƿ���Ҫ����
        boolean needFilter = isNeedFilter(uri);


        if (!needFilter) { //����Ҫ����ֱ�Ӵ�����һ��������
            filterChain.doFilter(servletRequest, servletResponse);
        } else { //��Ҫ������
            // session�а���user����,���ǵ�¼״̬
          if(session!=null&&session.getAttribute("user") != null){
                // System.out.println("user:"+session.getAttribute("user"));
                filterChain.doFilter(request, response);
            }else{
            	 response.getWriter().write(this.NO_LOGIN);
//                String requestType = request.getHeader("X-Requested-With");
//                //�ж��Ƿ���ajax����
//                if(requestType!=null && "XMLHttpRequest".equals(requestType)){
//                    response.getWriter().write(this.NO_LOGIN);
//                }else{
//                    //�ض��򵽵�¼ҳ(��Ҫ��static�ļ����½�����html�ļ�)
//                    response.sendRedirect(request.getContextPath()+"/user/login.html");
//                }
                return;
            }
        }
    }
    /**
     * @Author: xxxxx
     * @Description: �Ƿ���Ҫ����
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
        System.out.println("��ʼ����������");
    }

}