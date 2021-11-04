package org.sot.project.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author Timing
 * @date 2021/11/4 4:27 下午
 */
@Getter
@AllArgsConstructor
public enum CommentTypeEnum {

	COMMENT("comment","评论类型"),
	PROGRESS("progress","活动进展"),
	;
	private String typeCode;
	private String desc;
}

