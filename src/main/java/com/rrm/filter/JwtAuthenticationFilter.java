package com.rrm.filter;

import com.rrm.cache.RrmUserCache;
import com.rrm.util.JwtTokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

/**
 * 拦截类.
 *
 * @author TWL 2024/7/30 9:31
 * @since 1.0
 */
@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter {

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    private static final List<String> LG_URL = Arrays.asList(
            "/auth/login",
            "/auth/isLogin",
            "/auth/logout"
    );
    private static final String LOGIN_URL = "/";

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

        String servletPath = request.getServletPath();
        String xRequestedWith = request.getHeader("XRequestedWith");
        String authorization = request.getHeader("Authorization");
        String flag = "XMLHttpRequest";

        System.out.println(servletPath);

        // *******************处理前端请求
        if (!flag.equals(xRequestedWith)) {
            // 请求登录页或静态文件
            if (LOGIN_URL.equals(servletPath) || servletPath.contains(".")) {
                filterChain.doFilter(request, response);
                return;
            }
            // 路由请求并且无token（浏览器直接输入地址是没有token的）
            if (authorization == null || !authorization.startsWith("Bearer ")){
                response.sendRedirect(LOGIN_URL);
                return;
            }
            filterChain.doFilter(request, response);
            return;
        }

        // *******************处理后端请求
        RequestMatcher matcher = new RequestMatcher(LG_URL);
        String matchedPattern = matcher.matchRequestToPattern(request);
        // System.out.println("===========" + matchedPattern);

        String token = null;
        String username = null;

        if (authorization != null && authorization.startsWith("Bearer ")) {
            token = authorization.substring(7);

            boolean b = jwtTokenUtil.validateToken(token);
            if (!b){
                response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
                response.getWriter().write("token无效或已经过期！");
                return;
            }

            username = jwtTokenUtil.getUsernameFromToken(token);
            RrmUserCache userInfo  = jwtTokenUtil.getUserInfo(username);

            if (userInfo == null) {
                response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
                response.getWriter().write("未登录或登录超时！");
                return;
            }
        } else if (!LG_URL.contains(servletPath)) {
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            response.getWriter().write("无效token！");
            return;
        }

        filterChain.doFilter(request, response);
    }
}
