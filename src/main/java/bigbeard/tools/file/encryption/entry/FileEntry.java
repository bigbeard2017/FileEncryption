package bigbeard.tools.file.encryption.entry;

import java.io.Serializable;

public class FileEntry implements Serializable {
    private boolean isSelected;
    private String filePath;
    private String fileName;
    private String fileSize;
    private String fileExtendName;
    private FileEncryInfo fileEncryInfo;

    public boolean isSelected() {
        return isSelected;
    }

    public void setSelected(boolean selected) {
        isSelected = selected;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getFileSize() {
        return fileSize;
    }

    public void setFileSize(String fileSize) {
        this.fileSize = fileSize;
    }

    public String getFileExtendName() {
        return fileExtendName;
    }

    public void setFileExtendName(String fileExtendName) {
        this.fileExtendName = fileExtendName;
    }

    public FileEncryInfo getFileEncryInfo() {
        return fileEncryInfo;
    }

    public void setFileEncryInfo(FileEncryInfo fileEncryInfo) {
        this.fileEncryInfo = fileEncryInfo;
    }
}
