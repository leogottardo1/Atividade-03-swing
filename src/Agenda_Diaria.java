import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

public class Agenda_Diaria {
    private JTextField txtCompromisso;
    private JSpinner spnData;
    private JSpinner spnHora;
    private JTable tblResultado;
    private JButton btnRemover;
    private JButton btnAdicionar;
    private JPanel jpAgenda;
    private JLabel lblSelecioneData;
    private JLabel lblQualseuCompromisso;
    private JLabel lblselecioneHora;

    // Construtor da classe Agenda_Diaria
    public Agenda_Diaria() {
        // Inicializando os componentes
        txtCompromisso = new JTextField();
        spnData = new JSpinner();
        spnHora = new JSpinner();
        tblResultado = new JTable();
        btnRemover = new JButton("Remover");
        btnAdicionar = new JButton("Adicionar");
        jpAgenda = new JPanel();

        // Configuração do Spinner para Data (SpinnerDateModel)
        SpinnerDateModel dateModel = new SpinnerDateModel();
        spnData.setModel(dateModel);
        JSpinner.DateEditor editorData = new JSpinner.DateEditor(spnData, "dd/MM/yyyy");
        spnData.setEditor(editorData);

        // Configuração do Spinner para Hora (SpinnerDateModel)
        SpinnerDateModel timeModel = new SpinnerDateModel();
        spnHora.setModel(timeModel);
        JSpinner.DateEditor editorHora = new JSpinner.DateEditor(spnHora, "HH:mm:ss");
        spnHora.setEditor(editorHora);

        // Modelo da tabela
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Compromisso");
        model.addColumn("Data");
        model.addColumn("Hora");
        tblResultado.setModel(model);

        // Ação do botão "Adicionar"
        btnAdicionar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String compromisso = txtCompromisso.getText().trim();
                if (compromisso.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Por favor, insira um compromisso.");
                    return;
                }

                Date data = (Date) spnData.getValue();
                Date hora = (Date) spnHora.getValue();

                // Adiciona uma nova linha na tabela
                model.addRow(new Object[]{compromisso, data, hora});

                // Limpar o campo de texto após adicionar
                txtCompromisso.setText("");
            }
        });

        // Ação do botão "Remover"
        btnRemover.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedRow = tblResultado.getSelectedRow();
                if (selectedRow != -1) {
                    // Remove a linha selecionada da tabela
                    model.removeRow(selectedRow);
                } else {
                    JOptionPane.showMessageDialog(null, "Selecione um compromisso para remover.");
                }
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Agenda Diária");
        Agenda_Diaria agenda = new Agenda_Diaria();
        frame.setContentPane(agenda.jpAgenda);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
