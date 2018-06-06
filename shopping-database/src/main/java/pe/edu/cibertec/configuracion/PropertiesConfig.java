package pe.edu.cibertec.configuracion;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

/**
 * Created by CHRISTIAN on 20/05/2018.
 */
@Configuration
public class PropertiesConfig {

    @Bean
    public static PropertySourcesPlaceholderConfigurer properties(){
        PropertySourcesPlaceholderConfigurer pspc = new PropertySourcesPlaceholderConfigurer();

        Resource[] archivosPropiedades = new Resource[]{
                new ClassPathResource("database.properties")
        };
        pspc.setLocations(archivosPropiedades);
        pspc.setIgnoreUnresolvablePlaceholders(true);
        return pspc;
    }
}
