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


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import cn.doeon.farm.shop.bean.app.dto.UserCollectionDto;
import cn.doeon.farm.shop.bean.model.UserCollection;

/**
 * 用户收藏表
 *
 * @author xwc
 * @date 2019-04-19 16:57:20
 */
public interface UserCollectionService extends IService<UserCollection> {
    IPage<UserCollectionDto> getUserCollectionDtoPageByUserId(Page page, String userId);
}
