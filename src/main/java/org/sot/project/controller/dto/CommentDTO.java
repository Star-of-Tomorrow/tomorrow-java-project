package org.sot.project.controller.dto;

import io.swagger.annotations.ApiModelProperty;
import java.util.Date;
import java.util.List;
import lombok.Data;
import org.sot.project.dao.dataobject.UserBaseDO;

/**
 * 最新进展及评论DTO
 * @author Timing
 * @date 2021/11/4 4:26 下午
 */
@Data
public class CommentDTO {

	@ApiModelProperty(value = "评论Id", required = true)
	private Long id;

	@ApiModelProperty(value = "评论内容", required = true)
	private String content;

	@ApiModelProperty(value = "类型  评论:comment   \t 活动进展:progress", required = true)
	private String type;

	@ApiModelProperty(value = "图片picList", required = true)
	private List<String> urls;

	@ApiModelProperty(value = "评论人", required = true)
	private String userId;

	/**
	 * 用户详情
	 */
	private UserBaseDO userBaseDO;

	@ApiModelProperty(value = "被评论的信息Id", required = true)
	private String informationId;

	@ApiModelProperty(value = "创建日期", required = true)
	private Date createTime;
}

