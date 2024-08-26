package springsocket.k2.repository;

import org.springframework.data.repository.CrudRepository;
import springsocket.k2.entity.NumberEntity;

public interface NumberRepository extends CrudRepository<NumberEntity, Long> {
    NumberEntity findByIdentifier(String identifier);
}
