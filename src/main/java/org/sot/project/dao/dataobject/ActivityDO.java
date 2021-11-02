package org.sot.project.dao.dataobject;

import io.swagger.annotations.ApiModelProperty;
import java.util.List;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 活动DO
 * @author ShiDu
 * @date 2021/11/1 5:50 下午
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class ActivityDO extends BaseDO{


	/**
	 * 活动创建者
	 */
	private Integer creatorId;

	/**
	 * 活动名字
	 */
	private String activityName;

	/**
	 * 活动内容
	 */
	private String activityContent;

	/**
	 * 活动图片Url
	 */
	private String urls;

}
