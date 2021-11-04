package org.sot.project.dao.dataobject;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 评论DO
 * @author ShiDu
 * @date 2021/11/1 7:48 下午
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class CommentDO extends BaseDO{

	/**
	 * 关联活动Id
	 */
	private String informationId;

	/**
	 * 评论内容
	 */
	private String content;

	/**
	 * 评论Id
	 */
	private String userId;

	/**
	 * 图片url
	 */
	private String urls;

	/**
	 * 类型
	 */
	private String type;
}
