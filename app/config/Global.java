package config;

import play.GlobalSettings;
import play.Application;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Global extends GlobalSettings {
    private static final Logger logger = LoggerFactory.getLogger(Global.class);

    private ApplicationContext ctx;

    @Override
    public void onStart(Application a) {
        logger.info("Initializing ApplicationContext");
        ctx = new AnnotationConfigApplicationContext(AppConfig.class, DataConfig.class);
    }

    @Override
    public <A> A getControllerInstance(Class<A> clazz) {
        logger.trace("Getting controller instance {}", clazz.getName());
        return ctx.getBean(clazz);
    }
}