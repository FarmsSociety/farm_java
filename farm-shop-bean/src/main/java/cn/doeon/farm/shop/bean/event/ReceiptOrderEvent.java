/*
 * Copyright (c) 2018-2999 广州亚米信息科技有限公司 All rights reserved.
 *
 * https://www.gz-yami.com/
 *
 * 未经允许，不可做商业用途！
 *
 * 版权所有，侵权必究！
 */

package cn.doeon.farm.shop.bean.event;

import cn.doeon.farm.shop.bean.model.Order;
import lombok.AllArgsConstructor;
import lombok.Data;


/**
 * 确认收货的事件
 * @author
 */
@Data
@AllArgsConstructor
public class ReceiptOrderEvent {

    private Order order;
}
