package org.sot.project.entity;

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
@ApiModel(value = "评论实体", description = "Comment Entity")
@FieldDefaults(level = AccessLevel.PUBLIC)
public class Comment extends AbstractEntity {
    //冗余
    @ApiModelProperty(value = "用户名字", required = true)
    String userName;
    @ApiModelProperty(value = "用户头像", required = true)
    String userPicUrl;
    @ApiModelProperty(value = "用户Id", required = true)
    String userId;

    @ApiModelProperty(value = "活动Id", required = true)
    String activityId;
    @ApiModelProperty(value = "活动名字", required = true)
    String activityName;


    @ApiModelProperty(value = "评论内容", required = true)
    String content;

}
