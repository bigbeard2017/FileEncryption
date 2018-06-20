package bigbeard.tools.file.encryption.ui;

import javax.swing.table.AbstractTableModel;
import java.util.List;

/**
 * Created by bigbeard on 2018/6/2.
 */
public class MyTableModel extends AbstractTableModel {

    private String headerTitle[] = {"选择", "是否加密", "文件大小", "加密算法", "文件名称", "文件类型", "文件路径"};

    private Class[] cellType = {Boolean.class, Boolean.class, int.class, String.class, String.class, String.class, String.class};

    private Object[][] data = null;


    public void initData(List<UIFileEntry> dataList) {
        data = new Object[dataList.size()][7];
        for (int i = 0; i < dataList.size(); i++) {
            UIFileEntry uiFileEntry = dataList.get(i);
            data[i][0] = new Boolean(uiFileEntry.isSelected());
            data[i][1] = new Boolean(uiFileEntry.getFileEncryInfo().isEncryption());
            data[i][2] = uiFileEntry.getFileSize();
            data[i][3] = uiFileEntry.getFileEncryInfo().getAlgorithmName();
            data[i][4] = uiFileEntry.getFileName();
            data[i][5] = uiFileEntry.getFileExtendName();
            data[i][6] = uiFileEntry.getFilePath();
        }
    }

    @Override
    public Class<?> getColumnClass(int arg0) {
        // TODO Auto-generated method stub
        return cellType[arg0];
    }
    @Override
    public String getColumnName(int arg0) {
        // TODO Auto-generated method stub
        return headerTitle[arg0];
    }
    @Override
    public int getColumnCount() {
        // TODO Auto-generated method stub
        return headerTitle.length;
    }

    @Override
    public int getRowCount() {
        // TODO Auto-generated method stub
        return data.length;
    }
    @Override
    public Object getValueAt(int r, int c) {
        // TODO Auto-generated method stub
        return data[r][c];
    }

    //重写isCellEditable方法
    public boolean isCellEditable(int r, int c) {
        return true;
    }

    //重写setValueAt方法
    public void setValueAt(Object value, int r, int c) {
        data[r][c] = value;
        this.fireTableCellUpdated(r, c);
    }
}
