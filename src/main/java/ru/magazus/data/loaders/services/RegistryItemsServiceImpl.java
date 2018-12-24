package ru.magazus.data.loaders.services;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import ru.magazus.data.loaders.repositories.ItemsRelationRepository;
import ru.magazus.data.loaders.repositories.RegistryItemsAttributesRepository;
import ru.magazus.data.loaders.repositories.RegistryItemsRepository;
import ru.magazus.data.loaders.repositories.entities.*;
import ru.magazus.data.loaders.services.csv.CsvService;

import javax.transaction.Transactional;
import java.io.IOException;
import java.util.Date;
import java.util.Map;

@Service
@Transactional
public class RegistryItemsServiceImpl implements RegistryItemsService {

    protected final Log logger = LogFactory.getLog(RegistryItemsServiceImpl.class);

    @Value("${source.file.sourceid}")
    private String sourceId;

    @Value("${source.file.items}")
    private String fileItems;

    @Value("${source.file.relations}")
    private String fileRelations;

    private RegistryItemsRepository registryItemsRepository;

    private RegistryItemsAttributesRepository registryItemsAttributesRepository;

    private ItemsRelationRepository itemsRelationRepository;

    private CsvService csvService;

    @Autowired
    public RegistryItemsServiceImpl(RegistryItemsRepository registryItemsRepository,
                                    RegistryItemsAttributesRepository registryItemsAttributesRepository,
                                    ItemsRelationRepository itemsRelationRepository,
                                    CsvService csvService) {
        this.itemsRelationRepository = itemsRelationRepository;
        this.registryItemsAttributesRepository = registryItemsAttributesRepository;
        this.registryItemsRepository = registryItemsRepository;
        this.csvService = csvService;
    }

    @Override
    public void loadItemsAndAttributes() throws IOException {
        if (sourceId == null) {
            return;
        }

        for (Map<String, String> stringStringMap : csvService.get(fileItems)) {
            RegistryItems registryItems = new RegistryItems();
            RegistryItemsPK registryItemsPK = new RegistryItemsPK();
            registryItemsPK.setItemid(DigestUtils.md5Hex(sanitaze(stringStringMap.get("name"))));
            registryItemsPK.setSourceid(Integer.parseInt(sourceId));
            registryItems.setRegistryItemsPK(registryItemsPK);
            registryItemsRepository.save(registryItems);
            for (Map.Entry<String, String> entry : stringStringMap.entrySet()) {
                RegistryItemsAttributes attributes = new RegistryItemsAttributes();
                attributes.setSourceid(Integer.parseInt(sourceId));
                attributes.setAttribute(entry.getKey());
                attributes.setValue(entry.getValue());
                attributes.setItemid(DigestUtils.md5Hex(sanitaze(stringStringMap.get("name"))));
                registryItemsAttributesRepository.save(attributes);
            }
        }
    }

    @Override
    public void loadItemRelations() throws IOException {
        for (Map<String, String> stringStringMap : csvService.get(fileRelations)) {
            if (stringStringMap.get("relurl") == null || stringStringMap.get("relurl").equals(""))
                continue;
            ItemsRelation itemsRelation = new ItemsRelation();
            ItemsRelationPK itemsRelationPK = new ItemsRelationPK();
            itemsRelationPK.setItemid(DigestUtils.md5Hex(sanitaze(stringStringMap.get("name"))));
            itemsRelationPK.setRegionId(Integer.parseInt(stringStringMap.get("regionid")));
            itemsRelationPK.setSourceId(Integer.parseInt(sourceId));
            itemsRelationPK.setRelSourceId(Integer.parseInt(stringStringMap.get("relsourceid")));
            itemsRelationPK.setRelItemId(DigestUtils.md5Hex(stringStringMap.get("relurl")));
            itemsRelation.setInsDate(new Date());
            itemsRelation.setItemsRelationPK(itemsRelationPK);
            itemsRelation.setRelUrl(stringStringMap.get("relurl"));
            itemsRelation.setUrl(stringStringMap.get("url"));
            itemsRelationRepository.save(itemsRelation);
        }
    }

    private String sanitaze(String in) {
        if (in == null) {
            return null;
        }
        return in.toLowerCase().trim().replace(" ", "");
    }
}
