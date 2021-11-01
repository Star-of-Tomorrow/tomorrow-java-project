package org.sot.project.entity;

import java.util.Date;
import java.util.List;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

/**
 * @description:
 * @author:maidang
 * @date:2021/10/30
 **/
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(value = "活动实体", description = "Activity Entity")
@FieldDefaults(level = AccessLevel.PUBLIC)
public class Activity {

    //冗余
    @ApiModelProperty(value = "创建者用户名字", required = true)
    String userName;
    @ApiModelProperty(value = "创建者用户头像", required = true)
    String userPicUrl;



    @ApiModelProperty(value = "活动创建时间", required = true)
    Date time;
    @ApiModelProperty(value = "活动名字", required = true)
    String activityName;
    @ApiModelProperty(value = "活动内容", required = true)
    String activityContent;
    @ApiModelProperty(value = "活动图片", required = true)
    List<String> urls;
    @ApiModelProperty(value = "活动评论", required = true)
    List<Comment> comments;


}
