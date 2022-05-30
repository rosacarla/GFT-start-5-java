package dio.com.design.patterns.java.singleton;

/**
 * Singleton "apressado"
 * @author rosacarla
 */

public class SingletonEager {  //atribui instancia quando a variavel estatica é definida

    private static SingletonEager instancia = new SingletonEager();

    private SingletonEager() {
        super();
    }

    public static SingletonEager getInstancia() {
        return instancia;
    }
}
