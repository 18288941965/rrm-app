package com.rrm.filter;

import cn.hutool.core.util.StrUtil;
import com.rrm.cache.RrmUserCache;
import com.rrm.module.resource.domain.model.RrmResource;
import com.rrm.module.resource.mapper.RrmResourceMapper;
import com.rrm.util.JwtTokenUtil;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.*;

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

    @Autowired
    private RrmResourceMapper rrmResourceMapper;

    private static final List<String> PASS_URL = Arrays.asList(
            "/auth/login",
            "/auth/isLogin",
            "/auth/logout",
            "/scanner/run",
            "/redis/demo/t1",
            "/redis/demo/t2",
            "/redis/demo/t3",
            "/redis/demo/t4",
            "/redis/demo/t5",
            "/redis/demo/t6",
            "/redis/demo/t7",
            "/redis/demo/t8",
            "/redis/demo/t9",
            "/redis/demo/t10"
    );
    private static final String LOGIN_URL = "/";

    @SneakyThrows
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

        String servletPath = request.getServletPath();
        String xRequestedWith = request.getHeader("X-Requested-With");
        String authorization = request.getHeader("Authorization");
        String flag = "XMLHttpRequest";

        // *******************处理前端请求
        if (!flag.equals(xRequestedWith) && !PASS_URL.contains(servletPath)) {
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

        // *******************处理后端请求 | 校验token
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
        } else if (!PASS_URL.contains(servletPath)) {
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            response.getWriter().write("无效token！");
            return;
        }

        // *******************处理后端请求 | 判断接口是否存在以及获取接口详情
        // 查询所有接口 | 这里要根据实际情况查询
        String method = request.getMethod();
        List<RrmResource> allResource = rrmResourceMapper.getAllResource();
        Map<String, String> resourceMap = new HashMap<>();
        allResource.forEach(resource -> {
            resourceMap.put(resource.getRequestMethod()+resource.getRequestPath(), resource.getAuthCode());
        });
        Set<String> strings = resourceMap.keySet();

        // 根据访问地址匹配请求路径
        String mapKey = RequestMatcher.matchPath(strings, method + servletPath);
        if (StrUtil.isBlank(mapKey)) {
            // 在生产环境应该放开下列配置
            // response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            // response.getWriter().write("接口不存在！");
            // return;
            System.out.println("================接口不存在");
        }

        // *******************处理后端请求 | 校验是否有访问资源的权限


        filterChain.doFilter(request, response);
    }
}
