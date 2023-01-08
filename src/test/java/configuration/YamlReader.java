package configuration;

import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import models.yamlConfigFramework.Config;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

public class YamlReader {
    private static Logger log = LoggerFactory.getLogger(YamlReader.class);
    private Config config;
    public YamlReader() {
        try{
            ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
            this.config = mapper.readValue(new File("src/main/resources/config.yaml"),Config.class);
            log.info("<<<Config YAML file has been read>>>");
        } catch (FileNotFoundException e){
            e.printStackTrace();
        } catch (StreamReadException e){
            e.printStackTrace();
        } catch (IOException e){
            e.printStackTrace();
        }
    }
    public Config getConfig(){
        return config;
    }
}
