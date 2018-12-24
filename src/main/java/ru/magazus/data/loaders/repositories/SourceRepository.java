package ru.magazus.data.loaders.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.magazus.data.loaders.repositories.entities.Source;

@Repository
public interface SourceRepository extends CrudRepository<Source, Long> {

}
