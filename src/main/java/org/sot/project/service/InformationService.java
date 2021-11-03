package org.sot.project.service;

import com.alibaba.fastjson.JSON;
import javax.annotation.Resource;
import lombok.Data;
import org.sot.project.controller.dto.GiveLikeDTO;
import org.sot.project.controller.dto.InformationDTO;
import org.sot.project.dao.dataobject.InformationDO;
import org.sot.project.dao.dataobject.LikeDO;
import org.sot.project.dao.mapper.InformationDAO;
import org.sot.project.entity.activity.Information;
import org.springframework.stereotype.Service;

/**
 * 信息相关Service
 * @author ShiDu
 * @date 2021/11/2 10:35 上午
 */
@Service
public class InformationService {

	@Resource
	private InformationDAO informationDAO;

	public Boolean postComment(InformationDTO informationDTO){
		//TODO:参数校验 增加根据类型的校验

		//TODO:封装下面的方法 转换
		InformationDO informationDO = new InformationDO();
		informationDO.initDO();
		informationDO.setUserId(informationDTO.getUserId());
		informationDO.setInformationName(informationDTO.getInformationName());
		informationDO.setInformationContent(informationDTO.getInformationContent());
		informationDO.setUrls(JSON.toJSONString(informationDTO.getUrls()));
		informationDO.setUrls(JSON.toJSONString(informationDTO.getComments()));
		informationDO.setInformationType(informationDTO.getInformationType());
		//存储
		return informationDAO.saveInformation(informationDO)>0;
	}

	public Boolean giveLike(GiveLikeDTO giveLikeDTO){

		LikeDO likeDO = new LikeDO();
		likeDO.init();
		likeDO.setUserId(giveLikeDTO.getUserId());
		likeDO.setInformationId(likeDO.getInformationId());
		//存储
		return informationDAO.saveInformation(informationDO)>0;
	}



}
