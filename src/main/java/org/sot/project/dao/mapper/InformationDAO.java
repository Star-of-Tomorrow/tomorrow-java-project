package org.sot.project.dao.mapper;

import java.util.List;
import org.sot.project.dao.dataobject.InformationDO;

/**
 * @author ShiDu
 * @date 2021/11/2 10:25 上午
 */
public interface InformationDAO {

	int saveInformation(InformationDO informationDO);

	List<InformationDO> batchQueryInformationById(List<String> idList);
}
