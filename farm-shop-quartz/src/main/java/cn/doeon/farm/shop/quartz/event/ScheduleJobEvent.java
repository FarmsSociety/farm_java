/*
 * Copyright (c) 2018-2999 广州亚米信息科技有限公司 All rights reserved.
 *
 * https://www.gz-yami.com/
 *
 * 未经允许，不可做商业用途！
 *
 * 版权所有，侵权必究！
 */

package cn.doeon.farm.shop.quartz.event;

import cn.doeon.farm.shop.quartz.model.ScheduleJob;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 定时任务事件
 */
@Getter
@AllArgsConstructor
public class ScheduleJobEvent {

	private final ScheduleJob scheduleJob;
}
