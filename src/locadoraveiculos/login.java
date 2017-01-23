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
public interface login {
    abstract cliente cadastro(String nome, String CPF, String rg, String CNH, String CCredito, String end, String senha, double saldo, String agencia);
    public carro reservar(carro v, int numcarros, String veiculo);
//    public void mostrarCarros(carro[] c);
}
