import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class JogoIMPL extends UnicastRemoteObject implements Jogo {

    String[][] matriz = new String[3][3];
    int qtdJogadoresConectados = 0;

    protected JogoIMPL() throws RemoteException{
        super();
    }

    @Override
    public String getJogador() throws RemoteException {
        qtdJogadoresConectados++;
        if(qtdJogadoresConectados == 1) {
            return "X";
        } else if(qtdJogadoresConectados == 2) {
            return "O";
        }
        return null;
    }

    @Override
    public boolean jogoNaoAcabou() throws RemoteException {
        return (matriz[y][0] == "X" && matriz[y][1] == "X" && matriz[y][2] == "X") ||
                (matriz[y][0] == "O" && matriz[y][1] == "O" && matriz[y][2] == "O") ||
                (matriz[0][x] == "X" && matriz[1][x] == "X" && matriz[2][x] == "X") ||
                (matriz[0][x] == "O" && matriz[1][x] == "O" && matriz[2][x] == "O") ||
                (matriz[0][0] == "X" && matriz[1][1] == "X" && matriz[2][2] == "X") ||
                (matriz[0][0] == "O" && matriz[1][1] == "O" && matriz[2][2] == "O") ||
                (matriz[0][2] == "X" && matriz[1][1] == "X" && matriz[2][0] == "X") ||
                (matriz[0][2] == "O" && matriz[1][1] == "O" && matriz[2][0] == "O");
    }

    @Override
    public void jogar(int linha, int coluna, String jogador) throws RemoteException {
        // validar antes se a  posição está realmente vazia
        matriz[linha][coluna] = jogador;
    }

    @Override
    public String getTabuleiro() throws RemoteException {
        return " " + matriz[0][0] + " | " + matriz[0][1] + " | " + matriz[0][2] + "\n"
                + "-----------\n";
    }

    @Override
    public String getResultado() throws RemoteException {
        return "";
    }
}
