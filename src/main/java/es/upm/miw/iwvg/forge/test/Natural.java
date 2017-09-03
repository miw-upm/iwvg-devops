package es.upm.miw.iwvg.forge.test;

import org.apache.logging.log4j.LogManager;

public class Natural {

    private int value;

    public Natural(int value) {
        assert (value >= 0);
        this.value = value;
    }

    public int duplex() {
        LogManager.getLogger(this.getClass()).debug(">>>>>> Value:" + value);
        return value * 2;
    }

    public int getValue() {
        return value;
    }

}
