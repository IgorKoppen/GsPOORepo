package br.com.gs.view;

import br.com.gs.repository.UsuarioDAO;
import com.sun.tools.javac.Main;

import javax.swing.*;
import javax.swing.plaf.FontUIResource;
import javax.swing.text.StyleContext;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.Locale;

public class Login extends JFrame {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel MainPainel;
    private JButton BtnLogar;
    private JButton BtnCancelar;
    private JTextField textFieldUser;
    private JPasswordField passwordFieldSenha;
    private JButton buttonCadastro;
    private UsuarioDAO dao = new UsuarioDAO();
    private Image icon = new ImageIcon(this.getClass().getResource("/login.png")).getImage();

    public Login() throws SQLException {

        setContentPane(MainPainel);
        setTitle("Login");
        setSize(400, 500);
        setMinimumSize(new Dimension(600, 500));
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
        this.setIconImage(icon);

        BtnLogar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!textFieldUser.getText().equals("") && !String.valueOf(passwordFieldSenha.getPassword()).equals("")) {
                    String user = textFieldUser.getText();
                    String password = String.valueOf(passwordFieldSenha.getPassword()).trim();
                    boolean usuario = dao.findUser(user, password);
                    if (usuario) {
                        try {
                            Home frame = new Home();
                            dispose();
                        } catch (SQLException error) {
                            error.printStackTrace();
                        }

                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Usuario ou senha incorreta!");
                    limparCampos();
                }
            }
        });
        BtnCancelar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
        buttonCadastro.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                newCadastro();
            }
        });
    }

    private void limparCampos() {
        textFieldUser.setText("");
        passwordFieldSenha.setText("");
    }

    public static void main(String[] args) {
        try {
            Login login = new Login();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void newCadastro() {
        try {
            UsuariosCadastroFrame frame = new UsuariosCadastroFrame();
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
        MainPainel.setLayout(new com.intellij.uiDesigner.core.GridLayoutManager(5, 3, new Insets(50, 100, 50, 100), -1, -1));
        MainPainel.setBackground(new Color(-9593152));
        MainPainel.setName("Login");
        textFieldUser = new JTextField();
        MainPainel.add(textFieldUser, new com.intellij.uiDesigner.core.GridConstraints(1, 1, 1, 2, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        passwordFieldSenha = new JPasswordField();
        MainPainel.add(passwordFieldSenha, new com.intellij.uiDesigner.core.GridConstraints(2, 1, 1, 2, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        BtnCancelar = new JButton();
        BtnCancelar.setBackground(new Color(-16777216));
        Font BtnCancelarFont = this.$$$getFont$$$("Arial Black", -1, 14, BtnCancelar.getFont());
        if (BtnCancelarFont != null) BtnCancelar.setFont(BtnCancelarFont);
        BtnCancelar.setForeground(new Color(-1));
        BtnCancelar.setText("Sair");
        MainPainel.add(BtnCancelar, new com.intellij.uiDesigner.core.GridConstraints(4, 2, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        BtnLogar = new JButton();
        BtnLogar.setBackground(new Color(-16777216));
        Font BtnLogarFont = this.$$$getFont$$$("Arial Black", -1, 14, BtnLogar.getFont());
        if (BtnLogarFont != null) BtnLogar.setFont(BtnLogarFont);
        BtnLogar.setForeground(new Color(-1));
        BtnLogar.setText("Entrar");
        MainPainel.add(BtnLogar, new com.intellij.uiDesigner.core.GridConstraints(4, 1, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        buttonCadastro = new JButton();
        buttonCadastro.setActionCommand("não tem conta");
        buttonCadastro.setBackground(new Color(-9593152));
        buttonCadastro.setBorderPainted(false);
        Font buttonCadastroFont = this.$$$getFont$$$("Arial Black", -1, 14, buttonCadastro.getFont());
        if (buttonCadastroFont != null) buttonCadastro.setFont(buttonCadastroFont);
        buttonCadastro.setForeground(new Color(-1));
        buttonCadastro.setText("Não tem conta?");
        MainPainel.add(buttonCadastro, new com.intellij.uiDesigner.core.GridConstraints(3, 1, 1, 2, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JLabel label1 = new JLabel();
        Font label1Font = this.$$$getFont$$$("Arial Black", Font.BOLD, 22, label1.getFont());
        if (label1Font != null) label1.setFont(label1Font);
        label1.setForeground(new Color(-1));
        label1.setName("Login");
        label1.setText("Login");
        MainPainel.add(label1, new com.intellij.uiDesigner.core.GridConstraints(0, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JLabel label2 = new JLabel();
        Font label2Font = this.$$$getFont$$$("Arial Black", -1, 14, label2.getFont());
        if (label2Font != null) label2.setFont(label2Font);
        label2.setForeground(new Color(-1));
        label2.setText("Senha");
        MainPainel.add(label2, new com.intellij.uiDesigner.core.GridConstraints(2, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JLabel label3 = new JLabel();
        Font label3Font = this.$$$getFont$$$("Arial Black", -1, 14, label3.getFont());
        if (label3Font != null) label3.setFont(label3Font);
        label3.setForeground(new Color(-1));
        label3.setText("Nome");
        MainPainel.add(label3, new com.intellij.uiDesigner.core.GridConstraints(1, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
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
