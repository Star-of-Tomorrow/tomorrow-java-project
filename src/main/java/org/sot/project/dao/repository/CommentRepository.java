package org.sot.project.dao.repository;

import java.util.List;
import org.sot.project.dao.dataobject.CommentDO;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Timing
 * @since 2021/11/8 11:15 上午
 */
public interface CommentRepository extends JpaRepository<CommentDO,String> {

	CommentDO save (CommentDO commentDO);

	List<CommentDO> findAllByUserId(String userId);

	List<CommentDO> findAllByInformationId(String informationId);
}
