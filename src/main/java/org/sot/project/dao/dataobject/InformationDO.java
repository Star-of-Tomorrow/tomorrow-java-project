package org.sot.project.dao.dataobject;

import io.swagger.annotations.ApiModelProperty;
import java.util.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
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
@Entity
@Table(name = "information")
public class InformationDO extends BaseDO{

	/**
	 * 信息Id
	 */
	@Column(name = "information_id")
	private String informationId;

	/**
	 * 创建者
	 */
	@Column(name = "user_id")
	private String userId;

	/**
	 * 信息名
	 */
	@Column(name = "information_name")
	private String informationName;

	/**
	 * 信息正文
	 */
	@Column(name = "information_content")
	private String informationContent;

	/**
	 * urls(数组转json)
	 */
	@Column(name = "urls")
	private String urls;

	/**
	 * 信息类型
	 */
	@Column(name = "information_type")
	private String informationType;

}
