/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package locadoraveiculos;

import java.text.ParseException;
import java.util.Scanner;


/**
 *
 * @author elyston
 */
public class LocadoraVeiculos {

    /**
     * @param args the command line arguments
     * @throws java.text.ParseException
     */
    public static void main(String[] args) throws ParseException {
        // TODO code application logic here
        Scanner entre = new Scanner(System.in);
//        int cont = 0, c = 0;
        String nome, senha,D = null,CL = null;
        double juros = 0.12;
        gerente Q = new gerente("elyston", "788 476 212-91", "200 737", "99121 2861", "al. dos bambus", "###", "123 456", "123", 32, 0, "12 746 12 - RR");
        cliente[] C = new cliente[100];
        carro[] Carro = new carro[5];
        carro[] reserva = new carro[5];
        int cont1 = 0, cont2 = 0, cont3 = 0, comando = 0;
        login P1;
        do{
           System.out.println("login:");
            System.out.print("nome: ");        nome = entre.next();
            System.out.println();
            System.out.print("senha: ");        senha = entre.next();
            //área do administrador
            if(nome.equals(Q.getNome()) && senha.equals(Q.getSenha())){
                  P1 = Q;
                  System.out.println("1 - cadastro carro");
                  System.out.println("2 - exibe carros disponiveis");
                  System.out.println("3 - cadastro clientes");
                  System.out.println("4 - exibe clientes");
                  System.out.println("5 - visão geral dos carros");
                  System.out.println("6 - reservar carro");
                  System.out.println("7 - sair");
                  int OP = entre.nextInt();
                  if(OP != 7){
                      switch(OP){
                            case 1:  
                                System.out.print("entre com a marca do carro: ");     
                                String M = entre.next();    
                                System.out.println();
                                System.out.print("entre com o ano do carro: ");  
                                int ano = entre.nextInt();   
                                System.out.println();
                                System.out.print("entre com o modelo do carro: ");   
                                String N = entre.next(); 
                                System.out.println();
                                System.out.print("entre com o valor do modelo: ");    
                                double Valor = entre.nextDouble(); 
                                System.out.println();
                                Carro[cont1] = new carro(M, N, ano, Valor);
                                cont1++;
                                break;
                            case 2:
                                for (int i = 0; i < cont1; i++) {
                                    Carro[i].consulta();
                                }
                                break;
                            case 3:   
                                System.out.print("nome: ");    
                                String Nome = entre.next();     
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
                                System.out.print("data de nascimento: ");   
                                String dNasc = entre.next();     
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
                                C[cont2] = new cliente();
                                try {
                                    C[cont2].setData(dNasc);
                                } catch (IdadeMinimaException e) {
                                    System.out.println(e.getMessage());
                                }
                                
                                cont2++;
                                break;
                            case 4:  
                                for (int i = 0; i < cont2; i++) {
                                    System.out.println(C[i].getNome());
                                    System.out.println(C[i].getCPF());
                                    System.out.println(C[i].getRG());
                                }
                                break;
                            case 5:
                                for (int i = 0, j = 0; i < cont1 || j < cont3; i++, j++) {
                                    if(Carro[i].getModelo().equals(reserva[j].getModelo())){
                                        reserva[j].consulta();
                                    }else{
                                        Carro[i].consulta();
                                    }
                                }
                                break;
                            case 6:
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
                                        if(MCarro.equals(Carro[i].getModelo())){
                                            reserva[cont3] = new carro();
                                            reserva[cont3] = Carro[i];
                                            System.out.println("1 - a vista");
                                            System.out.println("2 - parcela");
                                            int op = entre.nextInt();
                                            if(op == 1){
                                                Q.pagamento(C[i], Carro[j].getPLocacao(), juros);
                                            }else{
                                                Q.pagamento(C[i], Carro[j].getPLocacao(),1);
                                            }
                                            cont3++;
                                            System.out.println("reserva feita com sucesso");
                                            C[i].setComprovante("transação efetuado com sucesso, pode vir pegar o carro");
                                        }
                                      }
                                   }
                                  }
                                
                                }
                                break;
                      }
                  }
//                System.out.println("numero de carros reservados");
                  for (int k = 0; k < cont3; k++) {
                      reserva[k].consulta();
                  }
            }else{
                System.out.printf("usuario nao encontrado\ndeseja se cadastrar? s/n");
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
                    System.out.print("data de nascimento: ");   
                    String idade = entre.next(); 
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
                    System.out.print("senha: ");
                    String Senha = entre.next();
                    System.out.println();
                    
                    C[cont2] = new cliente(nome, cpf, rg, phone, End, cnh, CC, Senha, A, dinheiro);
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
                        if(MCarro.equals(Carro[i].getModelo())){
                        reserva[cont3] = new carro();
                        reserva[cont3] = Carro[i];
                        System.out.println("1 - a vista");
                        System.out.println("2 - parcela");
                        int op = entre.nextInt();
                        if(op == 1){
                            C[i].pagamento(Q, Carro[i].getPLocacao(), juros);
                        }else{
                            C[i].pagamento(Q, Carro[i].getPLocacao(),1);
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
