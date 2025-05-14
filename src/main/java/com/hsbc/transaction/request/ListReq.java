package com.hsbc.transaction.request;

import lombok.Data;

/**
 * description:
 *
 * @author siminglang
 * @date 2025/5/13 17:09
 */
@Data
public class ListReq {
    //交易号
    private String transaction;
    //交易金额
    private String amount;
    //交易状态
    private String status;
    //交易时间
    private String time;
    //交易人
    private String userId;
}
