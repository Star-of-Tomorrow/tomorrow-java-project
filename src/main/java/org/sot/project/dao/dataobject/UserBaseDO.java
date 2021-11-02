package org.sot.project.dao.dataobject;

import io.swagger.annotations.ApiModelProperty;

/**
 * @author ShiDu
 * @date 2021/11/2 10:23 上午
 */
public class UserBaseDO extends BaseDO{

	/**
	 * 用户ID
	 */
	private String userId;

	/**
	 * 用户密码
	 */
	private String password;

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
