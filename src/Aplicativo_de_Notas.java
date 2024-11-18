import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Aplicativo_de_Notas {
    private JPanel AplicativoDeNotas;
    private JTextField txtInserirNotas;
    private JButton btnadicionarNota;
    private JButton btncalcular;
    private JTextArea txtaListadeNotas;
    private JLabel lbldigitarnotas;
    private JLabel lblResultado;
    private JButton lbllimpar;

    Double aux = 0.0;
    double notas = 0;
    int i = 0;
    double media = 0;
    ArrayList listadeNotas = new ArrayList<>();


    public Aplicativo_de_Notas() {
        btnadicionarNota.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                notas = Double.parseDouble(txtInserirNotas.getText());
                aux = aux + notas;
                i++;
                listadeNotas.add(i);
                txtaListadeNotas.append(+i + "° nota " + notas + "\n");

            }
        });
        btncalcular.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                media = aux / i;
                if (media >= 7) {
                    lblResultado.setText("Aprovado " + media);
                } else {
                    lblResultado.setText("Reprovado " + media);
                }
            }
        });
        lbllimpar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                txtaListadeNotas.setText("");
                txtInserirNotas.setText("");
                lblResultado.setText("");
            }
        });

    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Aplicativo de Notas");
        frame.setContentPane(new Aplicativo_de_Notas().AplicativoDeNotas);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}





