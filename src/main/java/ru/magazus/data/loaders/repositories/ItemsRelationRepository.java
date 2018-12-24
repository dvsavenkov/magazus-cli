package ru.magazus.data.loaders.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.magazus.data.loaders.repositories.entities.ItemsRelation;
import ru.magazus.data.loaders.repositories.entities.ItemsRelationPK;

@Repository
public interface ItemsRelationRepository extends CrudRepository<ItemsRelation, ItemsRelationPK> {

}
