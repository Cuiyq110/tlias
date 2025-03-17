package com.cuiyq.filter;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.cuiyq.domain.Result;
import com.cuiyq.utils.JwtUtils;
import com.github.pagehelper.util.StringUtil;
import io.jsonwebtoken.Claims;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

/**
 * @version V1.0
 * @Title:
 * @Description:登录过滤器
 * @Copyright 2024 Cuiyq
 * @author: Cuiyq
 * @date: 2025/3/17 17:53
 */
@Slf4j
@WebFilter(urlPatterns = "/*")
public class LoginFilter implements Filter {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
//        获取请求路径
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        String path = request.getRequestURI();
        log.info("请求路径：{}", path);

//        如果是登录请求，放行
        if (path.contains("login")) {
            filterChain.doFilter(servletRequest, servletResponse);
            return;
        }

//        获取请求头中的令牌
        String token = request.getHeader("token");
        log.info("从请求头中获取的令牌：{}", token);

//        判断token是否为空,如果为空，则返回,返回错误，未登录
        if (!StringUtils.hasLength(token)) {
            log.info("请求头中令牌为空，返回错误");
            Result notLogin = Result.error("NOT_LOGIN");
            String json = JSON.toJSONString(notLogin);
            response.getWriter().write(json);
            return;
        }

//        解析token，如果解析失败，则返回错误，未登录
        try {
            JwtUtils.parseJWT(token);
        } catch (Exception e) {
            log.info("解析令牌失败，返回错误");
            Result notLogin = Result.error("NOT_LOGIN");
            String json = JSONObject.toJSONString(notLogin);
            response.getWriter().write(json);
            return;
        }

//        放行
        filterChain.doFilter(servletRequest, servletResponse);
    }
}
