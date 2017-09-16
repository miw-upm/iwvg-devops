package es.upm.miw.iwvg.forge.junit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LoggerDemo {

    public void logs() {
        Logger logger = LogManager.getLogger(this.getClass().getName());
        logger.fatal("Log de fatal");
        logger.error("Log de error");
        logger.warn("Log de warning");
        logger.info("Log de info");
        logger.debug("Log de debug");
        logger.trace("Log de trace");
    }
    public void logs2() {
        Logger logger = LogManager.getLogger(this.getClass().getName());
        logger.fatal("Log de fatal");
        logger.error("Log de error");
        logger.warn("Log de warning");
        logger.info("Log de info");
        logger.debug("Log de debug");
        logger.trace("Log de trace");
    }

    public static void main(String[] args) {
        new LoggerDemo().logs();
    }

}
