package com.handao.platform.framework.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;
/**
 * ��̬��Դ�����࣬���ڼ���http 304����
 */
public class CacheFilter implements Filter{
	
    private String cacheControl = "public";
    private long expiresTime = 0;
    /**
     * ��ʼ������
     */
    public void init(FilterConfig filterConfig) throws ServletException{
        if (filterConfig.getInitParameter("Cache-Control") != null){
            this.cacheControl = filterConfig.getInitParameter("Cache-Control");
        }
        if (filterConfig.getInitParameter("Expires") != null){
            String times[] = filterConfig.getInitParameter("Expires").split("x");
            this.expiresTime = 1;
            for (int i = 0; i < times.length; i++){
                this.expiresTime = this.expiresTime * Long.parseLong(times[i]);
            }
        }
    }
    /**
     * ���˷���������Httpͷ
     */
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException
    {
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        response.setDateHeader("Expires", System.currentTimeMillis() + this.expiresTime + (long)(this.expiresTime * Math.random()));
        response.setHeader("Cache-Control", this.cacheControl);
        filterChain.doFilter(servletRequest, response);
    }
    /**
     * destroy*(�ӿڷ���)
     */    
    public void destroy(){
    }
}

