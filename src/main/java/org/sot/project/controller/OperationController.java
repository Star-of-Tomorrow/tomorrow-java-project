package org.sot.project.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.sot.project.common.ApiResponse;
import org.sot.project.common.DataType;
import org.sot.project.common.ParamType;
import org.sot.project.controller.dto.CommentDTO;
import org.sot.project.controller.dto.InformationDTO;
import org.sot.project.controller.dto.LikeDTO;
import org.sot.project.entity.activity.Activity;
import org.sot.project.entity.activity.Comment;
import org.sot.project.service.InformationService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    @PostMapping(value = "/createInformation")
    @ApiOperation(value = "创建活动或者发布瞬间")
    public ApiResponse<InformationDTO> createInformation(@RequestBody InformationDTO informationDTO) {
        return WebUtils.process(()->informationService.createInformation(informationDTO));
    }

    @GetMapping("/informationByUserId/{userId}")
    @ApiOperation(value = "活动及瞬间信息查询 通过用户id", notes = "")
    @ApiImplicitParams({@ApiImplicitParam(name = "userId", value = "用户Id", dataType = DataType.STRING, paramType = ParamType.PATH)})
    public ApiResponse<List<InformationDTO>> getInformationsByUserId(@PathVariable String userId) {
        return WebUtils.process(()->informationService.queryInformationByUserId(userId));
    }

    @GetMapping("/information/all")
    @ApiOperation(value = "查询所有活动列表", notes = "")
    public ApiResponse<List<InformationDTO>> getActivities() {
        return WebUtils.process(()->informationService.queryInformationS());
    }

    @GetMapping("/activity/{informationId}")
    @ApiOperation(value = "查询单个活动内容", notes = "")
    @ApiImplicitParams({@ApiImplicitParam(name = "activityId", value = "活动id", dataType = DataType.STRING, paramType = ParamType.PATH)})
    public ApiResponse<InformationDTO> getActivitiesByActivityId(@PathVariable String informationId) {
        return WebUtils.process(()->informationService.queryInformationByInformationId(informationId));
    }

    // 留言部分接口
    @PostMapping(value = "/comments")
    @ApiOperation(value = "发表进展或评论")
    public ApiResponse<InformationDTO> postComment(@RequestBody CommentDTO commentDTO) {
        return WebUtils.process(()->informationService.saveComment(commentDTO));
    }

    //做一个分页接口
    @GetMapping("/comments/{userId}")
    @ApiOperation(value = "根据用户Id查询评论及进展", notes = "")
    @ApiImplicitParams({@ApiImplicitParam(name = "userId", value = "用户Id", dataType = DataType.STRING, paramType = ParamType.PATH)})
    public ApiResponse<List<Comment>> getComments(@PathVariable String userId) {
        log.info("单个参数用  @ApiImplicitParam");
        return WebUtils.process(()->informationService.queryCommentByUserId(userId));
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
    public ApiResponse<List<InformationDTO>> shuffling(String type) {
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
