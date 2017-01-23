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
public class LocadoraVeiculos {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner entre = new Scanner(System.in);
        String nome, senha,dec,D = null,CL = null;
        double juros = 0.12;
        gerente Q = new gerente("elyston", "788 476 212-91", "200 737", "99121 2861", "al. dos bambus", "###", "123 456", "123", 32, 0, "12 746 12 - RR");
        cliente[] C = new cliente[100];
        carro[] Carro = new carro[5];
        carro[] reserva = new carro[5];
        int cont1 = 0, cont2 = 0, cont3 = 0, comando;
        login P1;
        do{
           System.out.println("login:");
            System.out.print("nome: ");        nome = entre.next();
            System.out.println();
            System.out.print("senha: ");        senha = entre.next();
            //área do administrador
            if(nome.equals(Q.getNome()) && senha.equals(Q.getSenha())){
                  P1 = Q;
                  do{
                      System.out.print("entre com a marca do carro: ");     String M = entre.next();    System.out.println();
                      System.out.print("entre com a quantidade do carro: ");  int quant = entre.nextInt();   System.out.println();
                      System.out.print("entre com o modelo do carro: ");   String N = entre.next(); System.out.println();
                      System.out.print("entre com o valor do modelo: ");    double Valor = entre.nextDouble(); System.out.println();
                      Carro[cont1] = new carro(M, quant, N, Valor);
                      System.out.print("deseja cadastrar outro modelo de carro s/n: "); dec = entre.next(); 
                      cont1++;
                  }while(cont1 < Carro.length && "s".equals(dec));
                  for (int i = 0; i < cont1; i++) {
                      Carro[i].consulta();
                  }
                  do{
                      System.out.print("deseja cadastrar um novo cliente? s/n: "); 
                      dec = entre.next();
                      if("s".equals(dec)){
                          System.out.print("nome: ");     
                          String N = entre.next();    
                          System.out.println();
                          System.out.print("endereço: ");  
                          String End = entre.next();   
                          System.out.println();
                          System.out.print("rg: ");   
                          String rg = entre.next(); 
                          System.out.println();
                          System.out.print("CPF: ");    
                          String cpf = entre.next(); 
                          System.out.println();
                          System.out.print("CNH: ");     
                          String cnh = entre.next();    
                          System.out.println();
                          System.out.print("numero do cartão de credito: ");  
                          String CC = entre.next();   
                          System.out.println();
                          System.out.print("idade: ");   
                          int idade = entre.nextInt(); 
                          System.out.println();
                          System.out.print("senha: ");    
                          String S = entre.next();  
                          System.out.println();
                          System.out.print("agencia: ");    
                          String A = entre.next();  
                          System.out.println();
                          System.out.print("telefone contato: ");    
                          String phone = entre.next();  
                          System.out.println();
                          System.out.print("saldo em conta: ");    
                          double dinheiro = entre.nextDouble();  
                          System.out.println();
                          C[cont2] = new cliente(N, cpf, rg, phone, End, cnh, CC, senha, idade, A, dinheiro);
                          cont2++;
                      }
                  }while(cont2 < C.length && "s".equals(dec));
                  for (int i = 0; i < cont2; i++) {
                      C[i].cliente();
                  }
                  do{
                      System.out.println("qual o seu nome?");
                      String NOME = entre.next();
                      for (int i = 0 ; i < cont2 ; i++) {
                        if(NOME.equals(C[i].getNome())){
                            System.out.println("deseja reservar o carro? s/n");
                            CL = entre.next();
                            if("s".equals(CL)){
                                  for(int j = 0; j < cont1; j++){
                                        Carro[i].consulta();
                                        System.out.print("que modelo de carro deseja reservar? "); 
                                        String MCarro = entre.next();  
                                        System.out.println();
                                        System.out.print("quantos carros deseja reservar "); 
                                        int QCarro = entre.nextInt();  
                                        System.out.println();
                                        if(MCarro.equals(Carro[i].modelo) && QCarro <= cont1){
                                            reserva[cont3] = new carro();
                                            reserva[cont3] = Carro[i];
                                            reserva[cont3].quantidade = QCarro;
                                            System.out.println("1 - a vista");
                                            System.out.println("2 - parcela");
                                            int op = entre.nextInt();
                                            if(op == 1){
                                                Q.pagamento(C[i], Carro[j].PModelo, juros);
                                            }else{
                                                Q.pagamento(C[i], Carro[j].PModelo,1);
                                            }
                                            cont3++;
                                            System.out.println("reserva feita com sucesso");
                                            System.out.println("saldo do cliente: " + C[j].C.getSaldo());
                                        }
                                  }
                            }
                            System.out.println("saldo do gerente: "+Q.C.getSaldo());
                        }

                      }
                  }while(cont3 < cont2 && "n".equals(CL));
                  System.out.println("numero de carros reservados");
                  for (int k = 0; k < cont3; k++) {
                      reserva[k].consulta();
                  }
            }else{
                System.out.println("deseja se cadastrar? s/n");
                D = entre.next();
                if("s".equals(D)){
                    System.out.print("nome: ");     
                    String N = entre.next();    
                    System.out.println();
                    System.out.print("endereço: ");  
                    String End = entre.next();   
                    System.out.println();
                    System.out.print("rg: ");   
                    String rg = entre.next(); 
                    System.out.println();
                    System.out.print("CPF: ");    
                    String cpf = entre.next(); 
                    System.out.println();
                    System.out.print("CNH: ");     
                    String cnh = entre.next();    
                    System.out.println();
                    System.out.print("numero do cartão de credito: ");  
                    String CC = entre.next();   
                    System.out.println();
                    System.out.print("idade: ");   
                    int idade = entre.nextInt(); 
                    System.out.println();
                    System.out.print("senha: ");    
                    String S = entre.next();  
                    System.out.println();
                    System.out.print("agencia: ");    
                    String A = entre.next();  
                    System.out.println();
                    System.out.print("telefone contato: ");    
                    String phone = entre.next();  
                    System.out.println();
                    System.out.print("saldo em conta: ");    
                    double dinheiro = entre.nextDouble();  
                    System.out.println();
                    C[cont2] = new cliente(N, cpf, rg, phone, End, cnh, CC, senha, idade, A, dinheiro);
                    cont2++;
                }
            }
            //área do cliente
            for (int i = 0; i < cont2; i++) {
                if(nome.equals(C[i].getNome()) && senha.equals(C[i].getSenha())){
                    System.out.println("reservar carro? s/n");
                    String car = entre.next();
                    if("s".equals(car)){
                        Carro[i].consulta();
                        System.out.print("que modelo de carro deseja reservar? "); 
                        String MCarro = entre.next();  
                        System.out.println();
                        System.out.print("quantos carros deseja reservar "); 
                        int QCarro = entre.nextInt();  
                        System.out.println();
                        if(MCarro.equals(Carro[i].modelo) && QCarro <= cont1){
                        reserva[cont3] = new carro();
                        reserva[cont3] = Carro[i];
                        reserva[cont3].quantidade = QCarro;
                        System.out.println("1 - a vista");
                        System.out.println("2 - parcela");
                        int op = entre.nextInt();
                        if(op == 1){
                            C[i].pagamento(Q, Carro[i].PModelo, juros);
                        }else{
                            C[i].pagamento(Q, Carro[i].PModelo,1);
                        }
                        cont3++;
                        System.out.println("reserva feita com sucesso");
                        C[i].setComprovante("pagamento efetuado, você já pode pegar seu carro");
                        }
                    }
                    System.out.print("gerar comprovante? s/n");
                    String comprovante = entre.next();
                    System.out.println();
                    if("s".equals(comprovante)){
                        System.out.println(C[i].getComprovante());
                    }
                }
            }
            System.out.print("TECLE 1 PARA FINALIZAR:");
            comando = entre.nextInt();
            System.out.println();
        }while(comando != 1);
        
    }
}
