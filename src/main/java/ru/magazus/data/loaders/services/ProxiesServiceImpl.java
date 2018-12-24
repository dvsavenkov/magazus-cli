package ru.magazus.data.loaders.services;


import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import ru.magazus.data.loaders.repositories.ProxiesRepository;
import ru.magazus.data.loaders.repositories.entities.Proxies;
import ru.magazus.data.loaders.repositories.entities.ProxiesPK;
import ru.magazus.data.loaders.services.csv.CsvService;

import javax.transaction.Transactional;
import java.io.IOException;
import java.util.Map;

@Service
@Transactional
public class ProxiesServiceImpl implements ProxiesService {

    protected final Log logger = LogFactory.getLog(RegistryItemsServiceImpl.class);

    @Value("${proxies.file.list}")
    private String proxiesFileList;

    private CsvService csvService;

    private ProxiesRepository proxiesRepository;

    @Autowired
    public void ProxiesServiceImpl(CsvService csvService, ProxiesRepository proxiesRepository) {
        this.csvService = csvService;
        this.proxiesRepository = proxiesRepository;
    }

    @Override
    public void load() throws IOException {
        for (Map<String, String> stringStringMap : csvService.get(proxiesFileList)) {
            ProxiesPK proxiesPK = new ProxiesPK();
            proxiesPK.setIp(stringStringMap.get("ip"));
            proxiesPK.setPort(stringStringMap.get("port"));
            Proxies proxies = new Proxies();
            proxies.setPassword(null);
            proxies.setBlacklisted(0);
            proxies.setProxiesPK(proxiesPK);
            proxies.setProtocol("HTTP");
            proxies.setUser(null);
            proxies.setVer(4);
            proxiesRepository.save(proxies);
        }
    }
}
