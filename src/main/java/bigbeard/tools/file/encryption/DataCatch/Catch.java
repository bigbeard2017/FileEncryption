package bigbeard.tools.file.encryption.DataCatch;

import bigbeard.tools.file.encryption.entry.FileEntry;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

;

public class Catch implements Serializable {
    private List<FileEntry> fileEntries = new ArrayList<>();

    private Catch() {
    }

    public static Catch instance() {
        return Singleton.INSTANCE.getInstance();
    }

    public void AddFileEntry(FileEntry fileEntry) {
        Optional<FileEntry> fileEntry1 = fileEntries.parallelStream().findFirst().filter(x ->
                x.getFilePath() != null
                        && x.getFilePath().equals(fileEntry.getFilePath())
        );
        //System.out.println(fileEntry1.isPresent());
        if (!fileEntry1.isPresent()) {
            fileEntries.add(fileEntry);
        }
    }

    public List<FileEntry> getFileEntries() {
        return fileEntries;
    }

    public void clear() {
        fileEntries.clear();
    }
    public int getFileEntriesSize() {
        return fileEntries.size();
    }

    private enum Singleton {
        INSTANCE;
        private Catch singleton;

        Singleton() {
            singleton = new Catch();
        }

        public Catch getInstance() {
            return singleton;
        }
    }


}
