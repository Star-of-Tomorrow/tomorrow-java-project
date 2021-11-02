package org.sot.project.entity.activity;

import java.util.Date;
import java.util.List;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.sot.project.entity.InformationTypeEnum;
import org.sot.project.entity.user.User;

/**
 * @description:
 * @author:maidang
 * @date:2021/10/30
 **/
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(value = "信息实体", description = "Information Entity")
@FieldDefaults(level = AccessLevel.PUBLIC)
public class Information{

    @ApiModelProperty(value = "创建者", required = true)
    private User creator;

    @ApiModelProperty(value = "活动名字", required = true)
    private String activityName;

    @ApiModelProperty(value = "活动内容", required = true)
    private String activityContent;

    @ApiModelProperty(value = "活动图片", required = true)
    private List<String> urls;

    @ApiModelProperty(value = "活动评论 仅 类型为活动时才有", required = true)
    private List<Comment> comments;

    @ApiModelProperty(value = "活动创建时间", required = true)
    private Date createTime;

    @ApiModelProperty(value = "信息类型", required = true)
    private InformationTypeEnum informationType;

}
