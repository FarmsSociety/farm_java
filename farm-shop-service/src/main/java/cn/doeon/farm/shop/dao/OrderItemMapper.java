/*
 * Copyright (c) 2018-2999 广州亚米信息科技有限公司 All rights reserved.
 *
 * https://www.gz-yami.com/
 *
 * 未经允许，不可做商业用途！
 *
 * 版权所有，侵权必究！
 */

package cn.doeon.farm.shop.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.doeon.farm.shop.bean.model.OrderItem;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;

public interface OrderItemMapper extends BaseMapper<OrderItem> {

	List<OrderItem> listByOrderNumber(@Param("orderNumber") String orderNumber);
	
	void insertBatch(List<OrderItem> orderItems);
	
//	List<OrderItem> getPayByOrderNumber(@Param("orderNumber") String orderNumber);

}