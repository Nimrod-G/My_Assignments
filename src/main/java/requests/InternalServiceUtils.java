package requests;

import logs.AutomationLogger;
import exceptionsInfra.SystemException;

import java.io.IOException;
import java.io.InputStream;
import java.math.BigInteger;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.DigestInputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

public class InternalServiceUtils {

    /**
     *
     * @param filePath    The file path
     * @return  The file MD5 or null if the file path doesn't exists
     * @throws IOException
     */
    public static Optional<String> getFileMd5(String filePath) throws IOException {
        AutomationLogger.getLog().info("Trying getting MD5 hash from file: " + filePath);
        MessageDigest md;

        try {
            md = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException  e) {
            throw new SystemException("The algorithm doesn't exists - possibly a bug ", e);
        }

        InputStream inputStream;
        try {
            inputStream = Files.newInputStream(Paths.get(filePath));
        } catch (NoSuchFileException e) {
            AutomationLogger.getLog().error("No such file path: " + filePath, e);
            return Optional.empty();
        }

        DigestInputStream dis = new DigestInputStream(inputStream, md);
        byte[] buffer = new byte[8 * 1024];

        while (dis.read(buffer) != -1);
        dis.close();
        inputStream.close();

        byte[] output = md.digest();
        BigInteger bi = new BigInteger(1, output);
        String hashText = bi.toString(16);
        return Optional.of(hashText);
    }

    /**
     *
     * @param directoryPath    The directory full path
     * @param isByFullPath     True to get the files by their full path / false - to get the files by name
     * @return  A List of the directory's files or an empty list if no files exists
     * @throws IOException
     */
    public static List<String> getDirectoryFiles(String directoryPath, boolean isByFullPath) throws IOException {
        AutomationLogger.getLog().info("Trying getting all files in a directory: " + directoryPath);
        List<String> filesInDirectory = new ArrayList<>();

        try {
            try (Stream<Path> filePathStream = Files.walk(Paths.get(directoryPath))) {
                filePathStream.forEach(filePath -> {
                    if (Files.isRegularFile(filePath)) {
                        if (isByFullPath) {
                            filesInDirectory.add(filePath.toString());
                        } else {
                            filesInDirectory.add(filePath.getFileName().toString());
                        }
                    }
                });
            }
        } catch (NoSuchFileException e) {
            AutomationLogger.getLog().error("No such directory path: " + directoryPath);
            return new ArrayList<>();
        }

        AutomationLogger.getLog().info("Found " + filesInDirectory.size() + " file(s)");
        return filesInDirectory;
    }

    /**
     *
     * @param md5FileHash      The MD5 hash
     * @param directoryPath    The directory path
     * @return  True - if the md5 god found or False if the md5 didn't found
     * @throws IOException
     */
    public static Boolean isMd5FileHashExistsInDirectory(String md5FileHash, String directoryPath) throws IOException {
        List<String> directoryFiles = getDirectoryFiles(directoryPath, true);

        for (String filePath : directoryFiles) {
            String currentMd5Hash = getFileMd5(filePath).orElse("");

            if (md5FileHash.equals(currentMd5Hash)) {
                AutomationLogger.getLog().info("File hash: " + md5FileHash + " has been found related with file path: " + filePath);
                return true;
            }
        }
        return false;
    }

    /**
     *
     * @param directoryPath    The directory path
     * @param fileName         The file name
     * @return  True if the file name do exists or False otherwise
     * @throws IOException
     */
    public static Boolean isFileExistsInADirectory(String directoryPath, String fileName) throws IOException {
        List<String> directoryFiles = getDirectoryFiles(directoryPath, false);

        for (String file : directoryFiles) {
            if (file.equalsIgnoreCase(fileName)) {
                return true;
            }
        }
        return false;
    }
}
