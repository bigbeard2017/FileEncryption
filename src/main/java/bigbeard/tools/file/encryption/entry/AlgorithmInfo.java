package bigbeard.tools.file.encryption.entry;

import java.io.Serializable;

public class AlgorithmInfo implements Serializable {

    private String arithmenticName;
    private String className;

    public AlgorithmInfo() {
    }

    public AlgorithmInfo(String name, String className) {
        this.arithmenticName = name;
        this.className = className;
    }

    public String getArithmenticName() {
        return arithmenticName;
    }

    public void setArithmenticName(String arithmenticName) {
        this.arithmenticName = arithmenticName;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }
}
