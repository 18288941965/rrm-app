package com.rrm.filter;

import org.springframework.util.AntPathMatcher;
import org.springframework.util.PathMatcher;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * 类描述.
 *
 * @author TWL 2024/9/2 18:07
 * @since 1.0
 */
public class RequestMatcher {

    private final PathMatcher pathMatcher = new AntPathMatcher();
    private final List<String> requestPatterns;

    public RequestMatcher(List<String> requestPatterns) {
        this.requestPatterns = requestPatterns;
    }

    public String matchRequestToPattern(HttpServletRequest request) {
        String requestUri = request.getRequestURI();

        for (String pattern : requestPatterns) {
            if (pathMatcher.match(pattern, requestUri)) {
                // 如果匹配，返回匹配的模式
                return pattern;
            }
        }
        // 如果没有找到匹配的模式，返回null或者处理异常
        return null;
    }
}
