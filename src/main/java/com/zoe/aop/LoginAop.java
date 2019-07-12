package com.zoe.aop;

import cn.gjing.ParamUtil;
import cn.gjing.ex.HttpException;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;

/**
 * @author zoe
 **/
@Component
@Aspect
@Slf4j
public class LoginAop {

    @Pointcut("@annotation(com.zoe.aop.Login))")
    public void cut() {
    }

    @Before("cut()")
    public void before(){
        log.info("==================== 进入登录验证 ==================");
        ServletRequestAttributes servletRequestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        assert servletRequestAttributes != null;
        HttpServletRequest request = servletRequestAttributes.getRequest();
        String token = request.getHeader("token");
        if (ParamUtil.isEmpty(token)){
            throw new HttpException("当前未登录!");
        }
    }

    /**
     *
     */
    @After("cut(),execution(*com.zoe.aop.TestController.test(..))")
    public void after(){
        log.info("========================= 方法执行完毕,开始打印=========================");
        ServletRequestAttributes servletRequestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        assert servletRequestAttributes != null;
        HttpServletRequest request = servletRequestAttributes.getRequest();
        String method = request.getMethod();//请求方式
        log.info("请求方式: "+method);
        //获取请求资源
        String requestURI = request.getRequestURI();
        log.info("请求资源requestURI : "+requestURI);
        StringBuffer requestURL = request.getRequestURL();
        log.info("该方法的请地址是 :"+requestURL);
        //获取get请求参数
        String queryString = request.getQueryString();
        log.info("get请求参数 :"+queryString);
        //获取当前web应用名称
        String contextPath = request.getContextPath();
        log.info("当前web应用名称 :"+contextPath);
        //获取所有请求头名称
        Enumeration<String> headerNames = request.getHeaderNames();
        while (headerNames.hasMoreElements()) {
            String string =  headerNames.nextElement();
            log.info("请求头参数:"+string);
        }
        log.info("请求的IP地址为: " + getRealIp(request));
    }
    private static String getRealIp(HttpServletRequest request) {
        // 这个一般是Nginx反向代理设置的参数
        String ip = request.getHeader("X-Real-IP");
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("X-Forwarded-For");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
        }
        // 处理多IP的情况（只取第一个IP）
        if (ip != null && ip.contains(",")) {
            String[] ipArray = ip.split(",");
            ip = ipArray[0];
        }
        return ip;
    }

}
