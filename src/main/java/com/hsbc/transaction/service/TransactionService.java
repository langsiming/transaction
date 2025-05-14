package com.hsbc.transaction.service;

import com.hsbc.transaction.common.BusinessException;
import com.hsbc.transaction.common.PageRes;
import com.hsbc.transaction.dos.TransactionDO;
import com.hsbc.transaction.reposity.TransactionRepository;
import com.hsbc.transaction.request.CreateReq;
import com.hsbc.transaction.request.DeleteReq;
import com.hsbc.transaction.request.ModifyReq;
import com.hsbc.transaction.request.PageListReq;
import jakarta.annotation.Resource;
import java.util.List;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

/**
 * description:
 *
 * @author siminglang
 * @date 2025/5/13 17:18
 */
@Service
public class TransactionService {

    @Resource
    private TransactionRepository transactionRepository;

    public boolean create( CreateReq req) {
        boolean exist = transactionRepository.exist(req.getTransactionId());
        if (exist) {
            throw new BusinessException("transaction exist");
        }
        TransactionDO transactionDO = new TransactionDO();
        BeanUtils.copyProperties(req, transactionDO);
        int count = transactionRepository.add(transactionDO);
        return count > 0;
    }

    public boolean modify(ModifyReq req) {
        boolean exist = transactionRepository.exist(req.getTransactionId());
        if (!exist) {
            throw new BusinessException("transaction does not exist");
        }
        TransactionDO transactionDO = new TransactionDO();
        BeanUtils.copyProperties(req, transactionDO);
        int count = transactionRepository.modify(transactionDO);
        return count > 0;
    }

    public boolean delete(DeleteReq req) {
        boolean exist = transactionRepository.exist(req.getTransactionId());
        if (!exist) {
            throw new BusinessException("transaction does not exist");
        }
        int count = transactionRepository.delete(req.getTransactionId());
        return count > 0;
    }

    public PageRes<List<TransactionDO>> pageList(PageListReq req) {
        int count = transactionRepository.getCollectSize();
        if ((req.getPageSize() - 1) * req.getPageNumber() >= count) {
            throw new BusinessException("pageNumber or pageSize is too big");
        }
        int start = (req.getPageSize() - 1) * req.getPageNumber() >= count ? count-1 : (req.getPageSize() - 1) * req.getPageNumber();
        int end = req.getPageSize() * req.getPageNumber() > count ? count : req.getPageSize() * req.getPageNumber();

        List<TransactionDO> transactionDOS = transactionRepository.pageList(start, end);

        PageRes<List<TransactionDO>> pageRes = new PageRes<>();
        pageRes.setTotal(count);
        pageRes.setData(transactionDOS);


        return pageRes;
    }

    public  TransactionDO getById(String transaction) {
        TransactionDO transactionDO = transactionRepository.getById(transaction);
        return transactionDO;
    }

}
