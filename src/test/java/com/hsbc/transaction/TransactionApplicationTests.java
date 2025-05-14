package com.hsbc.transaction;

import com.hsbc.transaction.common.PageRes;
import com.hsbc.transaction.common.R;
import com.hsbc.transaction.controller.TransactionController;
import com.hsbc.transaction.dos.TransactionDO;
import com.hsbc.transaction.request.CreateReq;
import com.hsbc.transaction.request.DeleteReq;
import com.hsbc.transaction.request.ModifyReq;
import com.hsbc.transaction.request.PageListReq;
import com.hsbc.transaction.service.TransactionService;
import jakarta.annotation.Resource;
import java.util.Date;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class TransactionApplicationTests {

	@Resource
	private TransactionController transactionController;
	@Resource
	private TransactionService transactionService;

	/**
	 * 正常链路测试：
	 * 	1.创建交易
	 * 	2.更新交易
	 * 	3.删除交易
	 * 	4.分页查询交易
	 */
	@Test
	void createTransactionTest() {
		TransactionDO byId = null;
		try {
			CreateReq createReq = new CreateReq();
			createReq.setTransactionId("TR001");
			createReq.setAmount(100.1);
			createReq.setTime(new Date().getTime());
			createReq.setStatus("COMPLATED");
			createReq.setUserId("user01");
			R<Boolean> booleanR = transactionController.create(createReq);
			Assertions.assertEquals(Boolean.TRUE, booleanR.getData());
			byId = transactionService.getById(createReq.getTransactionId());
		} catch (Exception e) {
			e.printStackTrace();
		}


		Assertions.assertNotNull(byId);
	}

	@Test
	void updateTransactionTest() {
		createTransactionTest();
		ModifyReq modifyReq = new ModifyReq();
		modifyReq.setTransactionId("TR001");
		modifyReq.setAmount(100.1);
		modifyReq.setTime(new Date().getTime());
		modifyReq.setStatus("CANCLE");
		modifyReq.setUserId("user01");
		R<Boolean> booleanR = transactionController.modify(modifyReq);
		Assertions.assertEquals(Boolean.TRUE, booleanR.getData());
	}

	@Test
	void deleteTransactionTest() {
		DeleteReq deleteReq = new DeleteReq();
		deleteReq.setTransactionId("TR001");
		R<Boolean> booleanR = transactionController.delete(deleteReq);
		Assertions.assertEquals(Boolean.TRUE, booleanR.getData());
		TransactionDO byId = transactionService.getById(deleteReq.getTransactionId());
		Assertions.assertNull(byId);
	}

	@Test
	void pageTransactionTest() {
		PageListReq pageListReq = new PageListReq();
		pageListReq.setPageNumber(10);
		pageListReq.setPageSize(1);
		R<PageRes<List<TransactionDO>>> pageResR = transactionController.pageList(pageListReq);
		Assertions.assertEquals(1, pageResR.getData().getData().size());
	}

	/**
	 * 异常链路测试
	 * 	1.创建重复的交易
	 * 	2.修改不存在的交易
	 */
	@Test
	void createTransactionExceptionTest() {
		CreateReq createReq = new CreateReq();
		createReq.setTransactionId("TR001");
		createReq.setAmount(100.1);
		createReq.setTime(new Date().getTime());
		createReq.setStatus("COMPLATED");
		createReq.setUserId("user01");
		try {
			R<Boolean> booleanR1 = transactionController.create(createReq);
			R<Boolean> booleanR2 = transactionController.create(createReq);
		} catch (Exception e) {
			Assertions.assertEquals("transaction exist", e.getMessage());
		}
	}

	@Test
	void updateTransactionExceptionTest() {
		ModifyReq modifyReq = new ModifyReq();
		modifyReq.setTransactionId("TR001");
		modifyReq.setAmount(100.1);
		modifyReq.setTime(new Date().getTime());
		modifyReq.setStatus("CANCLE");
		modifyReq.setUserId("user01");

		try {
			R<Boolean> booleanR = transactionController.modify(modifyReq);
		} catch (Exception e) {
			Assertions.assertEquals("transaction does not exist", e.getMessage());
		}
	}
}
