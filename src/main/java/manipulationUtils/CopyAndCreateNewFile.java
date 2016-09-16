package manipulationUtils;

import java.io.*;
import java.util.*;

/**
 * Created by Nimrod Golan on 05/09/2016.
 */
public class CopyAndCreateNewFile {

    public List<String> readLinesFromFile(String path) {

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(path))) {
            List<String> list = new ArrayList<>();
            Map<String, Integer> map = new HashMap<>();
            String currentLine;

            while ((currentLine = bufferedReader.readLine()) != null) {
                list.add(currentLine);
            }
            return list;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new ArrayList<>();
    }

    public void writeDetailsToFile(String path, Map<String, Integer> map) {
        try {
            File fileToexport = new File(path);
            FileWriter fileWriter = new FileWriter(fileToexport.getAbsoluteFile());
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

            for (Map.Entry<String, Integer> entry : map.entrySet()) {
                bufferedWriter.write(entry.getKey() + " - " + entry.getValue());
                bufferedWriter.newLine();
            }
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static void main(String[] args) {
        CopyAndCreateNewFile copyAndCreateNewFile = new CopyAndCreateNewFile();
        List<String> list = copyAndCreateNewFile.readLinesFromFile("C:\\Users\\Inbar Ardity\\Desktop\\text1.txt");
        Map<String, Integer> map = new HashMap<>();

        for (String line : list) {
            String[] split = line.split(", ");

            for (String currentTerm : split) {
                if (!map.containsKey(currentTerm)) {
                    map.put(currentTerm, 1);
                } else {
                    map.put(currentTerm, map.get(currentTerm) + 1);
                }
            }
        }

        copyAndCreateNewFile.writeDetailsToFile("C:\\Users\\Inbar Ardity\\Desktop\\text2.txt", map);

    }
}
