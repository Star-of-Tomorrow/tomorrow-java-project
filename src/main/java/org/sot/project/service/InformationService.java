package org.sot.project.service;

import com.alibaba.fastjson.JSON;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.annotation.Resource;
import org.sot.project.controller.dto.LikeDTO;
import org.sot.project.controller.dto.InformationDTO;
import org.sot.project.dao.dataobject.InformationDO;
import org.sot.project.dao.dataobject.UserLikeDO;
import org.sot.project.dao.mapper.InformationDAO;
import org.sot.project.dao.mapper.UserLikeDAO;
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

	@Resource
	private UserLikeDAO userLikeDAO;

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

	public List<InformationDTO> queryInformationSByType(String type) {
		List<InformationDO> informationDOList = informationDAO.queryInformationByType(type);
		List<InformationDTO>
			informationDTOs =
			informationDOList.stream().map(e -> information2InformationDTO(e))
				.collect(Collectors.toList());
		return informationDTOs;
	}

	public Boolean giveLike(LikeDTO likeDTO){
		//TODO:幂等
		UserLikeDO userLikeDO = new UserLikeDO();
		userLikeDO.init();
		userLikeDO.setUserId(likeDTO.getUserId());
		userLikeDO.setInformationId(userLikeDO.getInformationId());
		//存储
		return userLikeDAO.saveUserLike(userLikeDO)>0;
	}

	public Boolean deleteLike(LikeDTO likeDTO){
		//TODO:幂等
		UserLikeDO userLikeDO = new UserLikeDO();
		userLikeDO.init();
		userLikeDO.setUserId(likeDTO.getUserId());
		userLikeDO.setInformationId(userLikeDO.getInformationId());
		//存储
		return userLikeDAO.deleteUserLike(userLikeDO)>0;
	}

	public List<InformationDTO> queryLikeInformationS(String userId){
		List<UserLikeDO> userLikeDOS = userLikeDAO.queryUserLikeByUserId(userId);
		List<String> informationIds = userLikeDOS.stream().map(UserLikeDO::getInformationId).collect(Collectors.toList());
		List<InformationDO> informationDOList = informationDAO.batchQueryInformationById(informationIds);
		List<InformationDTO> informationDTOList = new ArrayList<>();
		for (InformationDO informationDO : informationDOList){
			InformationDTO informationDTO = new InformationDTO();
			informationDTO.setInformationId(informationDO.getInformationId());
			informationDTO.setInformationName(informationDO.getInformationName());
			informationDTO.setInformationType(informationDO.getInformationType());
			informationDTO.setInformationContent(informationDO.getInformationContent());
			informationDTO.setUrls(JSON.parseObject(informationDO.getUrls(),List.class));
			//TODO:评论是否添加？
		}
		return informationDTOList;
	}

	public InformationDTO information2InformationDTO(InformationDO informationDO) {
		InformationDTO informationDTO = new InformationDTO();
		informationDTO.setUserId(informationDO.getUserId());
		informationDTO.setInformationId(informationDO.getInformationId());
		informationDTO.setInformationName(informationDO.getInformationName());
		informationDTO.setInformationContent(informationDO.getInformationContent());
		informationDTO.setUrls(JSON.parseArray(informationDO.getUrls(), String.class));
		informationDTO.setInformationType(informationDO.getInformationType());
		return informationDTO;
	}

}
