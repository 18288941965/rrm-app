package com.rrm.annotations;

import lombok.Getter;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 权限控制注解.
 *
 * @author TWL 2024/8/29 17:24
 * @since 1.0
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD, ElementType.TYPE})
public @interface PermissionRequired {

    enum PLevel {
        AUTH(100, "需要认证并且授权"),
        LOGIN(101, "需要登录，不需要授权"),
        OPEN(102, "开放的，无需登录");

        @Getter
        private final Integer code;
        @Getter
        private String comment;

        PLevel(Integer code, String comment) {
            this.code = code;
            this.comment = comment;
        }
    }

    PLevel value() default PLevel.AUTH;
}
