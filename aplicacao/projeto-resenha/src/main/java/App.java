public class App {
    public static void main(String[] args) {
        Usuario jogador1 = new Jogador("Gabriel Wesley", "gw", "login1", 3, 300.00);
        Usuario jogador2 = new Jogador("Vinicius Oliveira", "vini", "login2", 2, 300.00);

        Usuario locatario1 = new Locatario("Robson", "robinho", "admin1", 1000.0);
        Usuario locatario2 = new Locatario("Ricardo", "ricardinho", "admin2", 1200.0);

        ControlePagamento controle = new ControlePagamento();

        System.out.println(jogador1);
        System.out.println("--------");
        System.out.println();
        System.out.println(jogador2);
        System.out.println("--------");
        System.out.println(locatario1);
        System.out.println("--------");
        System.out.println(locatario2);
        System.out.println("--------");
        System.out.println("Adicionando jogadores....");

        controle.adicionarJogador((Jogador) jogador1);
        controle.adicionarJogador((Jogador) jogador2);
        controle.exibirJogador();
    }
}
