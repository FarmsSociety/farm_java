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
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class CategoryDto {

	@ApiModelProperty(value = "分类id",required=true)
	private Long categoryId;

	@ApiModelProperty(value = "分类父id",required=true)
	private Long parentId;

	@ApiModelProperty(value = "分类名称",required=true)
	private String categoryName;

	@ApiModelProperty(value = "分类图片",required=true)
	@JsonSerialize(using = ImgJsonSerializer.class)
	private String pic;

}
