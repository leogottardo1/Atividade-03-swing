import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Optional;

public class Cadastro_de_Contatos {
    private JPanel cadastrodecontatos;
    private JTextField txtnome;
    private JTextField txttelefone;
    private JTextField txtemail;
    private JButton btnadicionarcontato;
    private JButton btnlimpar;
    private JList liscontatos;
    private JLabel lblnomes;
    private JLabel lbltelefone;
    private JLabel lblemail;
    private JTextArea txtAstatus;

    private String nomes = "";
    private String telefones = "";
    private String email = "";
    private String informacoes = "";
    private ArrayList contatos = new ArrayList();
    private int i = 0;


    DefaultListModel<String> contatinhos = new DefaultListModel<>();

    public Cadastro_de_Contatos() {
        liscontatos.setModel(contatinhos);
        btnadicionarcontato.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                nomes = txtnome.getText();
                telefones = txttelefone.getText();
                email = txtemail.getText();

                if (nomes.isEmpty() || telefones.isEmpty() || email.isEmpty()) {
                    txtAstatus.setText("Preencha todos os campos acima");
                } else {
                    i++;
                    informacoes = +i + "° Contato Nome: " + nomes + ", Telefone:  " + telefones + " ,E-mail: " + email;
                    contatos.add(informacoes);
                    contatinhos.addElement(informacoes);
                }
            }
        });
        btnlimpar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                int excluir = liscontatos.getSelectedIndex();


                if (excluir != -1) {
                    contatos.remove(excluir);
                    contatinhos.removeElement(Optional.of(excluir));
                    txtAstatus.setText("Contato removido com sucesso!");
                } else {
                    txtAstatus.setText("Selecione um contato para remover.");
                }
            }
        });

    }


    public static void main(String[] args) {
        JFrame frame = new JFrame("Cadastro de Contatos");
        frame.setContentPane(new Cadastro_de_Contatos().cadastrodecontatos);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}

