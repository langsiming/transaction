package com.hsbc.transaction.dao.localcahe;

import com.hsbc.transaction.dos.TransactionDO;
import java.util.LinkedHashMap;
import java.util.List;
import org.springframework.stereotype.Component;

/**
 * description:
 *
 * @author siminglang
 * @date 2025/5/13 17:21
 */
@Component
public class TransactionLocalCacheDao {
    //todo - 待优化集合在并发操作下的一致性问题
    private static LinkedHashMap<String, TransactionDO> collectionList = new LinkedHashMap<>();

    public int add(TransactionDO transactionDO) {
        try {
            collectionList.put(transactionDO.getTransactionId(), transactionDO);
        } catch (Exception e) {
            return 0;
        }
        return 1;
    }

    public int delete(String transaction) {
        try {
            collectionList.remove(transaction);
        } catch (Exception e) {
            return 0;
        }
        return 1;
    }

    public int modify(TransactionDO transactionDO) {
        try {
            collectionList.put(transactionDO.getTransactionId(), transactionDO);
        } catch (Exception e) {
            return 0;
        }
        return 1;
    }

    public List<TransactionDO> pageList(int start, int end) {
        List<TransactionDO> list = collectionList.values().stream().toList();
        list = list.subList(start, end);
        return list;
    }

    public int size() {
        return collectionList.size();
    }


    public boolean exist(String transaction) {
        return collectionList.get(transaction) == null ? false : true;
    }

    public TransactionDO getById(String transaction) {
        return collectionList.get(transaction);
    }
}
