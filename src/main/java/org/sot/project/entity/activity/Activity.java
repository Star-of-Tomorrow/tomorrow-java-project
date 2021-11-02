package org.sot.project.entity.activity;

import java.util.Date;
import java.util.List;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.sot.project.entity.user.User;

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

    @ApiModelProperty(value = "创建者", required = true)
    private User creator;

    @ApiModelProperty(value = "活动名字", required = true)
    private String activityName;

    @ApiModelProperty(value = "活动内容", required = true)
    private String activityContent;

    @ApiModelProperty(value = "活动图片", required = true)
    private List<String> urls;

    @ApiModelProperty(value = "活动评论", required = true)
    private List<Comment> comments;

    @ApiModelProperty(value = "活动创建时间", required = true)
    private Date createTime;
}
