package com.rrm.annotations;

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
        LOGIN("1000"),
        OPEN("1001"),
        AUTH("1002");

        private final String code;

        PLevel(String code) {
            this.code = code;
        }

        public String getCode() {
            return code;
        }
    }

    PLevel value() default PLevel.AUTH;
}
