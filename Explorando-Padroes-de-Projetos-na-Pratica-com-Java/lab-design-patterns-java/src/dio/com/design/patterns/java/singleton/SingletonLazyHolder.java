package dio.com.design.patterns.java.singleton;

/**
 * Singleton "Lazy Holder"
 * @see <a href="https://stackoverflow.com/a/24018148">Referencia</a>
 * @author rosacarla
 */

//implementacao usada por ter consumo de memoria mais otimizado
public class SingletonLazyHolder {  //encapsula instancia em classe estatica interna

    private static class InstanceHolder {  //classe interna
        public static SingletonLazyHolder instancia = new SingletonLazyHolder();
    }

    private SingletonLazyHolder() {
        super();
    }

    public static SingletonLazyHolder getInstancia() {
        return InstanceHolder.instancia;
    }
}