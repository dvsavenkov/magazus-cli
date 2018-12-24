package ru.magazus.data.loaders.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.magazus.data.loaders.repositories.entities.RegistryItems;
import ru.magazus.data.loaders.repositories.entities.RegistryItemsPK;

import java.util.List;

@Repository
public interface RegistryItemsRepository extends CrudRepository<RegistryItems, RegistryItemsPK> {

    List<RegistryItems> getBySourceId(Long sourceid);

}
