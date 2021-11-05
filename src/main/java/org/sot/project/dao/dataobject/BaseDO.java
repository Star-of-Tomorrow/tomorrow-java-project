package org.sot.project.dao.dataobject;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import lombok.Data;

/**
 * 基础DO
 * @author ShiDu
 * @date 2021/11/1 5:41 下午
 */
@Data
@MappedSuperclass
public class BaseDO {

	/**
	 * 主键Id
	 */
	@Id
	@GeneratedValue
	@Column(name = "id")
	private Long id;

	/**
	 * 创建时间
	 */
	@Column(name = "create_time")
	private Date createTime;

	/**
	 * 更新时间
	 */
	@Column(name = "update_time")
	private Date updateTime;

	public void init(){
		this.createTime = new Date();
		this.updateTime = new Date();
	}
}
