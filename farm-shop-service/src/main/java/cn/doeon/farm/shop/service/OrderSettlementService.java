/*
 * Copyright (c) 2018-2999 广州亚米信息科技有限公司 All rights reserved.
 *
 * https://www.gz-yami.com/
 *
 * 未经允许，不可做商业用途！
 *
 * 版权所有，侵权必究！
 */

package cn.doeon.farm.shop.service;

import com.baomidou.mybatisplus.extension.service.IService;
import cn.doeon.farm.shop.bean.model.OrderSettlement;

/**
 *
 * @author lgh on 2018/11/10.
 */
public interface OrderSettlementService extends IService<OrderSettlement> {

	/**
	 * 根据内部订单号更新order settlement
	 */
	void updateSettlementsByPayNo(String outTradeNo, String transactionId);
}
