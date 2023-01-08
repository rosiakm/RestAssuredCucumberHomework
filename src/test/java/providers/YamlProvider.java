package providers;

import configuration.YamlReader;
import models.yamlConfigFramework.Config;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;

public class YamlProvider {
    private Logger log = LoggerFactory.getLogger(YamlProvider.class);
    YamlReader yamlReader = new YamlReader();
    protected Config config;

    private YamlProvider(){
        setConfigProperties();
    }

    public static YamlProvider getInstance(){
        return YamlProvider.yamlProviderSingleton.INSTANCE;
    }
    private static class yamlProviderSingleton{
        private static final YamlProvider INSTANCE = new YamlProvider();
    }

    private void setConfigProperties() {
        config = yamlReader.getConfig();
        Map<String,String> dataProperties = config.getData();
        for (Map.Entry entry : dataProperties.entrySet()){
            System.setProperty(entry.getKey().toString(),entry.getValue().toString());
            log.info("Load testData properties: {} = {}", entry.getKey().toString(), entry.getValue().toString());
        }
    }
}
