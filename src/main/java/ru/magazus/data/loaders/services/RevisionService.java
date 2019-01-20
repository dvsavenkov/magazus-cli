package ru.magazus.data.loaders.services;

import ru.magazus.data.loaders.dto.RevisionDTO;

import java.util.List;

public interface RevisionService {

    public List<RevisionDTO> getRevision(Long sourceId, Long regionId);

}
