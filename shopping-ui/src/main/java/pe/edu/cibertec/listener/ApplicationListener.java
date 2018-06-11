package pe.edu.cibertec.listener;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;
import pe.edu.cibertec.application.security.domain.User;
import pe.edu.cibertec.application.security.service.CustomUserDetailsService;
import pe.edu.cibertec.service.facade.UserAccountServiceFacade;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * Created by CHRISTIAN on 15/04/2018.
 */
public class ApplicationListener implements ServletContextListener {

    @Autowired
    private UserAccountServiceFacade userAccountServiceFacade;

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        /*AutowireCapableBeanFactory autowireCapableBeanFactory = WebApplicationContextUtils
                .getRequiredWebApplicationContext(sce.getServletContext()).getAutowireCapableBeanFactory();
        autowireCapableBeanFactory.autowireBean(this);
        repository.doSomething();*/

        ServletContext ctx = sce.getServletContext();
        WebApplicationContext springContext = WebApplicationContextUtils.getWebApplicationContext(ctx);
        UserAccountServiceFacade userAccountServiceFacade = springContext.getBean(UserAccountServiceFacade.class);
        String defaultUsername = "Christian";
        boolean exists = userAccountServiceFacade.existsUserAccount(defaultUsername);
        if(!exists){
            User user = new User();
            user.setUsername(defaultUsername);
            user.setPassword("123456");
            user.setEnabled(true);
            userAccountServiceFacade.createNewAccount(user);
        }
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
    }
}
