package com.rrm.vo;

import lombok.Data;

import java.util.List;

/**
 * 分页返回结果.
 *
 * @author TWL 2024/8/12 11:25
 * @since 1.0
 */
@Data
public class PageResultVO<T> {

    private List<T> list; // 当前页的数据列表
    private long total;       // 总记录数
    private long pageNum;     // 当前页码
    private long pageSize;    // 每页大小
}
