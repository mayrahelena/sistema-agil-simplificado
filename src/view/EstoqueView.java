package view;

import dao.EstoqueDAO;
import model.Produto;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.List;

public class EstoqueView extends JFrame {
    private JTextField txtNome, txtPreco, txtQuantidade;
    private JTextArea areaLista;
    private EstoqueDAO dao;

    public EstoqueView() {
        dao = new EstoqueDAO();
        setTitle("Cadastro de Produtos");
        setSize(400, 450);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        add(new JLabel("Nome:"));
        txtNome = new JTextField(25);
        add(txtNome);

        add(new JLabel("Preço:"));
        txtPreco = new JTextField(10);
        add(txtPreco);

        add(new JLabel("Quantidade:"));
        txtQuantidade = new JTextField(5);
        add(txtQuantidade);

        JButton btnSalvar = new JButton("Salvar Produto");
        btnSalvar.addActionListener(this::salvarProduto);
        add(btnSalvar);

        JButton btnListar = new JButton("Listar Produtos");
        btnListar.addActionListener(e -> listarProdutos());
        add(btnListar);

        areaLista = new JTextArea(15, 30);
        areaLista.setEditable(false);
        add(new JScrollPane(areaLista));

        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void salvarProduto(ActionEvent e) {
        String nome = txtNome.getText();
        double preco = Double.parseDouble(txtPreco.getText());
        int quantidade = Integer.parseInt(txtQuantidade.getText());

        Produto produto = new Produto(0, nome, preco, quantidade);
        dao.adicionarProduto(produto);
        JOptionPane.showMessageDialog(this, "Produto salvo com sucesso!");

        txtNome.setText("");
        txtPreco.setText("");
        txtQuantidade.setText("");
    }

    private void listarProdutos() {
        List<Produto> produtos = dao.listarProdutos();
        StringBuilder sb = new StringBuilder();
        for (Produto p : produtos) {
            sb.append("ID: ").append(p.getId())
              .append(" | Nome: ").append(p.getNome())
              .append(" | Preço: R$").append(p.getPreco())
              .append(" | Quantidade: ").append(p.getQuantidade())
              .append("\\n");
        }
        areaLista.setText(sb.toString());
    }
}