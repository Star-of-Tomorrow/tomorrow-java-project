package org.sot.project.controller.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import lombok.Data;

/**
 * @description:
 * @author:maidang
 * @date:2021/11/03
 **/
@Data
public class ImageUrlDTO implements Serializable {

	private static final long serialVersionUID = 4216576611378742335L;

	//图片
	List<String> urls=new ArrayList<>();
}
