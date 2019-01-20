package ru.magazus.data.loaders.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.magazus.data.loaders.services.RevisionService;
import ru.magazus.data.loaders.wrapper.Wrapper;

@RestController
public class ExportController {

    private RevisionService revisionService;

    private Wrapper wrapper;

    @Autowired
    public ExportController(RevisionService revisionService, Wrapper wrapper) {
        this.revisionService = revisionService;
        this.wrapper = wrapper;
    }

    @RequestMapping(value = "/export/data", method = RequestMethod.GET)
    public Object getData(
            @RequestParam(name = "sourceid", defaultValue = "47") Long sourceId,
            @RequestParam(name = "regionid", defaultValue = "213") Long regionId) {
        return wrapper.wrap(revisionService.getRevision(sourceId, regionId));
    }

}
