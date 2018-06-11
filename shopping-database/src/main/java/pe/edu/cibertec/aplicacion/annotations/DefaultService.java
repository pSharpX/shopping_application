package pe.edu.cibertec.aplicacion.annotations;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Retention(RetentionPolicy.RUNTIME)
@Service
@Transactional(transactionManager = "defaultTransactionManager")
public @interface DefaultService {

}
