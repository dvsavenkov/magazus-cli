package ru.magazus.data.loaders.services.csv;

import com.fasterxml.jackson.databind.MappingIterator;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class CsvService {

    public List<Map<String, String>> get(String fileName) throws IOException {
        List<Map<String, String>> list = new ArrayList<>();
        File csvFile = new File(fileName);
        CsvMapper mapper = new CsvMapper();
        CsvSchema schema = CsvSchema.emptySchema().withHeader(); // use first row as header; otherwise defaults are fine
        MappingIterator<Map<String, String>> it = mapper.readerFor(Map.class)
                .with(schema)
                .readValues(csvFile);
        while (it.hasNext()) {
            Map<String, String> rowAsMap = it.next();
            list.add(rowAsMap);
        }
        return list;
    }


}
