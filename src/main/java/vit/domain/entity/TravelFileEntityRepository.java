package vit.domain.entity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TravelFileEntityRepository extends JpaRepository<TravelFileEntity, Long>{

}
