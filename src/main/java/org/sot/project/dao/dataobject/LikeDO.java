package org.sot.project.dao.dataobject;

import lombok.Data;

/**
 * 点赞do
 * @author Timing
 * @date 2021/11/3 2:15 下午
 */
@Data
public class LikeDO extends BaseDO{

	/**
	 * userId
	 */
	private String userId;

	/**
	 * 信息Id
	 */
	private String InformationId;
}
