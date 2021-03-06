package cn.doeon.farm.shop.admin.controller.science;

import cn.doeon.farm.shop.bean.common.ResponseResult;
import cn.doeon.farm.shop.bean.common.ResultMsg;
import cn.doeon.farm.shop.bean.dto.ActivityInfoDto;
import cn.doeon.farm.shop.bean.enums.ResultStatus;
import cn.doeon.farm.shop.bean.model.science.ActivityInfo;
import cn.doeon.farm.shop.bean.model.science.ActivityPraise;
import cn.doeon.farm.shop.service.ScienceActivityEvaluateService;
import cn.doeon.farm.shop.service.ScienceActivityParticipantsService;
import cn.doeon.farm.shop.service.ScienceActivityPraiseService;
import cn.doeon.farm.shop.service.ScienceActivityService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

/**
 * @author hexiangyi on 2018/10/26.
 */
@RestController
@AllArgsConstructor
@RequestMapping("/science/active")
@Api(tags = "活动招募")
public class ActiveController {
    @Autowired
    private ScienceActivityService scienceActivityService;
    @Autowired
    private ScienceActivityParticipantsService scienceActivityParticipantsService;
    @Autowired
    private ScienceActivityEvaluateService scienceActivityEvaluateService;
    @Autowired
    private ScienceActivityPraiseService scienceActivityPraiseService;



    /**
     * 获取活动列表接口
     *
     * @return
     */
    @ApiOperation(value = "获取活动招募列表", notes = "获取活动招募列表")
    @GetMapping("/list")
    public ResponseResult<IPage<ActivityInfo>> getActivityList(@RequestParam(name = "pageNo", defaultValue = "1") Integer pageNo,
                                                               @RequestParam(name = "pageSize", defaultValue = "10") Integer pageSize,
                                                               ActivityInfoDto activityInfo) {

        ResponseResult<IPage<ActivityInfo>> result = new ResponseResult<>();
        Page<ActivityInfo> page = new Page<>(pageNo, pageSize);
        IPage<ActivityInfo> activityList = scienceActivityService.getActivityList(page,activityInfo);
        result.setData(activityList);
        result.setStatus(ResultStatus.SUCCESS.value());
        result.setMsg(ResultMsg.MSG_SUCCESS);
        return result;
    }
    /**
     * 发布活动接口
     *
     * @return
     */
    @ApiOperation(value = "发布活动", notes = "发布活动接口")
    @PostMapping("/publish")
    public ResponseResult publishActivity(@RequestBody ActivityInfo activityInfo) {
        System.out.println(activityInfo);
        scienceActivityService.saveOrUpdate(activityInfo);
        ResponseResult result = new ResponseResult();
        result.setStatus(ResultStatus.SUCCESS.value());
        result.setMsg(ResultMsg.MSG_SUCCESS);
        return result;
    }

    /**
     * 删除活动接口
     *
     * @return
     */
    @ApiOperation(value = "删除活动", notes = "删除活动接口")
    @DeleteMapping("/delete")
    @Transactional(rollbackFor = Exception.class)
    public ResponseResult deleteActivityById(@RequestParam(name = "id") String id) {
        boolean isSuccess = scienceActivityService.deleteActivityById(id);
        ResponseResult result = new ResponseResult();
        result.setStatus(isSuccess ? ResultStatus.SUCCESS.value() : ResultStatus.FAIL.value());
        result.setMsg(isSuccess ? ResultMsg.MSG_SUCCESS : ResultMsg.MSG_FAIL);
        return result;
    }

    /**
     * 通过活动ID，查询活动信息
     *
     * @return
     */
    @ApiOperation(value = "查询活动信息", notes = "查询活动信息接口")
    @GetMapping("/info")
    public ResponseResult<ActivityInfo> getActivityInfoById(@RequestParam(name = "id") String id) {
        ActivityInfo activityInfo = scienceActivityService.getActivityInfoById(id);
        ResponseResult<ActivityInfo> result = new ResponseResult<>();
        result.setStatus(ResultStatus.SUCCESS.value());
        result.setMsg(ResultMsg.MSG_SUCCESS);
        result.setData(activityInfo);
        return result;
    }

    /**
     * 通过活动ID，更新活动状态信息
     *
     * @return
     */
    @ApiOperation(value = "更新活动状态信息", notes = "更新活动状态信息接口")
    @PutMapping("/status")
    @Transactional(rollbackFor = Exception.class)
    public ResponseResult updateActivityStatus(@RequestParam(name = "id") String id,
                                               @RequestParam(name = "activityStatus") Integer activityStatus) {
        boolean isSuccess = scienceActivityService.updateActivityStatus(id, activityStatus);
        ResponseResult result = new ResponseResult();
        result.setStatus(isSuccess ? ResultStatus.SUCCESS.value() : ResultStatus.FAIL.value());
        result.setMsg(isSuccess ? ResultMsg.MSG_SUCCESS : ResultMsg.MSG_FAIL);
        return result;
    }

    @ApiOperation(value = "活动点赞", notes = "活动点赞接口")
    @PostMapping("/praise")
    public ResponseResult activityPraiseConfirm(@RequestBody ActivityPraise activityPraise){
        String praiseId = scienceActivityPraiseService.getActivityPraiseInfo(activityPraise.getActivityId(), activityPraise.getUserId());
        if(null != praiseId){
            activityPraise.setId(praiseId);
        }
        boolean isSuccess = scienceActivityPraiseService.saveOrUpdate(activityPraise);
        ResponseResult result = new ResponseResult();
        result.setStatus(isSuccess ? ResultStatus.SUCCESS.value() : ResultStatus.FAIL.value());
        result.setMsg(isSuccess ? ResultMsg.MSG_SUCCESS : ResultMsg.MSG_FAIL);
        return result;
    }
}
