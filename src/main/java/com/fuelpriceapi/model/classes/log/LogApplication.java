package com.fuelpriceapi.model.classes.log;
import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;

public class LogApplication {
    public Logger log;

    public LogApplication(String mensage, Class<?> clazz) {
        log.info("\nMensagem: {} | Classe: {}",
            mensage,
            clazz.getName()
        );
    }
}