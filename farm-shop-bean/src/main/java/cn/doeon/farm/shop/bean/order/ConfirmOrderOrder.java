/*
 * Copyright (c) 2018-2999 广州亚米信息科技有限公司 All rights reserved.
 *
 * https://www.gz-yami.com/
 *
 * 未经允许，不可做商业用途！
 *
 * 版权所有，侵权必究！
 */

package cn.doeon.farm.shop.bean.order;

/**
 * 提交订单事件先后顺序
 * @author LGH
 */
public interface ConfirmOrderOrder {

    /**
     * 没有任何活动时的顺序
     */
    int DEFAULT = 0;

    /**
     * 满减，排在DEFAULT后面
     */
    int DISCOUNT = 100;

    /**
     * 优惠券，排在DISCOUNT后面
     */
    int COUPON = 200;

    /**
     * 分销，排在COUPON后面
     */
    int DISTRIBUTION = 300;
}
