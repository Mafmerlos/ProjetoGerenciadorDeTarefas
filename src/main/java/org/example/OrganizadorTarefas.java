package org.example;

import javax.swing.*;
import java.awt.*;

public class OrganizadorTarefas {
    private JFrame frame;
    private JTextField campoTitulo;
    private JTextField campoDescricao;
    private JTextField campoPrazo;

    public OrganizadorTarefas() {
        frame = new JFrame("Gerenciador de Tarefas");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);
        frame.setLayout(new GridLayout(4, 2));

        JLabel lblTitulo = new JLabel("Título:");
        campoTitulo = new JTextField();
        JLabel lblDescricao = new JLabel("Descrição:");
        campoDescricao = new JTextField();
        JLabel lblPrazo = new JLabel("Prazo:");
        campoPrazo = new JTextField();

        JButton btnSalvar = new JButton("Salvar");
        JButton btnSair = new JButton("Sair");

        btnSalvar.addActionListener(e -> salvarTarefa());
        btnSair.addActionListener(e -> frame.dispose());

        frame.add(lblTitulo);
        frame.add(campoTitulo);
        frame.add(lblDescricao);
        frame.add(campoDescricao);
        frame.add(lblPrazo);
        frame.add(campoPrazo);
        frame.add(btnSalvar);
        frame.add(btnSair);

        frame.setVisible(true);
    }

    private void salvarTarefa() {
        String titulo = campoTitulo.getText();
        String descricao = campoDescricao.getText();
        String prazo = campoPrazo.getText();

        if (titulo.isEmpty() || descricao.isEmpty() || prazo.isEmpty()) {
            JOptionPane.showMessageDialog(frame, "Preencha todos os campos!");
            return;
        }

        Tarefa tarefa = new Tarefa(titulo, descricao, prazo);
        if (TarefaDAO.salvarTarefa(tarefa)) {
            JOptionPane.showMessageDialog(frame, "Tarefa salva com sucesso!");
            limparCampos();
        } else {
            JOptionPane.showMessageDialog(frame, "Erro ao salvar a tarefa.");
        }
    }

    private void limparCampos() {
        campoTitulo.setText("");
        campoDescricao.setText("");
        campoPrazo.setText("");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(OrganizadorTarefas::new);
    }
}
