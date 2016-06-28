package countUtils;

import exceptionsInfra.SystemException;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class CountCharFromTextFile {

    public int countCharFromTextFile(String path, char charToFind) {

        FileInputStream fileInputStream = null;
        InputStreamReader inputStreamReader = null;

        int input;
        char letter;
        int sum = 0;

        try {
            fileInputStream = new FileInputStream(path);
            inputStreamReader = new InputStreamReader(fileInputStream);

            while ((input = inputStreamReader.read()) != -1) {
                letter = (char) input;
                if (Character.toLowerCase(letter) == Character.toLowerCase(charToFind)) {
                    sum ++;
                }
            }

            return sum;

        } catch (IOException e) {
            throw new SystemException("File not exists", e);
        }
    }
}
