package dio.com.design.patterns.java.singleton;

/**
 * Singleton "preguiçoso"
 * @author rosacarla
 */

public class SingletonLazy {  //singleton nao disponibiliza instancia ao usuario inicialmente

    private static SingletonLazy instancia; //instancia de singleton

    //construtor do singleton privado pra não ser instanciado externamente
    private SingletonLazy() {
        super();  //resultado é o mesmo se nao tivesse chamada explicita com super()
    }

    //metodo getter controla a propria instancia
    public static SingletonLazy getInstancia() {
        if (instancia == null) {  //condicao pra criar instancia
            instancia = new SingletonLazy();
        }
        return instancia;
    }
}
