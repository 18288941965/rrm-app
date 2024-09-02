package com.rrm.annotations;

import lombok.Getter;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 接口环境.
 *
 * @author TWL 2024/9/2 9:15
 * @since 1.0
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD, ElementType.TYPE})
public @interface InterfaceEnvironment {

    @Getter
    enum IEnvironment {
        DEV("01", "开发环境"),
        PROD("02", "生产环境");

        private final String code;

        private final String comment;

        IEnvironment(String code, String comment) {
            this.code = code;
            this.comment = comment;
        }
    }

    InterfaceEnvironment.IEnvironment value() default InterfaceEnvironment.IEnvironment.PROD;
}
