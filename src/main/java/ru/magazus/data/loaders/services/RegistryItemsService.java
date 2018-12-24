package ru.magazus.data.loaders.services;

import java.io.IOException;

public interface RegistryItemsService {

    void loadItemsAndAttributes() throws IOException;

    void loadItemRelations() throws IOException;
}
