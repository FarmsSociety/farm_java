package cn.doeon.farm.shop.admin.controller.science;

import cn.doeon.farm.shop.bean.common.ResponseResult;
import cn.doeon.farm.shop.bean.common.ResultMsg;
import cn.doeon.farm.shop.bean.dto.EvaluateDto;
import cn.doeon.farm.shop.bean.dto.ExpertDto;
import cn.doeon.farm.shop.bean.enums.ResultStatus;
import cn.doeon.farm.shop.bean.model.science.Expert;
import cn.doeon.farm.shop.bean.model.science.ExpertEvaluate;
import cn.doeon.farm.shop.service.ScienceExpertEvaluateService;
import cn.doeon.farm.shop.service.ScienceExpertService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;


/**
 * @author hexiangyi on 2018/10/26.
 */
@RestController
@RequestMapping("/science/expert")
@Api(tags = "科技专家模块接口")
public class ScienceExpertController {

    @Autowired
    private ScienceExpertService scienceExpertService;
    @Autowired
    private ScienceExpertEvaluateService scienceExpertEvaluateService;
    /**
     * 获取专家列表测试接口
     * @return
     */
    @ApiOperation(value = "获取专家列表", notes = "获取专家列表接口")
    @GetMapping("/list")
    public ResponseResult<IPage<Expert>> getExpertList(@RequestParam(name = "pageNo", defaultValue = "1") Integer pageNo,
                                                       @RequestParam(name = "pageSize", defaultValue = "10") Integer pageSize,
                                                       ExpertDto expertDto) {
        ResponseResult<IPage<Expert>> result = new ResponseResult<>();
        Page<Expert> page = new Page<>(pageNo, pageSize);
        IPage<Expert> expertList = scienceExpertService.getExpertList(page,expertDto);
        result.setData(expertList);
        result.setStatus(ResultStatus.SUCCESS.value());
        result.setMsg(ResultMsg.MSG_SUCCESS);
        return result;
    }

    /**
     * 新增专家接口
     * @return
     */
    @ApiOperation(value = "新增专家", notes = "新增专家接口")
    @PostMapping("/add")
    public ResponseResult addExpert(@RequestBody Expert expert) {
        boolean isSuccess = scienceExpertService.save(expert);
        ResponseResult result = new ResponseResult();
        result.setStatus(isSuccess ? ResultStatus.SUCCESS.value() : ResultStatus.FAIL.value());
        result.setMsg(isSuccess ? ResultMsg.MSG_SUCCESS : ResultMsg.MSG_FAIL);
        return result;
    }

    /**
     * 通过ID获取专家信息
     * @return
     */
    @ApiOperation(value = "通过ID获取专家信息", notes = "通过ID获取专家信息接口")
    @GetMapping("/infoById")
    public ResponseResult<Expert> getExpertInfoById(@RequestParam (name = "id") String id) {
        ResponseResult<Expert> result = new ResponseResult<>();
        Expert expert = scienceExpertService.getById(id);
        result.setData(expert);
        result.setStatus(ResultStatus.SUCCESS.value());
        result.setMsg(ResultMsg.MSG_SUCCESS);
        return result;
    }


    /**
     * 通过姓名获取专家信息
     * @return
     */
    @ApiOperation(value = "通过姓名获取专家信息", notes = "通过姓名获取专家信息接口")
    @GetMapping("/infoByName")
    public ResponseResult<Expert> getExpertInfoByName(@RequestParam (name = "name") String name) {
        Expert expert = scienceExpertService.getExpertInfoByName(name);
        ResponseResult<Expert> result = new ResponseResult<>();
        result.setData(expert);
        result.setStatus(ResultStatus.SUCCESS.value());
        result.setMsg(ResultMsg.MSG_SUCCESS);
        return result;
    }



    /**
     * 修改专家信息接口
     * @return
     */
    @ApiOperation(value = "修改专家信息", notes = "修改专家信息接口")
    @PutMapping("/update")
    public ResponseResult updateExpert(@RequestBody Expert expert) {
        boolean isSuccess = scienceExpertService.updateById(expert);
        ResponseResult result = new ResponseResult();
        result.setStatus(isSuccess ? ResultStatus.SUCCESS.value() : ResultStatus.FAIL.value());
        result.setMsg(isSuccess ? ResultMsg.MSG_SUCCESS : ResultMsg.MSG_FAIL);
        return result;
    }

    /**
     * 删除专家信息接口
     * @return
     */
    @ApiOperation(value = "删除专家信息", notes = "删除专家信息接口")
    @DeleteMapping("/delete")
    public ResponseResult deleteExpert(@RequestParam (name = "id") String id) {
        boolean isSuccess = scienceExpertService.removeById(id);
        ResponseResult result = new ResponseResult();
        result.setStatus(isSuccess ? ResultStatus.SUCCESS.value() : ResultStatus.FAIL.value());
        result.setMsg(isSuccess ? ResultMsg.MSG_SUCCESS : ResultMsg.MSG_FAIL);
        return result;
    }

    /**
     * 专家评价添加
     * @return
     */
    @ApiOperation(value = "专家评价添加", notes = "专家评价添加")
    @PostMapping("/addExpertEvaluation")
    public ResponseResult addExpertEvaluation(@RequestBody ExpertEvaluate expertEvaluate) {
        boolean isSuccess = scienceExpertEvaluateService.save(expertEvaluate);
        ResponseResult result = new ResponseResult();
        result.setStatus(isSuccess ? ResultStatus.SUCCESS.value() : ResultStatus.FAIL.value());
        result.setMsg(isSuccess ? ResultMsg.MSG_SUCCESS : ResultMsg.MSG_FAIL);
        return result;
    }
    /**
     * 专家评价修改接口
     * @return
     */
    @ApiOperation(value = "专家评价修改", notes = "专家评价修改")
    @PutMapping("/updateExpertEvaluateById")
    public ResponseResult updateExpertEvaluate(@RequestBody ExpertEvaluate expert) {
        boolean isSuccess = scienceExpertEvaluateService.updateById(expert);
        ResponseResult result = new ResponseResult();
        result.setStatus(isSuccess ? ResultStatus.SUCCESS.value() : ResultStatus.FAIL.value());
        result.setMsg(isSuccess ? ResultMsg.MSG_SUCCESS : ResultMsg.MSG_FAIL);
        return result;
    }

    /**
     * 专家评价删除接口
     * @return
     */
    @ApiOperation(value = "专家评价删除", notes = "专家评价删除")
    @DeleteMapping("/deleteExpertEvaluate")
    public ResponseResult deleteExpertEvaluate(@RequestParam (name = "id") String id) {
        boolean isSuccess = scienceExpertEvaluateService.removeById(id);
        ResponseResult result = new ResponseResult();
        result.setStatus(isSuccess ? ResultStatus.SUCCESS.value() : ResultStatus.FAIL.value());
        result.setMsg(isSuccess ? ResultMsg.MSG_SUCCESS : ResultMsg.MSG_FAIL);
        return result;
    }
     /**
      * @Author hexy
      * @Description 专家评价审核
      * @Date 16:48 2020/10/15
      * @Param 
      * @return 
     */
    @ApiOperation(value = "专家评价审核", notes = "专家评价审核")
    @PutMapping("/updateExpertEvaluateStatus")
    @Transactional(rollbackFor = Exception.class)
    public ResponseResult updateExpertEvaluateStatus(@RequestParam(name = "id") String id,
                                                     @RequestParam(name = "verifyStatu") Integer verifyStatu) {
        boolean isSuccess = scienceExpertEvaluateService.updateExpertEvaluateStatus(id, verifyStatu);
        ResponseResult result = new ResponseResult();
        result.setStatus(isSuccess ? ResultStatus.SUCCESS.value() : ResultStatus.FAIL.value());
        result.setMsg(isSuccess ? ResultMsg.MSG_SUCCESS : ResultMsg.MSG_FAIL);
        return result;
    }
    /**
     * 获取专家评论列表接口
     * @return
     */
    @ApiOperation(value = "专家评价列表", notes = "专家评价列表")
    @GetMapping("/expertEvaluatelist")
    public ResponseResult<IPage<ExpertEvaluate>> getexpertEvaluatelist(@RequestParam(name = "pageNo", defaultValue = "1") Integer pageNo,
                                                       @RequestParam(name = "pageSize", defaultValue = "10") Integer pageSize,
                                                        EvaluateDto expert) {
        ResponseResult<IPage<ExpertEvaluate>> result = new ResponseResult<>();
        Page<ExpertEvaluate> page = new Page<>(pageNo, pageSize);
        IPage<ExpertEvaluate> expertList = scienceExpertEvaluateService.getexpertEvaluatelist(page,expert);
        result.setData(expertList);
        result.setStatus(ResultStatus.SUCCESS.value());
        result.setMsg(ResultMsg.MSG_SUCCESS);
        return result;
    }

}
