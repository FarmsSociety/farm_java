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

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import cn.doeon.farm.shop.common.serializer.json.ImgJsonSerializer;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@ApiModel("我的订单-订单项")
@Data
public class MyOrderItemDto {

    @ApiModelProperty(value = "商品图片", required = true)
    @JsonSerialize(using = ImgJsonSerializer.class)
    private String pic;

    @ApiModelProperty(value = "商品名称", required = true)
    private String prodName;

    @ApiModelProperty(value = "商品数量", required = true)
    private Integer prodCount;

    @ApiModelProperty(value = "商品价格", required = true)
    private Double price;

    @ApiModelProperty(value = "skuName", required = true)
    private String skuName;

}
