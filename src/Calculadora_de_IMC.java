import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Calculadora_de_IMC {
    private JTextField txtAltura;
    private JTextField txtPeso;
    private JButton btnCalcular;
    private JLabel lblResultado;
    private JLabel lblAltura;
    private JLabel lblPeso;
    private JLabel lblCampoBranco;
    private JPanel CalculadoradeIMC;
    private JLabel lblErro;

    private double altura = 0.0;
    private double peso = 0.0;
    private double imc = 0.0;
    private String categoria = "";

    public Calculadora_de_IMC() {

        btnCalcular.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if (txtAltura.getText().equals("") || txtPeso.getText().equals("")) {
                    lblCampoBranco.setText("Os campos devem ser preenchidos!");
                    lblResultado.setText("");
                }
                altura = Double.parseDouble(txtAltura.getText());
                peso = Double.parseDouble(txtPeso.getText());

                if (altura < 1.00 || altura > 2.50 && peso < 10.0 || peso > 250) {
                    lblErro.setText("Altura e peso incorretos!");
                } else if (peso < 10.0 || peso > 250) {
                    lblErro.setText("Peso incorreto!");
                } else if (altura < 1.00 || altura > 2.50) {
                    lblErro.setText("Altura incorreta!");
                } else {
                    lblErro.setText("");
                    imc = peso / (altura * altura);
                }
                if (imc >= 18.5 && imc < 25) {
                    categoria = (" normal ");
                } else if (imc >= 25 && imc < 30) {
                    categoria = (" Sobrepeso ");
                } else if (imc >= 30) {
                    categoria = (" Obesidade ");
                } else {
                    categoria = (" baixo peso ");
                }
                lblResultado.setText("Sua categoria de IMC é: " + categoria + " e seu IMC é: " + imc);
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Calculadora_de_IMC");
        frame.setContentPane(new Calculadora_de_IMC().CalculadoradeIMC);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);

    }
}