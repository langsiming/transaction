package com.hsbc.transaction.common;

import lombok.Data;

/**
 * description:
 *
 * @author siminglang
 * @date 2025/5/13 21:51
 */
@Data
public class PageRes<T> {
    private int pageSize;
    private int pageNumber;
    private int total;
    private T data;

}
