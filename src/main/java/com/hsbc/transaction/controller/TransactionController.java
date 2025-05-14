package com.hsbc.transaction.controller;

import com.hsbc.transaction.common.PageRes;
import com.hsbc.transaction.common.R;
import com.hsbc.transaction.dos.TransactionDO;
import com.hsbc.transaction.request.CreateReq;
import com.hsbc.transaction.request.DeleteReq;
import com.hsbc.transaction.request.ModifyReq;
import com.hsbc.transaction.request.PageListReq;
import com.hsbc.transaction.service.TransactionService;
import jakarta.annotation.Resource;
import java.util.List;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * description:
 *
 * @author siminglang
 * @date 2025/5/13 17:06
 */
@RestController
@RequestMapping("/transaction")
public class TransactionController {

    @Resource
    private TransactionService transactionService;
    @PostMapping("/create")
    public R<Boolean> create(@RequestBody CreateReq req) {
        boolean res = transactionService.create(req);
        return R.success(res);
    }

        @PostMapping("/modify")
    public R<Boolean> modify(@RequestBody ModifyReq req) {
        boolean res = transactionService.modify(req);
        return R.success(res);
    }

    @PostMapping("/delete")
    public R<Boolean> delete(@RequestBody DeleteReq req) {
        boolean res = transactionService.delete(req);
        return R.success(res);
    }

    @PostMapping("/page/list")
    public R<PageRes<List<TransactionDO>>> pageList(@RequestBody PageListReq req) {
        PageRes<List<TransactionDO>> pageRes = transactionService.pageList(req);
        return R.success(pageRes);
    }
}
