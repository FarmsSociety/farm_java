/*
 * Copyright (c) 2018-2999 广州亚米信息科技有限公司 All rights reserved.
 *
 * https://www.gz-yami.com/
 *
 * 未经允许，不可做商业用途！
 *
 * 版权所有，侵权必究！
 */

package cn.doeon.farm.shop.quartz.dao;

import cn.doeon.farm.shop.quartz.model.ScheduleJob;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

/**
 * 定时任务，任务调度mapper
 * @author lgh
 */
public interface ScheduleJobMapper extends BaseMapper<ScheduleJob> {

	/**
	 *  批量修改任务状态
	 * @param jobIds 调度任务id
	 * @param status 任务状态
	 * @return 修改成功条数
	 */
	int updateBatch(@Param("jobIds") Long[] jobIds, @Param("status") int status);
}