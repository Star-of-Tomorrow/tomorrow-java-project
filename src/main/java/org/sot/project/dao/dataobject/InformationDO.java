package org.sot.project.dao.dataobject;

import io.swagger.annotations.ApiModelProperty;
import java.util.Date;
import java.util.List;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.sot.project.entity.InformationTypeEnum;
import org.sot.project.entity.activity.Comment;
import org.sot.project.entity.user.User;

/**
 * @author ShiDu
 * @date 2021/11/1 7:56 下午
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class InformationDO extends BaseDO{

	/**
	 * 创建者
	 */
	private String userId;

	/**
	 * 信息名
	 */
	private String informationName;

	/**
	 * 信息正文
	 */
	private String informationContent;

	/**
	 * urls(数组转json)
	 */
	private String urls;

	/**
	 * 信息类型
	 */
	private String informationType;
}
