/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package locadoraveiculos;

import java.util.Scanner;

/**
 *
 * @author elyston
 */
public class carro {
    private String marca;
    private int ano; 
    private String modelo;
    private double PLocacao;
    carro(String marca, String modelo, int ano, double Plocacao){
        this.setMarca(marca);
        this.setModelo(modelo);
        this.setAno(ano);
        this.setPLocacao(Plocacao);
    }
    carro(){
        
    }
    void consulta(){
        System.out.println("carro " + this.getModelo());
        System.out.println("fabricante " + this.getMarca());
        System.out.println("ano " + this.getAno());
        System.out.println("preço: " + this.getPLocacao());
    }

    /**
     * @return the marca
     */
    public String getMarca() {
        return marca;
    }

    /**
     * @param marca the marca to set
     */
    public void setMarca(String marca) {
        this.marca = marca;
    }

    /**
     * @return the ano
     */
    public int getAno() {
        return ano;
    }

    /**
     * @param ano the ano to set
     */
    public void setAno(int ano) {
        this.ano = ano;
    }

    /**
     * @return the modelo
     */
    public String getModelo() {
        return modelo;
    }

    /**
     * @param modelo the modelo to set
     */
    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    /**
     * @return the PLocacao
     */
    public double getPLocacao() {
        return PLocacao;
    }

    /**
     * @param PLocacao the PLocacao to set
     */
    public void setPLocacao(double PLocacao) {
        this.PLocacao = PLocacao;
    }
}
