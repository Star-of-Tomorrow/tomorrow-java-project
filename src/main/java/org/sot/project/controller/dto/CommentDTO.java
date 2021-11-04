package org.sot.project.controller.dto;

import io.swagger.annotations.ApiModelProperty;
import java.util.List;

/**
 * 最新进展及评论DTO
 * @author Timing
 * @date 2021/11/4 4:26 下午
 */
public class CommentDTO {
	@ApiModelProperty(value = "评论内容", required = true)
	private String content;

	@ApiModelProperty(value = "类型  评论:comment   \t 活动进展:progress", required = true)
	private String type;

	@ApiModelProperty(value = "图片picList", required = true)
	private List<String> urls;

	@ApiModelProperty(value = "评论人", required = true)
	private String userId;

	@ApiModelProperty(value = "被评论的信息Id", required = true)
	private String informationId;
}

