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
public class cliente implements login{

    private String nome;
    private String CPF;
    private String RG;
    private String phone;
    private String end;
    private String CNH;
    private String CCredito;
    private String senha;
    private int idade;
    private String comprovante;
    conta C;
    public cliente(String nome, String CPF, String RG, String phone, String end, String CNH, String CCredito, String senha, int idade, String agencia, double saldo){
        this.C = new contacorrente();
        this.setNome(nome);
        this.setCPF(CPF);
        this.setEnd(end);
        this.setRG(RG);
        this.setCNH(CNH);
        this.setCCredito(CCredito);
        this.setPhone(phone);
        this.setSenha(senha);
        this.setIdade(idade);
        this.C.setAgencia(agencia);
        this.C.setSaldo(saldo);
    }
    //métodos encapsulados
    /**
     * @return the comprovante
     */
    public String getComprovante() {
        return comprovante;
    }

    /**
     * @param comprovante the comprovante to set
     */
    public void setComprovante(String comprovante) {
        this.comprovante = comprovante;
    }
    public void setIdade(int idade){
        this.idade = idade;
    }
    public int getIdade(){
        return this.idade;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getCPF() {
        return CPF;
    }
    public void setCPF(String CPF) {
        this.CPF = CPF;
    }
    public String getRG() {
        return RG;
    }
    public void setRG(String RG) {
        this.RG = RG;
    }
    public String getPhone() {
        return phone;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }
    public String getEnd() {
        return end;
    }
    public void setEnd(String end) {
        this.end = end;
    }
    public String getCNH() {
        return CNH;
    }
    public void setCNH(String CNH) {
        this.CNH = CNH;
    }
    public String getCCredito() {
        return CCredito;
    }
    public void setCCredito(String CCredito) {
        this.CCredito = CCredito;
    }
    public void setSenha(String senha){
        this.senha = senha;
    }
    public String getSenha(){
        return this.senha;
    }
    void cliente(){
        System.out.println("nome: "+this.getNome());
        System.out.println("CPF: "+this.getCPF());
        System.out.println("end: "+this.getEnd());
        System.out.println("CNH: "+this.getCNH());
        System.out.println("RG: "+this.getRG());
        System.out.println("CCredito: "+this.getCCredito());
        System.out.println("senha: "+this.getSenha());
        System.out.println("saldo na conta: "+this.C.saldo);
        System.out.println("agencia da conta: "+this.C.getAgencia());
    }

    @Override
    public cliente cadastro(String nome, String CPF, String rg, String CNH, String CCredito, String end, String senha, double saldo, String agencia){
        cliente c = null;
        c.setNome(nome);
        c.setCPF(CPF);
        c.setCNH(CNH);
        c.setEnd(end);
        c.setRG(rg);
        c.setCCredito(CCredito);
        c.setSenha(senha);
        c.C.setSaldo(saldo);
        c.C.setAgencia(agencia);
        return c;
    }

    @Override
    public carro reservar(carro v, int numcarros, String veiculo) {
        carro c = null;
        if(veiculo.equals(v.modelo)){
                c = v; 
                c.quantidade = numcarros;
                System.out.println("carro reservado com sucesso");
        }
        return c;
    }
    
    
    public void pagamento(gerente GE, double valor, double taxa) {
        Scanner input = new Scanner(System.in);
        int opcao1,opcao2,parcelas;
        String opcao;
        double custo;
        System.out.println("metodo de pagamento:");
        System.out.println("1 - cartão de credito");
        System.out.println("2 - transferencia em conta corrente:");
        System.out.print("digite a opção: ");
        opcao1 = input.nextInt();
        System.out.println();
        if(opcao1 == 1){
            System.out.println("1 - parcelado com juros");
            System.out.println("2 - parcelado sem juros");
            opcao2 = input.nextInt();
            switch(opcao2){
                case 1: 
                    System.out.print("entre com o numero do cartão de credito");
                    opcao = input.next();
                    if(opcao.equals(this.CCredito)){
                        System.out.print("digite o numero de parcelas: ");
                        parcelas = input.nextInt();
                        System.out.println();
                        custo = GE.C.parcela(parcelas, valor, taxa);
                        this.C.saca(custo);
                        GE.C.deposita(custo);
                    }
                    break;
                case 2:
                    System.out.print("entre com o numero da agencia");
                    opcao = input.next();
                    if(opcao.equals(this.C.agencia)){
                        System.out.print("digite o numero de parcelas: ");
                        parcelas = input.nextInt();
                        System.out.println();
                        custo = GE.C.parcela(parcelas,valor);
                        GE.C.deposita(custo);
                        this.C.saca(custo);
                    }
                    break;
            }
        }else{
            if(opcao1 == 2){
                String F, G;
                System.out.print("entre com dados de conta");
                F = input.next();
                if(F.equals(this.C.agencia)){
                    System.out.print("deseja transferir esse valor para sua conta?");
                    G = input.next();
                    System.out.println();
                    if("sim".equals(G)){
                        GE.C.deposita(valor);
                        this.C.saca(valor);
                    }
                }
            }
        }
        
        
    }

//    @Override
//    public void mostrarCarros(carro[] c) {
//        for (int i = 0, j = 0 ; i < c.length && j < c[i].quantidade; i++) {
//            c[i].consulta();
//        }
//    }
}
