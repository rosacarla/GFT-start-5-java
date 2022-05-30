package dio.com.design.patterns.java.strategy;

public class Robo {
    private Comportamento comportamento;

    //metodo setter para classe Comportamento
    public void  setComportamento(Comportamento comportamento) {
        this.comportamento = comportamento;
    }

    public void mover() {
        comportamento.mover();
    }
}
