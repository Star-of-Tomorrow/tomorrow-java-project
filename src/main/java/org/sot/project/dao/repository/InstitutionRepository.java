package org.sot.project.dao.repository;

import org.sot.project.dao.dataobject.InstitutionsDO;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Timing
 * @since 2021/11/8 11:51 上午
 */
public interface InstitutionRepository extends JpaRepository<InstitutionsDO,String> {

	InstitutionsDO findByInstitutionsId(String institutionsId);
}
