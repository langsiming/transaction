package com.hsbc.transaction.request;

import lombok.Data;

/**
 * description:
 *
 * @author siminglang
 * @date 2025/5/13 17:09
 */
@Data
public class CreateReq {
    //交易号
    private String transactionId;
    //交易金额
    private double amount;
    //交易状态
    private String status;
    //交易时间
    private Long time;
    //交易人
    private String userId;
}
