package vit.domain.entity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberlEntityRepository extends JpaRepository<MemberlEntity, String>{

}
