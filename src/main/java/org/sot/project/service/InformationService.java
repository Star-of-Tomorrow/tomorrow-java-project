package org.sot.project.service;

import com.alibaba.fastjson.JSON;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.annotation.Resource;
import org.sot.project.controller.dto.CommentDTO;
import org.sot.project.controller.dto.LikeDTO;
import org.sot.project.controller.dto.InformationDTO;
import org.sot.project.dao.dataobject.CommentDO;
import org.sot.project.dao.dataobject.InformationDO;
import org.sot.project.dao.dataobject.UserLikeDO;
import org.sot.project.dao.mapper.CommentDAO;
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

	@Resource
	private CommentDAO commentDAO;

	public InformationDTO createInformation(InformationDTO informationDTO){
		//TODO:参数校验 增加根据类型的校验

		//TODO:封装下面的方法 转换
		InformationDO informationDO = new InformationDO();
		informationDO.init();
		informationDO.setUserId(informationDTO.getUserId());
		informationDO.setInformationName(informationDTO.getInformationName());
		informationDO.setInformationContent(informationDTO.getInformationContent());
		informationDO.setUrls(JSON.toJSONString(informationDTO.getUrls()));
		informationDO.setUrls(JSON.toJSONString(informationDTO.getComments()));
		informationDO.setInformationType(informationDTO.getInformationType());
		//存储
		boolean saveSuccess = informationDAO.saveInformation(informationDO)>0;
		if(saveSuccess){
			return informationDTO;
		}
		return null;
	}


	//轮播图片 选取三个活动
	public List<InformationDTO> queryInformationByTypeLimit3(String type) {
		List<InformationDO> informationDOList = informationDAO.queryInformationByType(type);
		List<InformationDTO>
			informationDTOs =
			informationDOList.stream().filter(informationDO -> informationDO.getUrls() != null).
				map(e -> information2InformationDTO(e))
				.limit(3)
				.collect(Collectors.toList());
		return informationDTOs;
	}


	public List<InformationDTO> queryInformationByType(String type) {
		List<InformationDO> informationDOList = informationDAO.queryInformationByType(type);
		List<InformationDTO>
			informationDTOs =
			informationDOList.stream().map(e -> information2InformationDTO(e))
				.collect(Collectors.toList());
		return informationDTOs;
	}

	public List<InformationDTO> queryInformationByUserId(String userId){
		List<InformationDO> informationDOList = informationDAO.queryInformationByUserId(userId);
		return informationDOList2informationDTOList(informationDOList);
	}

	public InformationDTO queryInformationByInformationId(String informationId){
		List<String> informationIdS = new ArrayList<>();
		informationIdS.add(informationId);
		List<InformationDO> informationDOList = informationDAO.batchQueryInformationById(informationIdS);
		List<InformationDTO> informationDTOList = informationDOList2informationDTOList(informationDOList);
		if (informationDTOList.size() == 0){
			return new InformationDTO();
		}else {
			return informationDTOList.get(0);
		}
	}

	public List<InformationDTO> queryInformationS(){
		List<InformationDO> informationDOList = informationDAO.queryInformationS();
		return informationDOList2informationDTOList(informationDOList);
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

	public List<InformationDTO> queryLikeInformationS(String userId) {
		List<UserLikeDO> userLikeDOS = userLikeDAO.queryUserLikeByUserId(userId);
		List<String> informationIds = userLikeDOS.stream().map(UserLikeDO::getInformationId)
				.collect(Collectors.toList());
		List<InformationDO> informationDOList = informationDAO.batchQueryInformationById(
				informationIds);
		return informationDOList2informationDTOList(informationDOList);
	}

	public InformationDTO information2InformationDTO(InformationDO informationDO) {
		InformationDTO informationDTO = new InformationDTO();
		informationDTO.setUserId(informationDO.getUserId());
		informationDTO.setInformationId(informationDO.getInformationId());
		informationDTO.setInformationName(informationDO.getInformationName());
		informationDTO.setInformationContent(informationDO.getInformationContent());
		informationDTO.setUrls(JSON.parseArray(informationDO.getUrls(), String.class));
		informationDTO.setInformationType(informationDO.getInformationType());
		informationDTO.setComments(commentDOList2commentDTOList(commentDAO.queryCommentSByInformationId(informationDO.getInformationId())));
		return informationDTO;
	}

	public List<InformationDTO> informationDOList2informationDTOList(List<InformationDO> informationDOList){
		List<InformationDTO> informationDTOList = new ArrayList<>();
		for (InformationDO informationDO : informationDOList){
			informationDTOList.add(information2InformationDTO(informationDO));
		}
		return informationDTOList;
	}

	//---------------------这里开始是评论相关的信息服务------------------------

	public Boolean saveComment(CommentDTO commentDTO){
		return commentDAO.insertComment(commentDTO2commentDO(commentDTO)) > 0;
	}

	public List<CommentDTO> queryCommentByUserId(String userId){
		return commentDOList2commentDTOList(commentDAO.queryCommentSByUserId(userId));
	}


	public CommentDO commentDTO2commentDO(CommentDTO commentDTO){
		CommentDO commentDO = new CommentDO();
		commentDO.setInformationId(commentDTO.getInformationId());
		commentDO.setContent(commentDTO.getContent());
		commentDO.setUserId(commentDTO.getUserId());
		commentDO.setUrls(JSON.toJSONString(commentDTO.getUrls()));
		commentDO.setType(commentDTO.getType());
		return commentDO;
	}

	public CommentDTO commentDO2commentDTO(CommentDO commentDO){
		CommentDTO commentDTO = new CommentDTO();
		commentDTO.setInformationId(commentDO.getInformationId());
		commentDTO.setContent(commentDO.getContent());
		commentDTO.setUserId(commentDO.getUserId());
		commentDTO.setUrls(JSON.parseObject(commentDO.getUrls(),List.class));
		commentDTO.setType(commentDO.getType());
		commentDTO.setCreateTime(commentDO.getCreateTime());
		return commentDTO;
	}

	public List<CommentDTO> commentDOList2commentDTOList(List<CommentDO> commentDOList){
		List<CommentDTO> commentDTOList = new ArrayList<>();
		for (CommentDO commentDO : commentDOList){
			commentDTOList.add(commentDO2commentDTO(commentDO));
		}
		return commentDTOList;
	}
}
