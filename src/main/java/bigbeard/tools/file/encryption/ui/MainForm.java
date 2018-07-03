package bigbeard.tools.file.encryption.ui;

import bigbeard.tools.file.encryption.entry.FileEntry;
import bigbeard.tools.file.encryption.service.EncryptionService;
import bigbeard.tools.file.encryption.ui.api.NotifyValueChanged;
import com.intellij.uiDesigner.core.GridConstraints;
import com.intellij.uiDesigner.core.GridLayoutManager;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.util.Arrays;
import java.util.List;


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

    private MyTableModel model;

    private NotifyValueChanged notifyValueChanged;

    public MainForm() {
        $$$setupUI$$$();
        init();
    }

    public void setNotifyValueChanged(NotifyValueChanged notifyValueChanged) {
        this.notifyValueChanged = notifyValueChanged;
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
                if (files.length > 0) {
                    EncryptionService.instance().clear();
                }
                Arrays.stream(files).forEach(file -> {
                    EncryptionService.instance().addFileEntry(file);
                });
                if ((fileTable.getModel() instanceof MyTableModel) == false) {
                    model = new MyTableModel();
                    model.setNotifyValueChanged(notifyValueChanged);
                    List<FileEntry> fileEntries = EncryptionService.instance().getAllFileEntry();
                    model.initData(fileEntries);
                    fileTable.setModel(model);
                    fileTable.getColumnModel().getColumn(0).setPreferredWidth(30);

                } else {
                    ((MyTableModel) fileTable.getModel()).initData(EncryptionService.instance().getAllFileEntry());
                    fileTable.updateUI();
                }
            }
        });
        encrypButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {

            }
        });
        fileTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        passwordText.setSize(50, 25);
        drpAlgorithm.setSize(150, 25);

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
        label1.setText("PWD:");
        panel1.add(label1);
        passwordText = new JTextField();
        passwordText.setColumns(20);
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
    public JComponent $$$getRootComponent$$$() {
        return rootPanel;
    }
}
