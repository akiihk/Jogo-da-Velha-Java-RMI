import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;

public class Jogador {
    public static void main(String[] args) {
        try {
            Registry registry = LocateRegistry.getRegistry(
                    "localhost", 9089);
            JogoIMPL jogo = (JogoIMPL) registry.lookup("jogo");


            Scanner scanner = new Scanner(System.in);
            String Jogador =  jogo.getJogador();
            while (jogo.jogoNaoAcabou()){

                System.out.println("Digite a posição Horizontal: ");
                int linha = scanner.nextInt();
                System.out.println("Digite a posição vertical:");
                int coluna = scanner.nextInt();

                jogo.jogar(linha, coluna, Jogador);
                System.out.println(jogo.getTabuleiro());
            }
            System.out.println(jogo.getResultado());
        }


        catch (Exception e) {
            System.err.print("Erro: " + e);
            e.printStackTrace();
        }
    }
}
