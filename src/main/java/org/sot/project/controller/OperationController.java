package org.sot.project.controller;

import javax.annotation.Resource;
import org.sot.project.common.ApiResponse;
import org.sot.project.common.ParamType;
import org.sot.project.controller.dto.LikeDTO;
import org.sot.project.controller.dto.InformationDTO;
import org.sot.project.entity.activity.Activity;
import org.sot.project.entity.activity.Comment;
import org.sot.project.common.DataType;
import org.sot.project.entity.activity.Information;

import org.sot.project.service.InformationService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;

/**
 * @description:
 * @author:maidang
 * @date:2021/10/30
 **/
@RestController
@RequestMapping("/operation")
@Api(tags = "1.0.0-SNAPSHOT", description = "操作管理", value = "操作管理")
@Slf4j
public class OperationController {

    @Resource
    private InformationService informationService;

    //活动部分接口
    @PostMapping(value = "/activity")
    @ApiOperation(value = "创建活动")
    public Activity createActivity(@RequestBody Activity activity) {
        log.info("如果是 POST PUT 这种带 @RequestBody 的可以不用写 @ApiImplicitParam");
        return activity;
    }

    @GetMapping("/activity/{userId}")
    @ApiOperation(value = "活动列表查询 通过用户id", notes = "")
    @ApiImplicitParams({@ApiImplicitParam(name = "userId", value = "用户Id", dataType = DataType.STRING, paramType = ParamType.PATH)})
    public ApiResponse<List<Activity>> getActivitiesByUserId(@PathVariable String userId) {
        log.info("单个参数用  @ApiImplicitParam");
        return ApiResponse.<List<Activity>>builder().code(200).message("操作成功").data(new ArrayList()).build();
    }

    @GetMapping("/activity/all")
    @ApiOperation(value = "查询所有活动列表", notes = "")
    public ApiResponse<List<Activity>> getActivities() {
        log.info("单个参数用  @ApiImplicitParam");
        return ApiResponse.<List<Activity>>builder().code(200).message("操作成功").data(new ArrayList()).build();
    }

    @GetMapping("/activity/{activityId}")
    @ApiOperation(value = "查询单个活动内容", notes = "")
    @ApiImplicitParams({@ApiImplicitParam(name = "activityId", value = "活动id", dataType = DataType.STRING, paramType = ParamType.PATH)})
    public ApiResponse<List<Activity>> getActivitiesByActivityId(@PathVariable String activityId) {
        log.info("单个参数用  @ApiImplicitParam");
        //查活动 获取活动信息
        //查留言 获取留言信息
        //查用户信息
        return ApiResponse.<List<Activity>>builder().code(200).message("操作成功").data(new ArrayList()).build();
    }

    // 留言部分接口
    @PostMapping(value = "/comments")
    @ApiOperation(value = "发布留言")
    public ApiResponse<Information> postComment(@RequestBody InformationDTO informationDTO) {
        return WebUtils.process(()->informationService.postComment(informationDTO));
    }
    //做一个分页接口
    @GetMapping("/comments/{userId}")
    @ApiOperation(value = "留言列表查询", notes = "")
    @ApiImplicitParams({@ApiImplicitParam(name = "userId", value = "用户Id", dataType = DataType.STRING, paramType = ParamType.PATH)})
    public ApiResponse<List<Comment>> getComments(@PathVariable String userId) {
        log.info("单个参数用  @ApiImplicitParam");
        return ApiResponse.<List<Comment>>builder().code(200).message("操作成功").data(new ArrayList()).build();
    }

    @PostMapping(value = "/giveLike")
    @ApiOperation(value = "点赞操作")
    public ApiResponse<Boolean> giveLike(@RequestBody LikeDTO likeDTO) {
        return WebUtils.process(()->informationService.giveLike(likeDTO));
    }

    @PostMapping(value = "/deleteLike")
    @ApiOperation(value = "取消点赞操作")
    @ApiImplicitParams({@ApiImplicitParam(name = "", value = "", dataType = DataType.STRING, paramType = ParamType.PATH)})
    public ApiResponse<Boolean> deleteLike(@RequestBody LikeDTO likeDTO) {
        return WebUtils.process(()->informationService.deleteLike(likeDTO));
    }

    @PostMapping(value = "/queryUserLike")
    @ApiOperation(value = "查询用户点赞过的内容")
    @ApiImplicitParams({@ApiImplicitParam(name = "userId", value = "用户id", dataType = DataType.STRING, paramType = ParamType.PATH)})
    public ApiResponse<List<InformationDTO>> queryUserLike( String userId) {
        return WebUtils.process(()->informationService.queryLikeInformationS(userId));
    }


    //轮播图接口
    @GetMapping(value = "/shuffling")
    @ApiOperation(value = "轮播图")
    @ApiImplicitParams({@ApiImplicitParam(name = "type", value = "可传可不传", dataType = DataType.STRING, paramType = ParamType.PATH)})
    public ApiResponse<List<Information>> shuffling(String type) {
        //type指定为活动类型
        return WebUtils.process(()->informationService.queryInformationSByType(type));
    }


    //用户权限校验接口
    @PostMapping(value = "/PermissionVerify")
    @ApiOperation(value = "用户权限校验接口")
    @ApiImplicitParams({@ApiImplicitParam(name = "type", value = "可传可不传", dataType = DataType.STRING, paramType = ParamType.PATH)})
    public ApiResponse<Boolean> PermissionVerify(@RequestBody InformationDTO informationDTO) {
        // infomation get userId match?
        String userId = informationDTO.getUserId();
        String informationId = informationDTO.getInformationId();
        return ApiResponse.<List<Comment>>builder().code(200).message("操作成功").data(new ArrayList()).build();
    }






}
