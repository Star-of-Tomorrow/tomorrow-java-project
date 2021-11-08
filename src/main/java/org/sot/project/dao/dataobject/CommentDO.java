package org.sot.project.dao.dataobject;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 评论DO
 * @author ShiDu
 * @date 2021/11/1 7:48 下午
 */
@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@Table(name = "comment")
public class CommentDO extends BaseDO{

	/**
	 * 关联活动Id
	 */
	@Column(name = "information_id")
	private String informationId;

	/**
	 * 评论内容
	 */
	@Column(name = "content")
	private String content;

	/**
	 * 评论Id
	 */
	@Column(name = "user_id")
	private String userId;

	/**
	 * 图片url
	 */
	@Column(name = "urls")
	private String urls;

	/**
	 * 类型
	 */
	@Column(name = "type")
	private String type;
}
