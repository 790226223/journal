package chenweipan.journal.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@ConfigurationProperties(prefix = "journal")
@Component
public class PropertiesConfig {
}
