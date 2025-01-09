package com.rrm.filter;

import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 类描述.
 *
 * @author TWL 2024/9/2 18:07
 * @since 1.0
 */
public class RequestMatcher {

    public static String matchPath(Set<String> apiPaths, String httpMethodAndRequestPath) {
        for (String pathPattern : apiPaths) {
            String patternStr = "^" + escapeSpecialChars(pathPattern) + "$";
            Pattern pattern = Pattern.compile(patternStr);

            Matcher matcher = pattern.matcher(httpMethodAndRequestPath);

            if (matcher.matches()) {
                return pathPattern;
            }
        }
        return null;
    }

    private static String escapeSpecialChars(String pathPattern) {
        return pathPattern.replaceAll("\\{([^}]+)\\}", "([^/]+)");
    }
}
