package org.sot.project.dao.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.sot.project.dao.dataobject.InformationDO;

import javax.sound.sampled.Line;

/**
 * @author ShiDu
 * @date 2021/11/2 10:25 上午
 */
@Mapper
public interface InformationMapper {

	int saveInformation(InformationDO informationDO);

	List<InformationDO> batchQueryInformationById(List<String> idList);

	List<InformationDO> queryInformationByType(String type);

	List<InformationDO> queryInformationByUserId(String userId);

	List<InformationDO> queryInformationS();
}
