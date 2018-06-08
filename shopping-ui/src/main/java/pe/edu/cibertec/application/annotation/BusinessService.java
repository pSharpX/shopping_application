package pe.edu.cibertec.application.annotation;

import org.springframework.stereotype.Service;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Created by CHRISTIAN on 07/06/2018.
 */
@Service
@Retention(RetentionPolicy.RUNTIME)
public @interface BusinessService {
}
