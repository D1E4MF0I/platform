package com.than.interceptor;

import com.auth0.jwt.exceptions.AlgorithmMismatchException;
import com.auth0.jwt.exceptions.SignatureVerificationException;
import com.auth0.jwt.exceptions.TokenExpiredException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.than.base.Code;
import com.than.base.Result;
import com.than.dao.user.UserDao;
import com.than.jwt.JWTUtil;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Than
 * @package: com.than.interceptor
 * @className: JWTInterceptor
 * @description: jwt拦截器
 * @date: 2023/8/25 17:01
 */

@Component
@Slf4j
public class JWTInterceptor implements HandlerInterceptor {

    @Autowired
    private UserDao userDao;

    @Override
    public boolean preHandle(HttpServletRequest request, @NonNull HttpServletResponse response, @NonNull Object handler) throws Exception {
        Map<String, Object> map = new HashMap<>();
        //令牌建议是放在请求头中，获取请求头中令牌
        String token = request.getHeader("token");
        try {
            JWTUtil.verify(token);//验证令牌
            if(userDao.getByUserToken(token)==null){
                throw new RuntimeException();
            }
            return true;//放行请求
        } catch (SignatureVerificationException e) {
            log.error(e.getMessage());
            map.put("msg", "无效签名");
        } catch (TokenExpiredException e) {
            log.error(e.getMessage());
            map.put("msg", "token过期");
        } catch (AlgorithmMismatchException e) {
            log.error(e.getMessage());
            map.put("msg", "token算法不一致");
        } catch (RuntimeException e) {
            log.error(e.getMessage());
            map.put("msg", "token失效");
        }
        map.put("state", false);//设置状态
        //将map转化成json，response使用的是Jackson
        String json = new ObjectMapper().writeValueAsString(new Result(Code.FAIL, map));
        response.setContentType("application/json;charset=UTF-8");
        response.getWriter().print(json);
        return false;
    }
}
