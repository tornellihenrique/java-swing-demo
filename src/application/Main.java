package application;

import view.Janela;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        Janela janela = new Janela();
        janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        janela.setSize(500, 200 );
        janela.setVisible(true);
    }
}
