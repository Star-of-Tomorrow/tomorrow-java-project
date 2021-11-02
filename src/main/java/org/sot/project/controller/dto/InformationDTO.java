package org.sot.project.controller.dto;

import io.swagger.annotations.ApiModelProperty;
import java.util.Date;
import java.util.List;
import lombok.Data;
import org.sot.project.entity.InformationTypeEnum;
import org.sot.project.entity.activity.Comment;
import org.sot.project.entity.user.User;

/**
 * @author ShiDu
 * @date 2021/11/2 10:39 上午
 */
@Data
public class InformationDTO {

	@ApiModelProperty(value = "创建者", required = true)
	private String userId;

	@ApiModelProperty(value = "活动名字", required = true)
	private String informationName;

	@ApiModelProperty(value = "活动内容", required = true)
	private String informationContent;

	@ApiModelProperty(value = "活动图片", required = true)
	private List<String> urls;

	@ApiModelProperty(value = "活动评论 仅 类型为活动时才有", required = true)
	private List<Comment> comments;

	@ApiModelProperty(value = "信息类型", required = true)
	private String informationType;
}
