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
public class contacorrente extends conta{

    @Override
    public void deposita(double dinheiro){
        this.saldo += dinheiro;
    }

    @Override
    public void saca(double dinheiro) {
        this.saldo -= dinheiro;
    }
    
    
}
