package ru.magazus.data.loaders;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import ru.magazus.data.loaders.services.ProxiesService;
import ru.magazus.data.loaders.services.RegistryItemsService;

import java.io.IOException;

@SpringBootApplication
public class ApplicationStartupRunner implements CommandLineRunner {

    RegistryItemsService registryItemsService;

    ProxiesService proxiesService;

    ApplicationStartupRunner(RegistryItemsService registryItemsService, ProxiesService proxiesService) {
        this.registryItemsService = registryItemsService;
        this.proxiesService = proxiesService;
    }

    public static void main(String[] args) {
        SpringApplication.run(ApplicationStartupRunner.class, args);
    }

    @Override
    public void run(String... args) throws IOException {
        //proxiesService.load();
        //registryItemsService.loadItemsAndAttributes();
        registryItemsService.loadItemRelations();
    }
}
