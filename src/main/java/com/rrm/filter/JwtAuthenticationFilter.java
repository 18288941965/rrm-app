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

    private static final List<String> passUrl = Arrays.asList(
            "/auth/login",
            "/auth/isLogin",
            "/auth/logout",
            "/scanner",
            "/scanner/dc"
    );

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

        String servletPath = request.getServletPath();

        String header = request.getHeader("Authorization");
        String token = null;
        String username = null;

        if (header != null && header.startsWith("Bearer ")) {
            token = header.substring(7);

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
        } else if (!passUrl.contains(servletPath)) {
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            response.getWriter().write("无效token！");
            return;
        }

        filterChain.doFilter(request, response);
    }
}
