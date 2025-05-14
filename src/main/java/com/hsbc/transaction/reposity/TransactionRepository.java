package com.hsbc.transaction.reposity;

import com.hsbc.transaction.dao.localcahe.TransactionLocalCacheDao;
import com.hsbc.transaction.dos.TransactionDO;
import jakarta.annotation.Resource;
import java.util.List;
import org.springframework.stereotype.Repository;

/**
 * description:
 *
 * @author siminglang
 * @date 2025/5/13 17:20
 */
@Repository
public class TransactionRepository {

    @Resource
    private TransactionLocalCacheDao transactionLocalCacheDao;

    public int add(TransactionDO transactionDO) {
        return transactionLocalCacheDao.add(transactionDO);
    }

    public int delete(String transaction) {
        return transactionLocalCacheDao.delete(transaction);
    }

    public int modify(TransactionDO transactionDO) {
        return transactionLocalCacheDao.modify(transactionDO);
    }

    public List<TransactionDO> pageList(int start, int end) {
        return transactionLocalCacheDao.pageList(start, end);
    }

    public int getCollectSize() {
        return transactionLocalCacheDao.size();
    }


    public boolean exist(String transaction) {
        return transactionLocalCacheDao.exist(transaction);
    }

    public TransactionDO getById(String transaction) {
        return transactionLocalCacheDao.getById(transaction);
    }
}
