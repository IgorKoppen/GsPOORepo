package br.com.gs.view;

import br.com.gs.model.Veiculo;
import br.com.gs.repository.VeiculoDAO;

import javax.swing.*;
import javax.swing.plaf.FontUIResource;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.StyleContext;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.List;
import java.util.Locale;


public class Home extends JFrame {
    VeiculosCadastroFrame cadastro = new VeiculosCadastroFrame();
    private static final long serialVersionUID = 1L;
    private JPanel MainPainel;
    private JTable tabela;
    private JPanel container;
    private JButton adicionar;
    private JButton deletar;
    private JButton alterar;
    private JButton Sair;
    private DefaultTableModel modelo;
    private VeiculoDAO dao = new VeiculoDAO();
    private Image icon = new ImageIcon(this.getClass().getResource("/iconCaminhao.png")).getImage();

    public Home() throws SQLException {
        setContentPane(MainPainel);

        setTitle("Home");
        setSize(700, 280);
        setMinimumSize(new Dimension(1200, 720));
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
        this.setIconImage(icon);
        modelo = (DefaultTableModel) tabela.getModel();
        modelo.addColumn("Codigo do veiculo");
        modelo.addColumn("Tipo");
        modelo.addColumn("refrigerado");
        modelo.addColumn("Proprietario");
        modelo.addColumn("Marca");
        modelo.addColumn("Modelo");
        modelo.addColumn("placa");
        modelo.addColumn("Data de entrada");
        modelo.addColumn("Tipo de combustivel");
        modelo.addColumn("Carga maxima(t)");
        modelo.addColumn("Tanque maxima(l)");
        preencherTabela();
        alterar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                alterar();
            }
        });
        deletar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                deletar();
            }
        });
        adicionar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    ChamarCadastro();
                } catch (SQLException error) {
                    error.printStackTrace();
                }
            }
        });
        Sair.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sair();
            }
        });
    }

    ;

    public void preencherTabela() {
        List<Veiculo> veiculos = dao.selectAll();
        try {
            for (Veiculo veiculo : veiculos) {
                modelo.addRow(new Object[]{veiculo.getCodVeiculo(), veiculo.getTipoVeiculo(), veiculo.getRefrigerado(), veiculo.getProprietario(), veiculo.getMarca(), veiculo.getModelo(), veiculo.getPlaca(), veiculo.getDateEntrada(), veiculo.getTipoCombustivel(), veiculo.getCargaMax(), veiculo.getTanqueMax()});
            }
        } catch (Exception e) {
            throw e;
        }
    }

    private void alterar() {
        Object objetoDaLinha = (Object) modelo.getValueAt(tabela.getSelectedRow(), tabela.getSelectedColumn());
        if (objetoDaLinha instanceof Integer) {
            Integer codVeiculo = (Integer) objetoDaLinha;
            String TipoVeiculo = (String) modelo.getValueAt(tabela.getSelectedRow(), 1);
            String Refrigerado = (String) modelo.getValueAt(tabela.getSelectedRow(), 2);
            String Proprietario = (String) modelo.getValueAt(tabela.getSelectedRow(), 3);
            String Marca = (String) modelo.getValueAt(tabela.getSelectedRow(), 4);
            String Modelo = (String) modelo.getValueAt(tabela.getSelectedRow(), 5);
            String Placa = (String) modelo.getValueAt(tabela.getSelectedRow(), 6);
            String Tipo_Combustivel = (String) modelo.getValueAt(tabela.getSelectedRow(), 7);
            float CargaMax = (float) modelo.getValueAt(tabela.getSelectedRow(), 8);
            float TanqueMax = (float) modelo.getValueAt(tabela.getSelectedRow(), 9);
            Veiculo veiculo = new Veiculo(TipoVeiculo, Refrigerado, Proprietario, Marca, Modelo, Placa, Tipo_Combustivel, CargaMax, TanqueMax);
            veiculo.setCodVeiculo(codVeiculo);
            this.dao.update(veiculo);
            JOptionPane.showMessageDialog(this, "Item alterado com sucesso!");
        } else {
            JOptionPane.showMessageDialog(this, "Por favor, selecionar o ID");
        }
    }

    private void sair() {
        switch (JOptionPane.showConfirmDialog(null, "Deseja Sair?", "Sair", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE)) {
            case 0:
                this.dispose();
                break;
        }

    }

    private void deletar() {
        Object objetoDaLinha = (Object) modelo.getValueAt(tabela.getSelectedRow(), tabela.getSelectedColumn());
        if (objetoDaLinha instanceof Integer) {
            Integer id = (Integer) objetoDaLinha;
            this.dao.delete(id);
            modelo.removeRow(tabela.getSelectedRow());
            JOptionPane.showMessageDialog(this, "Item excluído com sucesso!");
        } else {
            JOptionPane.showMessageDialog(this, "Por favor, selecionar o ID");
        }
    }

    public void limparTabela() {
        modelo.getDataVector().clear();
    }

    public void ChamarCadastro() throws SQLException {
        cadastro.MostrarTela(this);
    }

    public static void main(String[] args) {
        try {
            Home frame = new Home();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    {
// GUI initializer generated by IntelliJ IDEA GUI Designer
// >>> IMPORTANT!! <<<
// DO NOT EDIT OR ADD ANY CODE HERE!
        $$$setupUI$$$();
    }

    /**
     * Method generated by IntelliJ IDEA GUI Designer
     * >>> IMPORTANT!! <<<
     * DO NOT edit this method OR call it in your code!
     *
     * @noinspection ALL
     */
    private void $$$setupUI$$$() {
        MainPainel = new JPanel();
        MainPainel.setLayout(new com.intellij.uiDesigner.core.GridLayoutManager(7, 4, new Insets(10, 20, 20, 20), -1, -1));
        MainPainel.setBackground(new Color(-9593152));
        final JLabel label1 = new JLabel();
        Font label1Font = this.$$$getFont$$$(null, Font.BOLD, 36, label1.getFont());
        if (label1Font != null) label1.setFont(label1Font);
        label1.setForeground(new Color(-1));
        label1.setText("Tabela Veiculos");
        MainPainel.add(label1, new com.intellij.uiDesigner.core.GridConstraints(0, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        container = new JPanel();
        container.setLayout(new com.intellij.uiDesigner.core.GridLayoutManager(1, 1, new Insets(0, 0, 0, 0), -1, -1));
        MainPainel.add(container, new com.intellij.uiDesigner.core.GridConstraints(4, 0, 1, 4, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_BOTH, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        final JScrollPane scrollPane1 = new JScrollPane();
        scrollPane1.setBackground(new Color(-16777216));
        Font scrollPane1Font = this.$$$getFont$$$(null, -1, 14, scrollPane1.getFont());
        if (scrollPane1Font != null) scrollPane1.setFont(scrollPane1Font);
        scrollPane1.setForeground(new Color(-1));
        container.add(scrollPane1, new com.intellij.uiDesigner.core.GridConstraints(0, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_BOTH, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 0, false));
        tabela = new JTable();
        tabela.setAutoCreateColumnsFromModel(true);
        tabela.setBackground(new Color(-16777216));
        tabela.setCellSelectionEnabled(true);
        tabela.setColumnSelectionAllowed(true);
        Font tabelaFont = this.$$$getFont$$$(null, -1, 14, tabela.getFont());
        if (tabelaFont != null) tabela.setFont(tabelaFont);
        tabela.setForeground(new Color(-1));
        tabela.setGridColor(new Color(-16777216));
        scrollPane1.setViewportView(tabela);
        adicionar = new JButton();
        adicionar.setBackground(new Color(-16777216));
        Font adicionarFont = this.$$$getFont$$$("Arial Black", -1, 14, adicionar.getFont());
        if (adicionarFont != null) adicionar.setFont(adicionarFont);
        adicionar.setForeground(new Color(-1));
        adicionar.setText("Adicionar");
        MainPainel.add(adicionar, new com.intellij.uiDesigner.core.GridConstraints(2, 0, 1, 2, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        deletar = new JButton();
        deletar.setBackground(new Color(-16777216));
        Font deletarFont = this.$$$getFont$$$("Arial Black", -1, 14, deletar.getFont());
        if (deletarFont != null) deletar.setFont(deletarFont);
        deletar.setForeground(new Color(-1));
        deletar.setText("Remover");
        MainPainel.add(deletar, new com.intellij.uiDesigner.core.GridConstraints(2, 3, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        Sair = new JButton();
        Sair.setText("Sair");
        MainPainel.add(Sair, new com.intellij.uiDesigner.core.GridConstraints(6, 3, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final com.intellij.uiDesigner.core.Spacer spacer1 = new com.intellij.uiDesigner.core.Spacer();
        MainPainel.add(spacer1, new com.intellij.uiDesigner.core.GridConstraints(6, 1, 1, 2, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, 1, null, null, null, 0, false));
        final com.intellij.uiDesigner.core.Spacer spacer2 = new com.intellij.uiDesigner.core.Spacer();
        MainPainel.add(spacer2, new com.intellij.uiDesigner.core.GridConstraints(5, 3, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_VERTICAL, 1, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 0, false));
        final com.intellij.uiDesigner.core.Spacer spacer3 = new com.intellij.uiDesigner.core.Spacer();
        MainPainel.add(spacer3, new com.intellij.uiDesigner.core.GridConstraints(3, 1, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_VERTICAL, 1, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 0, false));
        alterar = new JButton();
        alterar.setBackground(new Color(-16777216));
        Font alterarFont = this.$$$getFont$$$("Arial Black", -1, 14, alterar.getFont());
        if (alterarFont != null) alterar.setFont(alterarFont);
        alterar.setForeground(new Color(-1));
        alterar.setText("Alterar");
        MainPainel.add(alterar, new com.intellij.uiDesigner.core.GridConstraints(2, 2, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final com.intellij.uiDesigner.core.Spacer spacer4 = new com.intellij.uiDesigner.core.Spacer();
        MainPainel.add(spacer4, new com.intellij.uiDesigner.core.GridConstraints(1, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_VERTICAL, 1, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 0, false));
    }

    /**
     * @noinspection ALL
     */
    private Font $$$getFont$$$(String fontName, int style, int size, Font currentFont) {
        if (currentFont == null) return null;
        String resultName;
        if (fontName == null) {
            resultName = currentFont.getName();
        } else {
            Font testFont = new Font(fontName, Font.PLAIN, 10);
            if (testFont.canDisplay('a') && testFont.canDisplay('1')) {
                resultName = fontName;
            } else {
                resultName = currentFont.getName();
            }
        }
        Font font = new Font(resultName, style >= 0 ? style : currentFont.getStyle(), size >= 0 ? size : currentFont.getSize());
        boolean isMac = System.getProperty("os.name", "").toLowerCase(Locale.ENGLISH).startsWith("mac");
        Font fontWithFallback = isMac ? new Font(font.getFamily(), font.getStyle(), font.getSize()) : new StyleContext().getFont(font.getFamily(), font.getStyle(), font.getSize());
        return fontWithFallback instanceof FontUIResource ? fontWithFallback : new FontUIResource(fontWithFallback);
    }

    /**
     * @noinspection ALL
     */
    public JComponent $$$getRootComponent$$$() {
        return MainPainel;
    }
}
