package ru.magazus.data.loaders.web;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UploadController {

    @RequestMapping("/upload/csv")
    public String uploadCsv() {
        return "uploadCsv1111";
    }

}
