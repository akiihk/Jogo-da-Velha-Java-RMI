import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface Jogo extends Remote {
    String getJogador() throws RemoteException;
    boolean jogoNaoAcabou() throws RemoteException;
    void jogar(int linha, int coluna, String jogador) throws RemoteException;
    String getTabuleiro() throws RemoteException;
    String getResultado() throws RemoteException;
}
