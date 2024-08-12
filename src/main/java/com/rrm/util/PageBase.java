package com.rrm.util;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.Data;

/**
 * 分页插件.
 *
 * @author TWL 2024/8/12 11:11
 * @since 1.0
 */
@Data
public class PageBase {

    private int pageNum;

    private int pageSize;

    public PageBase() {
        this.pageNum = 1;
        this.pageSize = 10;
    }

    public <T> Page<T> getPage(Class<T> clazz) {
        return new Page<>(this.pageNum, this.pageSize);
    }
}
