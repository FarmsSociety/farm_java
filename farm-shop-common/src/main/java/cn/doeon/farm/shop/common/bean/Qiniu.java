/*
 * Copyright (c) 2018-2999 广州亚米信息科技有限公司 All rights reserved.
 *
 * https://www.gz-yami.com/
 *
 * 未经允许，不可做商业用途！
 *
 * 版权所有，侵权必究！
 */

package cn.doeon.farm.shop.common.bean;

import cn.doeon.farm.shop.common.enums.QiniuZone;
import lombok.Data;

/**
 * 七牛云存储配置信息
 * @author lgh
 */
@Data
public class Qiniu {

	private String accessKey;

	private String secretKey;

	private String bucket;

	private String resourcesUrl;

	private QiniuZone zone;
}
