package org.sot.project.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @description:
 * @author:maidang
 * @date:2021/11/04
 **/
@Getter
@AllArgsConstructor
public enum UserTypeEnum {

	ACTIVITY("personal","个人账号"),
	MOMENT("institutions","机构账号"),
	;
	private String typeCode;
	private String desc;
}
