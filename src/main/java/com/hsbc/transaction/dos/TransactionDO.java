package com.hsbc.transaction.dos;

import lombok.Data;

/**
 * description:
 *
 * @author siminglang
 * @date 2025/5/13 17:34
 */
@Data
public class TransactionDO {
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
