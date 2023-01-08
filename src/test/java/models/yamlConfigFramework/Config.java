package models.yamlConfigFramework;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;

import java.util.LinkedHashMap;
import java.util.Map;

public class Config {
    Map<String, String> data = new LinkedHashMap<>();

    @JsonAnySetter
    void setData (String key, String value){
        data.put(key, value);
    }
    @JsonAnyGetter
    public Map<String, String> getData(){
        return data;
    }
}
