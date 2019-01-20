package ru.magazus.data.loaders.wrapper;


import java.util.HashMap;
import java.util.Map;

public class WrapperImpl implements Wrapper {

    public Object wrap(Object result) {
        Map<String, Object> hashMap = new HashMap<>();
        hashMap.put("status", "ok");
        hashMap.put("errors", "");
        hashMap.put("response", result);
        return hashMap;
    }

}
