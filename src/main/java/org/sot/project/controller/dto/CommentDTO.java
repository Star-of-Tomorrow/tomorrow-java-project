package org.sot.project.controller.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @description:
 * @author:maidang
 * @date:2021/11/03
 **/
@Data
public class CommentDTO {
	@ApiModelProperty(value = "评论内容", required = true)
	String content;
}
