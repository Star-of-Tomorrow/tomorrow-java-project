package org.sot.project.controller.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 点赞DTO
 * @author Timing
 * @date 2021/11/3 2:08 下午
 */
@Data
public class GiveLikeDTO {

	@ApiModelProperty(value = "点赞的用户ID", required = true)
	private String userId;

	@ApiModelProperty(value = "点赞的信息ID", required = true)
	private String informationId;

}
