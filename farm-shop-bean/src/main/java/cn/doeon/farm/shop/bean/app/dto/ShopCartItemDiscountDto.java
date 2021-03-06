/*
 * Copyright (c) 2018-2999 广州亚米信息科技有限公司 All rights reserved.
 *
 * https://www.gz-yami.com/
 *
 * 未经允许，不可做商业用途！
 *
 * 版权所有，侵权必究！
 */

package cn.doeon.farm.shop.bean.app.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class ShopCartItemDiscountDto implements Serializable {


    @ApiModelProperty(value = "已选满减项", required = true)
    private ChooseDiscountItemDto chooseDiscountItemDto;

    @ApiModelProperty(value = "商品列表")
    private List<ShopCartItemDto> shopCartItems;
}
