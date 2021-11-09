package org.sot.project.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import java.util.List;
import javax.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.sot.project.common.ApiResponse;
import org.sot.project.common.DataType;
import org.sot.project.common.ParamType;
import org.sot.project.controller.dto.CommentDTO;
import org.sot.project.controller.dto.InformationDTO;
import org.sot.project.controller.dto.LikeDTO;
import org.sot.project.entity.InformationTypeEnum;
import org.sot.project.entity.activity.Comment;
import org.sot.project.service.InformationService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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

    @GetMapping("/informationByUserId")
    @ApiOperation(value = "活动及瞬间信息查询 通过用户id和type", notes = "")
    @ApiImplicitParams({@ApiImplicitParam(name = "userId", value = "用户Id", dataType = DataType.STRING, paramType = ParamType.PATH)})
    public ApiResponse<List<InformationDTO>> getInformationsByUserId(@RequestParam("userId") String userId, @RequestParam("type") String type) {
        return WebUtils.process(()->informationService.queryInformationByUserIdAndType(userId,type));
    }


    //todo 分页
    @GetMapping("/information/all")
    @ApiOperation(value = "查询所有活动或者瞬间列表", notes = "")
    public ApiResponse<List<InformationDTO>> getActivities(@RequestParam(value = "type", required = false) String type) {
        return WebUtils.process(()->informationService.queryInformationS(type));
    }

    @GetMapping("/information/institutions")
    @ApiOperation(value = "根据机构查询信息", notes = "")
    public ApiResponse<List<InformationDTO>> getActivitiesByInstitutions(@RequestParam("institutionId") String institutionId) {
        return WebUtils.process(()->informationService.queryInformationByInstitutionId(institutionId));
    }


    @GetMapping("/activity/{informationId}")
    @ApiOperation(value = "查询单个活动内容", notes = "")
    @ApiImplicitParams({@ApiImplicitParam(name = "activityId", value = "活动id", dataType = DataType.STRING, paramType = ParamType.PATH)})
    public ApiResponse<InformationDTO> getActivitiesByActivityId(@PathVariable String informationId) {
        return WebUtils.process(()->informationService.queryInformationByInformationId(informationId));
    }

    // 留言部分接口
    //todo
    @PostMapping(value = "/comments")
    @ApiOperation(value = "发表进展或评论")
    public ApiResponse<Boolean> postComment(@RequestBody CommentDTO commentDTO) {
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

    @GetMapping(value = "/shuffling")
    @ApiOperation(value = "轮播图")
    @ApiImplicitParams({@ApiImplicitParam(name = "type", value = "传活动类型", dataType = DataType.STRING, paramType = ParamType.PATH)})
    public ApiResponse<List<InformationDTO>> shuffling(String type) {
        //org.sot.project.entity.InformationTypeEnum.ACTIVITY    activity
        type= InformationTypeEnum.ACTIVITY.getTypeCode();
        String finalType = type;
        return WebUtils.process(()->informationService.queryInformationByTypeLimit3(finalType));
    }



    //用户权限校验接口
    @GetMapping(value = "/PermissionVerify")
    @ApiOperation(value = "用户权限校验接口")
    public ApiResponse<Boolean> PermissionVerify(@RequestParam("userId") String userId,@RequestParam("informationId") String informationId) {
        // infomation get userId match?
        // 用户发布权限
        InformationDTO informationDTO = informationService.queryInformationByInformationId(informationId);
        String userId1 = informationDTO.getUserId();
        if(userId==userId1){
            return ApiResponse.<Boolean>builder().code(200).message("操作成功").data(true).build();
        }
        return ApiResponse.<Boolean>builder().code(200).message("操作成功").data(false).build();
    }

}
