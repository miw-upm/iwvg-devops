package es.upm.miw.iwvg.forge.test;

public class NaturalDao {
    private Natural natural;

    public void save(Natural natural) {
        // Se guarda en la BD
        this.natural = natural;
    }

    public Natural findOne(Integer id) {
        // Se recupera de la BD
        return natural;
    }

}
