package bigbeard.tools.file.encryption.ui;

import bigbeard.tools.file.encryption.entry.FileEntry;
import bigbeard.tools.file.encryption.ui.api.NotifyValueChanged;

import javax.swing.table.AbstractTableModel;
import java.util.List;

/**
 * Created by bigbeard on 2018/6/2.
 */
public class MyTableModel extends AbstractTableModel {

    private String headerTitle[] = {"选择", "是否加密", "文件大小", "加密算法", "文件名称", "文件类型", "文件路径"};

    private Class[] cellType = {Boolean.class, Boolean.class, int.class, String.class, String.class, String.class, String.class};

    private Object[][] data = null;
    private NotifyValueChanged notifyValueChanged;

    public void setNotifyValueChanged(NotifyValueChanged notifyValueChanged) {
        this.notifyValueChanged = notifyValueChanged;
    }


    public void initData(List<FileEntry> dataList) {
        data = new Object[dataList.size()][7];
        for (int i = 0; i < dataList.size(); i++) {
            FileEntry uiFileEntry = dataList.get(i);
            data[i][0] = uiFileEntry.isSelected();
            if (null != uiFileEntry.getFileEncryInfo()) {
                data[i][1] = uiFileEntry.getFileEncryInfo().isEncryption();
                data[i][3] = uiFileEntry.getFileEncryInfo().getAlgorithmName();
            }
            data[i][2] = uiFileEntry.getFileSize();
            data[i][4] = uiFileEntry.getFileName();
            data[i][5] = uiFileEntry.getFileExtendName();
            data[i][6] = uiFileEntry.getFilePath();
        }
    }

    @Override
    public Class<?> getColumnClass(int arg0) {
        return cellType[arg0];
    }

    @Override
    public String getColumnName(int arg0) {
        return headerTitle[arg0];
    }

    @Override
    public int getColumnCount() {
        return headerTitle.length;
    }

    @Override
    public int getRowCount() {
        return data.length;
    }

    @Override
    public Object getValueAt(int r, int c) {
        return data[r][c];
    }

    //重写isCellEditable方法
    public boolean isCellEditable(int r, int c) {
        return c == 0;
    }

    //重写setValueAt方法
    public void setValueAt(Object value, int r, int c) {
        data[r][c] = value;
        this.fireTableCellUpdated(r, c);
    }

    //重写单元格编辑后的方法
    public void fireTableCellUpdated(int row, int column) {
        super.fireTableCellUpdated(row, column);
        if (column == 0) {
            Object o = data[row][column];
            if (null != notifyValueChanged) {
                notifyValueChanged.notifyChange(data[row]);
            }
        }
    }
}
