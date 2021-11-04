package org.sot.project.controller.dto;

import org.sot.project.dao.dataobject.BaseDO;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/**
 * @description:
 * @author:maidang
 * @date:2021/11/04
 **/
@Data
@Getter
@Setter
public class UserDTO extends BaseDO {

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
	 * 用户类型  机构或者个人
	 */
	private String type;

	/**
	 * 机构名字
	 */
	private String institutionsName;
}
