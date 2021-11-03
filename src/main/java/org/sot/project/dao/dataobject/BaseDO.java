package org.sot.project.dao.dataobject;

import java.util.Date;
import lombok.Data;

/**
 * 基础DO
 * @author ShiDu
 * @date 2021/11/1 5:41 下午
 */
@Data
public class BaseDO {

	/**
	 * 主键Id
	 */
	private String id;

	/**
	 * 创建时间
	 */
	private Date createTime;

	/**
	 * 更新时间
	 */
	private Date updateTime;

	public void init(){
		this.createTime = new Date();
		this.updateTime = new Date();
	}
}
