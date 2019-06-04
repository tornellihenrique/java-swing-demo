package view;

import controller.Core;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class Janela extends JFrame {

    private List<JLabel> labels = new ArrayList<>();
    private List<JTextField> fields = new ArrayList<>();
    private List<JButton> buttons = new ArrayList<>();

    private Core core = new Core(new ArrayList<>());

    public Janela() {
        super("Salve");
        setLayout(new GridLayout(4, 3));

        Actions actions = new Actions();

        labels.add(new JLabel("Digite o número:"));
        labels.add(new JLabel("Maior >>>"));
        labels.add(new JLabel("Menor >>>"));
        labels.add(new JLabel("Média >>>"));
        labels.add(new JLabel(""));

        fields.add(new JTextField(10));
        fields.add(new JTextField(10));
        fields.add(new JTextField(10));
        fields.add(new JTextField(10));

        buttons.add(new JButton("OK"));
        buttons.add(new JButton("Exibir"));
        buttons.add(new JButton("Visualizar números"));

        buttons.get(0).addActionListener(actions);
        buttons.get(1).addActionListener(actions);
        buttons.get(2).addActionListener(actions);

        add(labels.get(0));
        add(fields.get(0));
        add(buttons.get(0));
        add(labels.get(1));
        add(fields.get(1));
        add(labels.get(4));
        add(labels.get(2));
        add(fields.get(2));
        add(buttons.get(1));
        add(labels.get(3));
        add(fields.get(3));
        add(buttons.get(2));

    }

    private class Actions implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            if (e.getSource() == buttons.get(0)) {
                try {
                    core.addNumber(Integer.parseInt(fields.get(0).getText()));
                } catch (NumberFormatException err) {
                    JOptionPane.showMessageDialog(null, "Adicione apenas números!","ERRO", JOptionPane.ERROR_MESSAGE);
                } catch (Exception err) {
                    JOptionPane.showMessageDialog(null, err.getMessage(),"ERRO", JOptionPane.ERROR_MESSAGE);
                }
                fields.get(0).setText("");
            } else if (e.getSource() == buttons.get(1)) {
                try {
                    fields.get(1).setText(core.maior().toString());
                    fields.get(2).setText(core.menor().toString());
                    fields.get(3).setText(core.media().toString());
                } catch (ArrayIndexOutOfBoundsException err) {
                    JOptionPane.showMessageDialog(null, "Lista de números vazia!","ERRO", JOptionPane.ERROR_MESSAGE);
                } catch (Exception err) {
                    JOptionPane.showMessageDialog(null, err.getMessage(),"ERRO", JOptionPane.ERROR_MESSAGE);
                }
            } else if (e.getSource() == buttons.get(2)) {
                if (core.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Lista de números vazia!", "Números", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(null, core.toString(), "Números", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        }
    }
}
