/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package locadoraveiculos;

import java.util.Date;
import java.util.Scanner;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

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
    private String comprovante;
    private String dataNasc;
    private Date dataFinal;
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    conta C;
    public cliente(String nome, String CPF, String RG, String phone, String end, String CNH, String CCredito, String senha, String agencia, double saldo){
        this.C = new contacorrente();
        this.setNome(nome);
        this.setCPF(CPF);
        this.setEnd(end);
        this.setRG(RG);
        this.setCNH(CNH);
        this.setCCredito(CCredito);
        this.setPhone(phone);
        this.setSenha(senha);
        this.C.setAgencia(agencia);
        this.C.setSaldo(saldo);
        
    }
    public cliente(){
        
    }
    /**
     * método que calcula idade segundo comparação com a data atual (hoje)
     * @param data
     * @return 
     */  
    public int calcularIdade(Date data){
        Calendar dataA = new GregorianCalendar();
        dataA.setTime(data);
        Calendar hoje = Calendar.getInstance();
        int idade = hoje.get(Calendar.YEAR) - dataA.get(Calendar.YEAR);
        dataA.add(Calendar.YEAR, idade);
        if(hoje.before(dataA)){
            idade--;
        }
        return idade;
    }
    /**
     * método que exibe a data de nascimento do cliente
     * @param data 
     */
    public void mostrarData(Date data){
        DateFormat df = DateFormat.getDateInstance(DateFormat.SHORT);
        String s = df.format(data);
        System.out.println("Data de Nasc.: "+s);
    }
    /**
     * método que retorna a data final
     * @return 
     */
    public Date getData(){
        return dataFinal;
    }
    /**
     * método que recebe a data de nascimento do usuário e calcula a idade comparando-o com a data atual, dando informação se o usuario tem permissão para dirigir
     * @param data
     * @throws ParseException
     * @throws IdadeMinimaException 
     */
    public void setData(String data) throws ParseException, IdadeMinimaException{
        Date dataTemp;
        dataTemp = sdf.parse(data);
        int idade;
        idade = calcularIdade(dataTemp);
        if(idade<=20){
            throw new IdadeMinimaException("Não será possivel realizar o cadastro,"+" idade minima para locação não permitida!"); 
        }
        else{
            this.dataNasc = data;
            this.dataFinal = dataTemp;
        }
        this.dataNasc = data;
    }
    public String getNome() {
        return nome;
    }
    //métodos encapsulados
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
    
    /**
     * método da interface LOGIN que cadastra usuário no sistema, tanto gerente quanto usuário podem acessar o sistema, desde que sejam devidamente cadastrados
     * @param nome
     * @param CPF
     * @param rg
     * @param CNH
     * @param CCredito
     * @param end
     * @param senha
     * @param saldo
     * @param agencia
     * @return 
     */
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
    /**
     * método da interface LOGIN responsável por requisitar um ou mais carro para a reserva
     * @param v
     * @param numcarros
     * @param veiculo
     * @return 
     */
    @Override
    public carro reservar(carro v, String veiculo) {
        carro c = null;
        if(veiculo.equals(v.getModelo())){
                c = v; 
                System.out.println("carro reservado com sucesso");
        }
        return c;
    }
    
    /**
     * o método solicita que o usuário informe o valor que poderá pagar segundo o preço em tabela e também as formas de pagamento, o usuário irá receber um comprovante para recebimento do veículo na concessionária  
     * @param GE
     * @param valor
     * @param taxa 
     */
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
}
