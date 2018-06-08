package pe.edu.cibertec.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * Created by CHRISTIAN on 07/06/2018.
 */
@Configuration
@EnableAspectJAutoProxy
@ComponentScan(basePackages = "pe.edu.cibertec.application.aspect")
public class AspectConfig {
}
