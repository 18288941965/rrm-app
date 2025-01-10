package com.rrm.demo.model;

import lombok.Data;

import java.io.Serializable;

/**
 * 类描述.
 *
 * @author TWL 2025/1/10 14:18
 * @since 1.0
 */
@Data
public class RedisDemo implements Serializable {

    private String name;

    private String age;

    private static final long serialVersionUID = 1L;
}
