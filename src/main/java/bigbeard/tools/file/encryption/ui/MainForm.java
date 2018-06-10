package bigbeard.tools.file.encryption.ui;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableModel;
import java.awt.*;

/**
 * Created by bigbeard on 2018/6/2.
 */
public class MainForm {
    private JButton openButton;
    private JButton encrypButton;
    private JButton decryptButton;
    private JButton reverseButton;
    private JTextField passwordText;
    private JCheckBox encryptedCheckBox;
    private JCheckBox unencryptedCheckBox;
    private JComboBox passwordComboBox;
    private JTable fileTable;
    private JPanel rootPanel;


    public MainForm() {
        init();
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("File Encryption");
        frame.setContentPane(new MainForm().getRootPanel());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public JPanel getRootPanel() {
        return rootPanel;
    }

    private void init() {
        final Object[] objectsClum = new Object[]{"选择", "是否加密", "文件名称", "文件大小"};
        String[][] data = new String[][]{
                {"A0", "B0", "c0", "100_0"},
                {"A1", "B1", "c1", "100_1"},
                {"A0", "B0", "c0", "100_0"},
                {"A1", "B1", "c1", "100_1"},
                {"A0", "B0", "c0", "100_0"},
                {"A1", "B1", "c1", "100_1"},
                {"A0", "B0", "c0", "100_0"},
                {"A1", "B1", "c1", "100_1"},
                {"A0", "B0", "c0", "100_0"},
                {"A1", "B1", "c1", "100_1"},
                {"A0", "B0", "c0", "100_0"},
                {"A1", "B1", "c1", "100_1"},
                {"A0", "B0", "c0", "100_0"},
                {"A1", "B1", "c1", "100_1"},
                {"A0", "B0", "c0", "100_0"},
                {"A1", "B1", "c1", "100_1"},
                {"A0", "B0", "c0", "100_0"},
                {"A1", "B1", "c1", "100_1"},
                {"A0", "B0", "c0", "100_0"},
                {"A1", "B1", "c1", "100_1"},
                {"A0", "B0", "c0", "100_0"},
                {"A1", "B1", "c1", "100_1"},
                {"A0", "B0", "c0", "100_0"},
                {"A1", "B1", "c1", "100_1"},
                {"A0", "B0", "c0", "100_0"},
                {"A1", "B1", "c1", "100_1"},
                {"A0", "B0", "c0", "100_0"},
                {"A1", "B1", "c1", "100_1"},
                {"A0", "B0", "c0", "100_0"},
                {"A1", "B1", "c1", "100_1"},
                {"A0", "B0", "c0", "100_0"},
                {"A1", "B1", "c1", "100_1"},
                {"A0", "B0", "c0", "100_0"},
                {"A1", "B1", "c1", "100_1"},
                {"A0", "B0", "c0", "100_0"},
                {"A1", "B1", "c1", "100_1"},
                {"A0", "B0", "c0", "100_0"},
                {"A1", "B1", "c1", "100_1"},
                {"A0", "B0", "c0", "100_0"},
                {"A1", "B1", "c1", "100_1"},
                {"A0", "B0", "c0", "100_0"},
                {"A1", "B1", "c1", "100_1"},
                {"A0", "B0", "c0", "100_0"},
                {"A1", "B1", "c1", "100_1"},
                {"A0", "B0", "c0", "100_0"},
                {"A1", "B1", "c1", "100_1"},
                {"A0", "B0", "c0", "100_0"},
                {"A1", "B1", "c1", "100_1"},
                {"A0", "B0", "c0", "100_0"},
                {"A1", "B1", "c1", "100_1"},
                {"A0", "B0", "c0", "100_0"},
                {"A1", "B1", "c1", "100_1"},
                {"A0", "B0", "c0", "100_0"},
                {"A1", "B1", "c1", "100_1"},
                {"A0", "B0", "c0", "100_0"},
                {"A1", "B1", "c1", "100_1"},
                {"A0", "B0", "c0", "100_0"},
                {"A1", "B1", "c1", "100_1"},
                {"A0", "B0", "c0", "100_0"},
                {"A1", "B1", "c1", "100_1"},
                {"A0", "B0", "c0", "100_0"},
                {"A1", "B1", "c1", "100_1"},
                {"A0", "B0", "c0", "100_0"},
                {"A1", "B1", "c1", "100_1"},
                {"A0", "B0", "c0", "100_0"},
                {"A1", "B1", "c1", "100_1"},
                {"A0", "B0", "c0", "100_0"},
                {"A1", "B1", "c1", "100_1"},
                {"A0", "B0", "c0", "100_0"},
                {"A1", "B1", "c1", "100_1"},
                {"A0", "B0", "c0", "100_0"},
                {"A1", "B1", "c1", "100_1"},
                {"A0", "B0", "c0", "100_0"},
                {"A1", "B1", "c1", "100_1"},
                {"A0", "B0", "c0", "100_0"},
                {"A1", "B1", "c1", "100_1"},
                {"A0", "B0", "c0", "100_0"},
                {"A1", "B1", "c1", "100_1"},
                {"A0", "B0", "c0", "100_0"},
                {"A1", "B1", "c1", "100_1"},
                {"A0", "B0", "c0", "100_0"},
                {"A1", "B1", "c1", "100_1"},
                {"A0", "B0", "c0", "100_0"},
                {"A1", "B1", "c1", "100_1"},
                {"A0", "B0", "c0", "100_0"},
                {"A1", "B1", "c1", "100_1"},
                {"A0", "B0", "c0", "100_0"},
                {"A1", "B1", "c1", "100_1"},
                {"A0", "B0", "c0", "100_0"},
                {"A1", "B1", "c1", "100_1"},
                {"A0", "B0", "c0", "100_0"},
                {"A1", "B1", "c1", "100_1"},
                {"A0", "B0", "c0", "100_0"},
                {"A1", "B1", "c1", "100_1"},
                {"A0", "B0", "c0", "100_0"},
                {"A1", "B1", "c1", "100_1"},
                {"A0", "B0", "c0", "100_0"},
                {"A1", "B1", "c1", "100_1"},
                {"A0", "B0", "c0", "100_0"},
                {"A1", "B1", "c1", "100_1"},
                {"A0", "B0", "c0", "100_0"},
                {"A1", "B1", "c1", "100_1"},
                {"A0", "B0", "c0", "100_0"},
                {"A1", "B1", "c1", "100_1"},
                {"A0", "B0", "c0", "100_0"},
                {"A1", "B1", "c1", "100_1"},
                {"A0", "B0", "c0", "100_0"},
                {"A1", "B1", "c1", "100_1"},
                {"A0", "B0", "c0", "100_0"},
                {"A1", "B1", "c1", "100_1"},
                {"A0", "B0", "c0", "100_0"},
                {"A1", "B1", "c1", "100_1"},
        };
        fileTable.setGridColor(new Color(192,192,192));

        TableColumn tableColumn = new TableColumn();
        tableColumn.setHeaderValue("A");
        tableColumn.setWidth(25);
        fileTable.addColumn(tableColumn);

        TableColumn tableColumnB = new TableColumn();
        tableColumnB.setHeaderValue("B");
        tableColumnB.setWidth(25);
        fileTable.addColumn(tableColumnB);

        TableColumn tableColumnC = new TableColumn();
        tableColumnC.setHeaderValue("C");
        tableColumnC.setWidth(25);
        fileTable.addColumn(tableColumnC);
        TableColumn tableColumnD = new TableColumn();
        tableColumnD.setHeaderValue("D");
        tableColumnD.setWidth(25);
        fileTable.addColumn(tableColumnD);



        TableModel dataModel = new DefaultTableModel(data, objectsClum);
        fileTable.setModel(dataModel);

    }
}
