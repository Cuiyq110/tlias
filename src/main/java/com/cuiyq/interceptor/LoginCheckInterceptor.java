package com.cuiyq.interceptor;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.cuiyq.domain.Result;
import com.cuiyq.utils.JwtUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @version V1.0
 * @Title:
 * @Description: 登录检查拦截器
 * @Copyright 2024 Cuiyq
 * @author: Cuiyq
 * @date: 2025/3/18 10:25
 */
@Slf4j
@Component
public class LoginCheckInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
//        获取请求路径

        String path = request.getRequestURI();
        log.info("请求路径：{}", path);

//        如果是登录请求，放行
        if (path.contains("login")) {
            return true;
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
            return false;
        }

//        解析token，如果解析失败，则返回错误，未登录
        try {
            JwtUtils.parseJWT(token);
        } catch (Exception e) {
            log.info("解析令牌失败，返回错误");
            Result notLogin = Result.error("NOT_LOGIN");
            String json = JSONObject.toJSONString(notLogin);
            response.getWriter().write(json);
            return false;
        }

//        放行

        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("postHandle");
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("afterCompletion");
    }
}
