package bigbeard.tools.file.encryption.ui;

import bigbeard.tools.file.encryption.entry.FileEntry;

/**
 * Created by bigbeard on 2018/6/20.
 */
public class UIFileEntry extends FileEntry {
    private boolean isSelected;

    public boolean isSelected() {
        return isSelected;
    }

    public void setSelected(boolean selected) {
        isSelected = selected;
    }
}
