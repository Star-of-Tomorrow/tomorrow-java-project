package org.sot.project.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 信息类型枚举
 * @author ShiDu
 * @date 2021/11/2 10:12 上午
 */
@Getter
@AllArgsConstructor
public enum InformationTypeEnum {

	ACTIVITY("activity","活动类型"),
	MOMENT("moment","瞬间"),
	;
	private String typeCode;
	private String desc;
}
