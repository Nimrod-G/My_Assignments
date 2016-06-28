package printUtils;

import java.io.File;

public class PrintAllFilesInDirectory {

    public void printAllFilesInDirectory(String path) {
        File root = new File(path);
        File[] list = root.listFiles();

        if (list == null) return;

        for (File f : list) {
            if (f.isDirectory()) {
                printAllFilesInDirectory(f.getAbsolutePath());
                System.out.println("Dir:" + f.getAbsoluteFile());
            } else {
                System.out.println("File:" + f.getAbsoluteFile());
            }
        }
    }
}
