import javax.swing.JOptionPane;
public class Cifrado_de_Vigenere_e_Cesar {
    public static void main(String[] args) {
        JOptionPane.showMessageDialog(null,"***ALGORITMO DE CRIPTOGRAFIA***\n"
                                         + "****ATENÇÃO LEIA O README******\n"
                                         + "******ANTES DE UTILIZAR******");
        String cadena, chave, rec, rec2 = "";
        int opc;
        do {
            opc = Integer.parseInt(JOptionPane.showInputDialog("Escolha uma opção: "
                    + "\n1 -Codificar Mensagem"
                    + "\n2 -Decodificar Mensagem"
                    + "\n0 -Sair"));

            if (opc == 1) {
                cadena = JOptionPane.showInputDialog("Insira a mensagem que seja Codificar!!!");
                chave = JOptionPane.showInputDialog("Chave");
                rec = Codificar(chave,cadena);
                
                JOptionPane.showMessageDialog(null, "A Primeira Encriptação ficou: \n" 
                                                    + rec 
                                                    +"\n\nA Codificação final ficou: \n"
                                                    + encriptar(Codificar(chave,cadena)));
            } else if (opc == 2) {
                cadena = JOptionPane.showInputDialog("Insira a mensagem que seja Decodificar!!!");
                chave = JOptionPane.showInputDialog("Chave");
                rec2 = Codificar(chave,cadena);
                JOptionPane.showMessageDialog(null, "A Decodificação final ficou: \n"
                                                    + Decodificar(chave,decriptar(cadena)));
            }
        } while (opc != 0);
        JOptionPane.showMessageDialog(null,"***OBRIGADO POR UTILIZAR***\n"
                                         + "******Desenvolvido por*****\n"
                                         + "*******Alex Pinheiro*******");
    }
    //Utilizando a Codificação através da crifra de Vigenere sempre em caixa Alta
    public static String Codificar(String pass,String Mensagem) {
        String sair = "";
        String Abcedario = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String chave = pass;
        char[] chaveEquals = new char[Mensagem.length()];
        char[] Msn = Mensagem.toUpperCase().toCharArray();
        int cont = 0;
        for (int c = 0; c < Mensagem.length(); c++) {
            if (Mensagem.charAt(c) == ' ') {
                c++;
            }
            chaveEquals[c] = chave.charAt(cont);
            cont++;
            if (cont == chave.length()) {
                cont = 0;
            }
        }
        int x = 0, y = 0, z;
        for (int c = 0; c < Mensagem.length(); c++) {
            if (Mensagem.charAt(c) == ' ') {
                sair += " ";
                c++;
            }
            for (int f = 0; f < Abcedario.length(); f++) {
                if (Msn[c] == Abcedario.charAt(f)) {
                    x = f;
                }
                if (chaveEquals[c] == Abcedario.charAt(f)) {
                    y = f;
                }
            }
            z = (x + y) % 26;
            sair += Abcedario.charAt(z);
        }
        return sair;
    }
    
    //Utilizando a encriptação através da crifra de cesar junto com a tabela ASCII
     public static String encriptar(String texto){
         int chave = 3;
      // Variavel que ira guardar o texto crifrado
      StringBuilder textoCifrado = new StringBuilder();
      // Variavel com tamanho do texto a ser encriptado
      int tamanhoTexto = texto.length();      
      // Criptografa cada caracter por vez 
      for(int c=0; c < tamanhoTexto; c++){
         // Transforma o caracter em codigo ASCII e faz a criptografia
         int letraCifradaASCII = ((int) texto.charAt(c)) + chave;         
         // Verifica se o codigo ASCII esta no limite dos caracteres imprimiveis
         while(letraCifradaASCII > 126)
            letraCifradaASCII -= 94;

         // Transforma codigo ASCII criptografado em caracter ao novo texto
         textoCifrado.append( (char)letraCifradaASCII );
      }      
      // Por fim retorna a mensagem criptografada por completo
      return textoCifrado.toString();
   }
    
    //Utilizando a Decodificação através da crifra de Vigenere sempre em caixa Alta
    public static String Decodificar(String pass, String Mensagem) {
        String sair = "";
        String Abcedario = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String chave = pass;
        char[] chaveEquals = new char[Mensagem.length()];
        char[] Msg = Mensagem.toUpperCase().toCharArray();
        int cont = 0;
        for (int c = 0; c < Mensagem.length(); c++) {
            if (Mensagem.charAt(c) == ' ') {
                c++;
            }
            chaveEquals[c] = chave.charAt(cont);
            cont++;
            if (cont == chave.length()) {
                cont = 0;
            }
        }
        cont = 0;
        int x = 0, y = 0, z, t;
        for (int c = 0; c < Mensagem.length(); c++) {
            if (Mensagem.charAt(c) == ' ') {
                sair += " ";
                c++;
            }
            for (int f = 0; f < Abcedario.length(); f++) {
                if (Msg[c] == Abcedario.charAt(f)) {
                    x = f;
                }
                if (chaveEquals[c] == Abcedario.charAt(f)) {
                    y = f;
                }
            }
            z = (y - x);

            if (z <= 0) {
                if (z == 0) {
                    sair += "A";
                } else {
                    for (int j = 1; j <= Abcedario.length(); j++) {
                        cont++;
                        if (cont == (z * -1)) {
                            sair += Abcedario.charAt(j);
                            break;
                        }
                    }
                }
            } else {
                for (int i = 25; i >= 0; i--) {
                    cont++;
                    if (cont == z) {
                        sair += Abcedario.charAt(i);
                        break;
                    }
                }
            }

            cont = 0;
        }
        return sair;
    }
    
    //Utilizando a Decriptação através da crifra de cesar junto com a tabela ASCII
    public static String decriptar(String textoCifrado){
        int chave = 3;
      // Variavel que ira guardar o texto decifrado
      StringBuilder texto = new StringBuilder();
      // Variavel com tamanho do texto a ser decriptado
      int tamanhoTexto = textoCifrado.length();
      
      // Descriptografa cada caracter por vez
      for(int c=0; c < tamanhoTexto; c++){
         // Transforma o caracter em codigo ASCII e faz a descriptografia
         int letraDecifradaASCII = ((int) textoCifrado.charAt(c)) - chave;
         
         // Verifica se o codigo ASCII esta no limite dos caracteres imprimiveis
         while(letraDecifradaASCII < 32)
            letraDecifradaASCII += 94;

         // Transforma codigo ASCII descriptografado em caracter ao novo texto
         texto.append( (char)letraDecifradaASCII );
      }
      
      // Por fim retorna a mensagem descriptografada por completo
      return texto.toString();
   }
}