package bigbeard.tools.file.encryption;

import bigbeard.tools.file.encryption.api.FileEncryAlgorithm;
import bigbeard.tools.file.encryption.service.EncryptionService;
import bigbeard.tools.file.encryption.ui.MainForm;

import javax.swing.*;
import java.util.Map;

public class EncryptionMain {
    public static void main(String[] args) {
        JFrame frame = new JFrame("File Encryption");
        frame.setSize(850, 500);
        MainForm mainForm = new MainForm();
        EncryptionService.instance().initAlgorithm();
        Map<String, FileEncryAlgorithm> algorithmInfos = EncryptionService.instance().getAlgorithmInfos();
        mainForm.clearAlgorightm();
        algorithmInfos.forEach((k, v) -> {
            mainForm.addArithmentic(k);
        });
        //ImageIcon icon = new ImageIcon(ClassLoader.getSystemResource("timg.jpeg"));  //xxx代表图片存放路径，2.png图片名称及格式
        //frame.setIconImage(icon.getImage());


        frame.setContentPane(mainForm.getRootPanel());
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
