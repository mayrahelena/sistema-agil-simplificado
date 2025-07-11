import javax.swing.*;
import view.CaixaView;
import view.EstoqueView;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            String[] opcoes = {"Estoque", "Caixa"};
            int escolha = JOptionPane.showOptionDialog(null, "Escolha a tela:", "Sistema Ágil",
                    JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, opcoes, opcoes[0]);

            if (escolha == 0) {
                new EstoqueView();
            } else if (escolha == 1) {
                new CaixaView();
            }
        });
    }
}
