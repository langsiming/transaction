package com.hsbc.transaction.request;

import lombok.Data;

/**
 * description:
 *
 * @author siminglang
 * @date 2025/5/13 19:17
 */
@Data
public class PageListReq {
    private int pageNumber;
    private int pageSize;
}
