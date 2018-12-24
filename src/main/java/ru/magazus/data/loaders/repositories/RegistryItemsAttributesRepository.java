package ru.magazus.data.loaders.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.magazus.data.loaders.repositories.entities.RegistryItemsAttributes;
import ru.magazus.data.loaders.repositories.entities.RegistryItemsAttributesPK;

import java.util.List;

@Repository
public interface RegistryItemsAttributesRepository extends CrudRepository<RegistryItemsAttributes, RegistryItemsAttributesPK> {

    List<RegistryItemsAttributes> getBySourceidAndItemidAndAttribute(Integer sourceid, String itemid, String attribute);

}
