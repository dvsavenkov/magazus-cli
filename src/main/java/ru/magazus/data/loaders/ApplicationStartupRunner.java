package ru.magazus.data.loaders;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ApplicationStartupRunner {

    /*RegistryItemsService registryItemsService;

    ProxiesService proxiesService;

    ApplicationStartupRunner(RegistryItemsService registryItemsService, ProxiesService proxiesService) {
        this.registryItemsService = registryItemsService;
        this.proxiesService = proxiesService;
    }*/

    public static void main(String[] args) {
        SpringApplication.run(ApplicationStartupRunner.class, args);
    }

    /*@Override
    public void run(String... args) throws IOException {
        //proxiesService.load();
        //registryItemsService.loadItemsAndAttributes();
        //registryItemsService.loadItemRelations();
    }*/
}
