import java.util.ArrayList;
import java.util.List;

public class ControlePagamento {
        List<Jogador> listaJogadores;
        List<Locatario> listaLocatarios;

        public ControlePagamento(){
                this.listaJogadores = new ArrayList<Jogador>();
                this.listaLocatarios = new ArrayList<Locatario>();
        }

        public void adicionarJogador(Jogador j){
                this.listaJogadores.add(j);
        }
        public void exibirJogador(){
                System.out.println("Lista de jogadores:");
                for(Jogador j : listaJogadores){
                        System.out.println(j);
                }
        }

}
