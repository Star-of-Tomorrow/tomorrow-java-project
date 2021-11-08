package org.sot.project.dao.dataobject;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import lombok.Data;

/**
 * 点赞do
 * @author Timing
 * @date 2021/11/3 2:15 下午
 */
@Data
@Entity
@Table(name = "user_like")
public class UserLikeDO extends BaseDO{

	/**
	 * userId
	 */
	@Column(name = "user_id")
	private String userId;

	/**
	 * 信息Id
	 */
	@Column(name = "information_id")
	private String informationId;
}
