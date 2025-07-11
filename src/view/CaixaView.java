package view;

import dao.EstoqueDAO;
import model.Produto;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class CaixaView extends JFrame {
    private JTextField txtIdProduto, txtQuantidadeVendida;
    private EstoqueDAO dao;

    public CaixaView() {
        dao = new EstoqueDAO();
        setTitle("Sistema de Caixa");
        setSize(350, 250);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        add(new JLabel("ID do Produto:"));
        txtIdProduto = new JTextField(10);
        add(txtIdProduto);

        add(new JLabel("Quantidade Vendida:"));
        txtQuantidadeVendida = new JTextField(5);
        add(txtQuantidadeVendida);

        JButton btnVender = new JButton("Realizar Venda");
        btnVender.addActionListener(this::venderProduto);
        add(btnVender);

        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void venderProduto(ActionEvent e) {
        int id = Integer.parseInt(txtIdProduto.getText());
        int quantidadeVendida = Integer.parseInt(txtQuantidadeVendida.getText());

        Produto produto = dao.buscarPorId(id);

        if (produto == null) {
            JOptionPane.showMessageDialog(this, "Produto não encontrado.");
            return;
        }

        if (produto.getQuantidade() < quantidadeVendida) {
            JOptionPane.showMessageDialog(this, "Estoque insuficiente.");
            return;
        }

        int novaQuantidade = produto.getQuantidade() - quantidadeVendida;
        produto.setQuantidade(novaQuantidade);
        dao.atualizarProduto(produto);

        JOptionPane.showMessageDialog(this, "Venda realizada com sucesso!");

        txtIdProduto.setText("");
        txtQuantidadeVendida.setText("");
    }
}