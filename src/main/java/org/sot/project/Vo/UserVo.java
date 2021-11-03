package org.sot.project.Vo;

import org.sot.project.entity.user.User;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @description:
 * @author:maidang
 * @date:2021/11/03
 **/
@Data
public class UserVo extends User {
	@ApiModelProperty(value = "openId", required = true)
	String openId;

	@ApiModelProperty(value = "wxCode", required = true)
	String wxCode;

}
