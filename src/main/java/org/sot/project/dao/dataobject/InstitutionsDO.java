package org.sot.project.dao.dataobject;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @description:
 * @author:maidang
 * @date:2021/11/04
 **/
@EqualsAndHashCode(callSuper = true)
@Data
public class InstitutionsDO extends BaseDO{

	/**
	 * 机构id
	 */
	private String institutionsId;

	/**
	 * 机构名字
	 */
	private String institutionsName;

}
