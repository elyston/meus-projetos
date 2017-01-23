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
    public String marca;
    public int[] ano; 
    public int quantidade;;
    public String modelo;
    public double[] PLocacao;
    public double PModelo;
    carro(String marca, int quantidade, String modelo, double Pmodelo){
        Scanner input = new Scanner(System.in);
        this.ano = new int[quantidade];
        this.PLocacao = new double[quantidade];
        this.marca = marca;
        this.modelo = modelo;
        this.quantidade = quantidade;
        this.PModelo = Pmodelo;
        for(int i = 0; i < quantidade; i++){
            System.out.print("    ano do carro "+modelo+": ");
            this.ano[i] = input.nextInt();
            System.out.println();
            System.out.print("    valor da alocação do carro "+modelo+": ");
            this.PLocacao[i] = input.nextDouble();
            System.out.println();
        }
    }
    carro(){
        
    }
    //este método retorna pro método abaixo na sequencia quantos carros foram alocados
    void novaQuantidade(int cont){
       this.quantidade -= cont;
    }
    //este método indica pro cliente quantos carros estão disponiveis
    void mostraquantidade(String nodelo){
        for (int i = 0; i < this.quantidade; i++) {
            if(marca.equals(this.marca)){
                System.out.print("modelo: "+this.modelo+"    quantidade: "+this.quantidade);
            }
        }
    }
    void consulta(){
        System.out.println("carro " + this.modelo);
            System.out.println("fabricante " + this.marca);
            System.out.println("preço (modelo): " + this.PModelo);
            for(int j = 0; j < this.quantidade; j++){
                System.out.println("ano " + this.ano[j]);
                System.out.println("preço (locação): " + this.PLocacao[j]);
            }
            System.out.println("quantidade " + this.quantidade);
    }
}
