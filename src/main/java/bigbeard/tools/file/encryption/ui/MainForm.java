package bigbeard.tools.file.encryption.ui;

import bigbeard.tools.file.encryption.service.EncryptionService;
import com.intellij.uiDesigner.core.GridConstraints;
import com.intellij.uiDesigner.core.GridLayoutManager;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.util.Arrays;

/**
 * Created by bigbeard on 2018/6/2.
 */
public class MainForm {
    private JButton openButton;
    private JButton encrypButton;
    private JButton decryptButton;
    private JButton reverseButton;
    private JTextField passwordText;
    private JCheckBox cbEncryption;
    private JCheckBox cbNoEncryption;
    private JComboBox drpAlgorithm;
    private JTable fileTable;
    private JPanel rootPanel;


    public MainForm() {
        init();
    }

    /**
     * 添加下拉算法显示
     *
     * @param arichmenticName 算法名称
     */
    public void addArithmentic(String arichmenticName) {
        drpAlgorithm.addItem(arichmenticName);
    }

    public JPanel getRootPanel() {
        return rootPanel;
    }

    /**
     * 移除算法
     *
     * @param arichmenticName 需要移除的算法名称
     */
    public void removeArithmentic(String arichmenticName) {
        drpAlgorithm.removeItem(arichmenticName);
    }

    public void clearAlgorightm() {
        drpAlgorithm.removeAll();
    }

    {
// GUI initializer generated by IntelliJ IDEA GUI Designer
// >>> IMPORTANT!! <<<
// DO NOT EDIT OR ADD ANY CODE HERE!
        $$$setupUI$$$();
    }

    private void init() {

        openButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                FileDialog fileDialog = new FileDialog(new JFrame());
                fileDialog.setMode(FileDialog.LOAD);
//                fileDialog.setFilenameFilter((dir, name) -> {
//                    return name.endsWith(".jpg") || name.endsWith(".png") || name.endsWith(".bmp");
//                });
                fileDialog.setMultipleMode(true);
                fileDialog.setVisible(true);
                File[] files = fileDialog.getFiles();
                Arrays.stream(files).forEach(file -> EncryptionService.instance().addFileEntry(file));
            }
        });
        encrypButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {

            }
        });

        passwordText.setSize(30, 150);


        final Object[] objectsClum = new Object[]{"选择", "是否加密", "文件大小", "加密算法", "文件名称"};
        String[][] data = new String[][]{
                {"A0", "B0", "c0", "100_0"},
                {"A1", "B1", "c1", "100_1"},
                {"A0", "B0", "c0", "100_0"},

        };
        fileTable.setGridColor(new Color(192, 192, 192));

        DefaultTableModel defaultTableModel = new DefaultTableModel();
        TableColumn tableColumn = new TableColumn();
        tableColumn.setHeaderValue("A");
        tableColumn.setWidth(25);
        defaultTableModel.addColumn(tableColumn);

        TableColumn tableColumnB = new TableColumn();
        tableColumnB.setHeaderValue("B");
        tableColumnB.setWidth(25);
        defaultTableModel.addColumn(tableColumnB);

        TableColumn tableColumnC = new TableColumn();
        tableColumnC.setHeaderValue("C");
        tableColumnC.setWidth(25);
        defaultTableModel.addColumn(tableColumnC);

        TableColumn tableColumnD = new TableColumn();
        tableColumnD.setHeaderValue("D");
        tableColumnD.setResizable(true);

        tableColumnD.setWidth(25);
        defaultTableModel.addColumn(tableColumnD);

        // defaultTableModel.setRowCount(data.length);
        fileTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
//        defaultTableModel.getDataVector().add("sdaf");
        fileTable.setModel(defaultTableModel);

    }

    /**
     * Method generated by IntelliJ IDEA GUI Designer
     * >>> IMPORTANT!! <<<
     * DO NOT edit this method OR call it in your code!
     *
     * @noinspection ALL
     */
    private void $$$setupUI$$$() {
        rootPanel = new JPanel();
        rootPanel.setLayout(new GridLayoutManager(2, 2, new Insets(0, 0, 0, 0), -1, -1));
        final JPanel panel1 = new JPanel();
        panel1.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));
        rootPanel.add(panel1, new GridConstraints(0, 0, 1, 2, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        openButton = new JButton();
        openButton.setText("Open");
        openButton.setMnemonic('O');
        openButton.setDisplayedMnemonicIndex(0);
        openButton.setToolTipText("打开");
        panel1.add(openButton);
        encrypButton = new JButton();
        encrypButton.setText("Encryp");
        encrypButton.setMnemonic('E');
        encrypButton.setDisplayedMnemonicIndex(0);
        encrypButton.setToolTipText("加密");
        panel1.add(encrypButton);
        decryptButton = new JButton();
        decryptButton.setText("Decrypt");
        decryptButton.setMnemonic('D');
        decryptButton.setDisplayedMnemonicIndex(0);
        decryptButton.setToolTipText("解密");
        panel1.add(decryptButton);
        reverseButton = new JButton();
        reverseButton.setText("Reverse");
        reverseButton.setMnemonic('R');
        reverseButton.setDisplayedMnemonicIndex(0);
        reverseButton.setToolTipText("反选");
        panel1.add(reverseButton);
        final JLabel label1 = new JLabel();
        label1.setText("Password:");
        panel1.add(label1);
        passwordText = new JTextField();
        passwordText.setColumns(20);
        Font passwordTextFont = this.$$$getFont$$$(null, -1, 14, passwordText.getFont());
        if (passwordTextFont != null) passwordText.setFont(passwordTextFont);
        passwordText.setToolTipText("输入密码");
        panel1.add(passwordText);
        cbEncryption = new JCheckBox();
        cbEncryption.setText("已加密");
        cbEncryption.setToolTipText("选择已经加密");
        panel1.add(cbEncryption);
        cbNoEncryption = new JCheckBox();
        cbNoEncryption.setText("未加密");
        cbNoEncryption.setToolTipText("选择未加密");
        panel1.add(cbNoEncryption);
        final JLabel label2 = new JLabel();
        label2.setText("算法：");
        panel1.add(label2);
        drpAlgorithm = new JComboBox();
        final DefaultComboBoxModel defaultComboBoxModel1 = new DefaultComboBoxModel();
        drpAlgorithm.setModel(defaultComboBoxModel1);
        drpAlgorithm.setToolTipText("加密算法");
        panel1.add(drpAlgorithm);
        final JPanel panel2 = new JPanel();
        panel2.setLayout(new GridLayoutManager(1, 1, new Insets(0, 5, 5, 5), -1, -1));
        rootPanel.add(panel2, new GridConstraints(1, 0, 1, 2, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 0, false));
        final JScrollPane scrollPane1 = new JScrollPane();
        panel2.add(scrollPane1, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 0, false));
        fileTable = new JTable();
        fileTable.setAutoResizeMode(0);
        scrollPane1.setViewportView(fileTable);
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
        return new Font(resultName, style >= 0 ? style : currentFont.getStyle(), size >= 0 ? size : currentFont.getSize());
    }

    /**
     * @noinspection ALL
     */
    public JComponent $$$getRootComponent$$$() {
        return rootPanel;
    }
}
