package org.sot.project.dao.dataobject;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @description:
 * @author:maidang
 * @date:2021/11/04
 **/
@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@Table(name = "institutions")
public class InstitutionsDO extends BaseDO{

	/**
	 * 机构id
	 */
	@Column(name = "institutions_id")
	private String institutionsId;

	/**
	 * 机构名字
	 */
	@Column(name = "institutions_name")
	private String institutionsName;

	/**
	 * 机构图片
	 */
	@Column(name = "url")
	private String url;

}
