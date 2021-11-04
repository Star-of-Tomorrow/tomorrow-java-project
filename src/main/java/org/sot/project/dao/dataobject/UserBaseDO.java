package org.sot.project.dao.dataobject;


import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;

/**
 * @author ShiDu
 * @date 2021/11/2 10:23 上午
 */
@Data
@Entity // jpa的注解，需要加
@Table(name = "table_user") // 指定数据库的表名
public class UserBaseDO extends BaseDO{


	/**
	 * 用户ID
	 */
	@Column(name = "user_id")
	private String userId;

	/**
	 * 微信唯一Id
	 */
	@Column(name = "open_id")
	private String openId;

	/**
	 * 微信全平台唯一Id
	 */
	@Column(name = "union_id")
	private String unionId;

	/**
	 * 用户名
	 */
	@Column(name = "user_name")
	private String userName;

	/**
	 * 头像
	 */
	@Column(name = "user_pic_url")
	private String userPicUrl;

	/**
	 * 用户类型  机构或者个人
	 */
	@Column(name = "type")
	private String type;

	/**
	 * 机构名字
	 */
	@Column(name = "institutions_name")
	private String institutionsName;
}
