package org.sot.project.dao.dataobject;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author ShiDu
 * @date 2021/11/2 10:23 上午
 */
@Data
public class UserBaseDO extends BaseDO{

	/**
	 * 用户ID
	 */
	private String userId;

	/**
	 * 微信唯一Id
	 */
	private String openId;

	/**
	 * 微信全平台唯一Id
	 */
	private String unionId;

	/**
	 * 用户名
	 */
	private String userName;

	/**
	 * 头像
	 */
	private String userPicUrl;

	/**
	 * 用户类型
	 */
	private String type;
}
