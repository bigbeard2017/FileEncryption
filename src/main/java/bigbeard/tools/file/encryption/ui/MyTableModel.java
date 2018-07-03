package bigbeard.tools.file.encryption.ui;

import bigbeard.tools.file.encryption.entry.FileEntry;
import bigbeard.tools.file.encryption.ui.api.NotifyValueChanged;

import javax.swing.table.AbstractTableModel;
import java.util.List;

/**
 * Created by bigbeard on 2018/6/2.
 */
public class MyTableModel extends AbstractTableModel {

    private static final int COLUMN_COUNT = 7;

    private String headerTitle[] = {"选择", "是否加密", "文件大小", "加密算法", "文件名称", "文件类型", "文件路径"};

    private Class[] cellType = {Boolean.class, Boolean.class, int.class, String.class, String.class, String.class, String.class};

    private Object[][] data = null;
    private NotifyValueChanged notifyValueChanged;

    public void setNotifyValueChanged(NotifyValueChanged notifyValueChanged) {
        this.notifyValueChanged = notifyValueChanged;
    }


    public void initData(List<FileEntry> dataList) {
        data = new Object[dataList.size()][COLUMN_COUNT];
        for (int i = 0; i < dataList.size(); i++) {
            FileEntry uiFileEntry = dataList.get(i);
            insertData(data, i, uiFileEntry);
        }
    }

    private void insertData(Object[][] d, int i, FileEntry uiFileEntry) {
        d[i][0] = uiFileEntry.isSelected();
        if (null != uiFileEntry.getFileEncryInfo()) {
            d[i][1] = uiFileEntry.getFileEncryInfo().isEncryption();
            d[i][3] = uiFileEntry.getFileEncryInfo().getAlgorithmName();
        }
        d[i][2] = uiFileEntry.getFileSize();
        d[i][4] = uiFileEntry.getFileName();
        d[i][5] = uiFileEntry.getFileExtendName();
        d[i][6] = uiFileEntry.getFilePath();
    }

//    /**
//     * 将信息追加到末尾
//     * <p/>
//     * 此方法会重建数组，涉及到数组元素的拷贝，比较耗性能
//     *
//     * @param dataList
//     */
//    public void addData(List<FileEntry> dataList) {
//        if (null == dataList || dataList.size() == 0) {
//            return;
//        }
//        Object[][] newData = null;
//        if (null != data) {
//            newData = new Object[dataList.size() + data.length][COLUMN_COUNT];
//        } else {
//            initData(dataList);
//            return;
//        }
//        int start = 0;
//        for (start = 0; start < data.length; start++) {
//            for (int j = 0; j < COLUMN_COUNT; j++) {
//                newData[start][j] = data[start][j];
//            }
//        }
//        int s=0;
//        for (; s < dataList.size(); s++) {
//            FileEntry fileEntry = dataList.get(s);
//            insertData(newData,s+start,fileEntry);
//        }
//        data=newData;
//    }

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
