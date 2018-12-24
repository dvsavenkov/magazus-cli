package ru.magazus.data.loaders.repositories;

import org.springframework.data.repository.CrudRepository;
import ru.magazus.data.loaders.repositories.entities.Proxies;
import ru.magazus.data.loaders.repositories.entities.ProxiesPK;

public interface ProxiesRepository extends CrudRepository<Proxies, ProxiesPK> {

}
