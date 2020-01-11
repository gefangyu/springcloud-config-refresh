package com.gefangyu.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

/**
 * @author ge.fangyu
 * @version 1.0.0
 * @description 字符编码过滤器
 * @date 2020-01-11 21:43
 * @since JDK 1.8
 */
// @WebFilter(urlPatterns = "/*", filterName = "CharacterEncodingFilter")
public class CharacterEncodingFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        request.setCharacterEncoding(StandardCharsets.UTF_8.toString());
        response.setCharacterEncoding(StandardCharsets.UTF_8.toString());
        filterChain.doFilter(request , response);
    }

    @Override
    public void destroy() {

    }
}
