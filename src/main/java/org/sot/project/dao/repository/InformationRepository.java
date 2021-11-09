package org.sot.project.dao.repository;

import java.util.List;
import org.sot.project.dao.dataobject.InformationDO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Timing
 * @since 2021/11/8 10:55 上午
 */
@Repository
public interface InformationRepository extends JpaRepository<InformationDO,String> {
	InformationDO save(InformationDO informationDO);

	List<InformationDO> findAllByUserId(List<String> userId);

	List<InformationDO> findAllByInformationType(String informationType);

	List<InformationDO> findAllByUserId(String userId);

	List<InformationDO> findAllByUserIdAndInformationType(String userId,String informationType);

	List<InformationDO> findAll();

	List<InformationDO> findAllByUserIdAndInformationType(List<String> userId, String informationType);

}
