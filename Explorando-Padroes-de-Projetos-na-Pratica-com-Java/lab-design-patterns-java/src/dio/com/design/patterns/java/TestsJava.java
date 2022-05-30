package dio.com.design.patterns.java;

import dio.com.design.patterns.java.facade.Facade;
import dio.com.design.patterns.java.singleton.SingletonEager;
import dio.com.design.patterns.java.singleton.SingletonLazy;
import dio.com.design.patterns.java.singleton.SingletonLazyHolder;
import dio.com.design.patterns.java.strategy.*;

public class TestsJava {
    public static void main(String[] args) {

        //Testes relacionados ao Design Pattern Singleton:
        SingletonLazy lazy = SingletonLazy.getInstancia();
        System.out.println("-- Teste do SingletonLazy --");
        System.out.println(lazy); //imprime endereço de memoria da instancia
        lazy = SingletonLazy.getInstancia(); //pega nova instancia pra ver qual será o retorno
        System.out.println(lazy + "\n");  //imprime nova instancia

        //teste do eager; é esperado que devolva sempre a mesma instancia
        SingletonEager eager = SingletonEager.getInstancia();
        System.out.println("-- Teste do SingletonEager --");
        System.out.println(eager);
        eager = SingletonEager.getInstancia();
        System.out.println(eager + "\n");

        //teste do lazyHolder
        SingletonLazyHolder lazyHolder = SingletonLazyHolder.getInstancia();
        System.out.println("-- Teste do SingletonLazyHolder --");
        System.out.println(lazyHolder);
        lazyHolder = SingletonLazyHolder.getInstancia();
        System.out.println(lazyHolder + "\n");


        //Testes relacionados ao Design Pattern Strategy:
        Comportamento defensivo = new ComportamentoDefensivo();
        Comportamento normal = new ComportamentoNormal();
        Comportamento agressivo = new ComportamentoAgressivo();

        Robo robo = new Robo();  //instanciado novo robo
        System.out.println("-- Teste da Strategy para Robo --");
        robo.setComportamento(normal);
        robo.mover();
        robo.mover();
        robo.setComportamento(defensivo);
        robo.mover();
        robo.setComportamento(agressivo);
        robo.mover();
        robo.mover();
        robo.mover();

        //Testes relacionados ao Design Pattern Facade:
        Facade facade = new Facade();
        //Facade deve abstrair da API a recuperação de cidade/estado de sistemas integrados e grava cli no CRM
        System.out.println("\n-- Teste da Facade --");
        facade.migrarCliente("Carla Edila", "82720-000");  //chamada do metodo migrarCliente()
    }
}

