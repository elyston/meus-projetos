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
    /**
     * método abstrato onde o cliente que usa uma ou outra conta poderá depositar o valor correspondente para a conta do gerente
     * @param dinheiro 
     */
    public abstract void deposita(double dinheiro);
    /**
     * método abstrato onde o cliente que usa uma ou outra conta poderá sacar o valor correspondente na sua conta
     * @param dinheiro 
     */
    public abstract void saca(double dinheiro);
    /**
     * método abstrato responsável por parcelar o pagamento caso for no cartão de crédito sem juros
     * @param mensalidade
     * @param valor
     * @return 
     */
    public double parcela(int mensalidade, double valor){
        return valor/mensalidade;
    }
    /**
     * método abstrato responsável por parcelar o pagamento caso for no cartão de crédito com juros
     * @param mensalidade
     * @param valor
     * @param juros
     * @return 
     */
    public double parcela(int mensalidade, double valor, double juros){
        return (valor/mensalidade)+juros;
    }
    /**
     * método abstrato que atualiza o juro conforme os meses passam
     * @param qtmeses
     * @param juros
     * @return 
     */
    public double atualizajuros(int qtmeses, double juros){
        double valorFinal = 0;
        for(int i = 1; i <= qtmeses; i++){
            valorFinal += (i*juros);
        }
        return valorFinal;
    }
}
