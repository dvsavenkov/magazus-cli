package ru.magazus.data.loaders;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.magazus.data.loaders.wrapper.Wrapper;
import ru.magazus.data.loaders.wrapper.WrapperImpl;

@Configuration
public class ApplicationConfig {

    @Bean
    public Wrapper wrapper() {
        return new WrapperImpl();
    }
}

