/*
 * Copyright (c) 2018-2999 广州亚米信息科技有限公司 All rights reserved.
 *
 * https://www.gz-yami.com/
 *
 * 未经允许，不可做商业用途！
 *
 * 版权所有，侵权必究！
 */

package cn.doeon.farm.shop.bean.app.param;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(value= "设置用户信息")
public class UserInfoParam {
	
	@ApiModelProperty(value = "用户昵称")
	private String nickName;
	
	@ApiModelProperty(value = "用户头像")
	private String avatarUrl;

}
