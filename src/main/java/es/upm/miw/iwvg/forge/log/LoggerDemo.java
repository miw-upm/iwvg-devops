package es.upm.miw.iwvg.forge.log;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LoggerDemo {
    private List<Double> collection = new ArrayList<>();

    public void logs() {
        Logger logger = LogManager.getLogger(this.getClass().getName());
        logger.fatal("Log de fatal");
        logger.error("Log de error");
        logger.warn("Log de warning");
        logger.info("Log de info");
        logger.debug("Log de debug");
        logger.trace("Log de trace");
        
        double higher = Double.NEGATIVE_INFINITY;
        for (double item : this.collection) {
            if (item > higher) {
                higher = item;
            }
        }

    }

    public static void main(String[] args) {
        new LoggerDemo().logs();
    }

}
