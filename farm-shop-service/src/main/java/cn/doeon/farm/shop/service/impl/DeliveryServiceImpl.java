/*
 * Copyright (c) 2018-2999 广州亚米信息科技有限公司 All rights reserved.
 *
 * https://www.gz-yami.com/
 *
 * 未经允许，不可做商业用途！
 *
 * 版权所有，侵权必究！
 */

package cn.doeon.farm.shop.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.doeon.farm.shop.bean.model.Delivery;
import cn.doeon.farm.shop.dao.DeliveryMapper;

import cn.doeon.farm.shop.service.DeliveryService;

/**
 *
 * @author lgh on 2018/11/26.
 */
@Service
public class DeliveryServiceImpl extends ServiceImpl<DeliveryMapper, Delivery> implements DeliveryService {

    @Autowired
    private DeliveryMapper deliveryMapper;

}
