/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package locadoraveiculos;

/**
 *
 * @author elyston
 */
abstract class conta {
    protected double saldo;
    protected String agencia;
    
    public void setSaldo(double valor){
        this.saldo = valor;
    }
    double getSaldo() {
        return this.saldo;
    }
    public void setAgencia(String agencia){
        this.agencia = agencia;
    }
    public String getAgencia(){
        return this.agencia;
    }
    public abstract void deposita(double dinheiro);
    public abstract void saca(double dinheiro);
    public double parcela(int mensalidade, double valor){
        return valor/mensalidade;
    }
    public double parcela(int mensalidade, double valor, double juros){
        return (valor/mensalidade)+juros;
    }
    public double atualizajuros(int qtmeses, double juros){
        double valorFinal = 0;
        for(int i = 1; i <= qtmeses; i++){
            valorFinal += (i*juros);
        }
        return valorFinal;
    }
}
