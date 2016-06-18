package requests;

import exceptionsInfra.SystemException;
import logs.AutomationLogger;
import org.apache.commons.io.FilenameUtils;

import java.io.*;
import java.net.URL;
import java.security.DigestInputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Optional;

public class UrlServiceUtils {

    /**
     * <p> Get file's MD5 hash code from URL address <p/>
     * @param urlInput    The JAR file url address
     * @return  The file MD5 or null if the file doesn't exists
     * @throws IOException
     */
    public static Optional<String> getMd5FromUrlFile(String urlInput) throws IOException {
        AutomationLogger.getLog().info("Trying to get url input md5 hash: " + urlInput);
        MessageDigest md;

        try {
            md = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException e) {
            throw new SystemException("The algorithm doesn't exists - possibly a bug ", e);
        }
        InputStream is;
        try {
            is = new URL(urlInput).openStream();
        } catch (FileNotFoundException e) {
            AutomationLogger.getLog().error("The file you are looking for: " + urlInput + " doesn't exists", e);
            return Optional.empty();
        }

        try {
            is = new DigestInputStream(is, md);

            byte[] ignoredBuffer = new byte[8 * 1024];
            while (is.read(ignoredBuffer) > 0) {
            }

        } finally {
            is.close();
        }
        byte[] digest = md.digest();
        StringBuffer sb = new StringBuffer();

        for (int i = 0; i < digest.length; i++) {
            sb.append(
                    Integer.toString((digest[i] & 0xff) + 0x100, 16).substring(
                            1));
        }
        return Optional.of(sb.toString());
    }

    /**
     * <p> The method gets a URL file and saves it on the directory-path if the file doesn't exists <p/>
     * @param urlInput         The JAR file url address
     * @param directoryPath    The directory in which we want to search the file existance
     * @throws IOException
     */
    public static void saveFileFromUrlIfNotExistsInDirectory(String urlInput, String directoryPath) throws IOException {
        AutomationLogger.getLog().info("Trying to get url input md5 hash: " + urlInput);
        MessageDigest md;

        try {
            md = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException e) {
            throw new SystemException("The algorithm doesn't exists - possibly a bug ", e);
        }

        InputStream is;
        try {
            is = new URL(urlInput).openStream();
        } catch (FileNotFoundException e) {
            AutomationLogger.getLog().error("The file you are looking for: " + urlInput + " doesn't exists", e);
            return;
        }
        try {
            is = new DigestInputStream(is, md);

            byte[] ignoredBuffer = new byte[8 * 1024];
            while (is.read(ignoredBuffer) > 0) {}

        } finally {
            is.close();
        }

        byte[] digest = md.digest();
        StringBuffer sb = new StringBuffer();

        for (int i = 0; i < digest.length; i++) {
            sb.append(
                    Integer.toString((digest[i] & 0xff) + 0x100, 16).substring(
                            1));
        }

        // If the file md5 is not exists in the directory path - save it
        if (!InternalServiceUtils.isMd5FileHashExistsInDirectory(sb.toString(), directoryPath)) {
            AutomationLogger.getLog().info("file name: " + FilenameUtils.getName(urlInput) + " doesn't exists in directory path. saving it in directory");
            is = new URL(urlInput).openStream();
            String fileName = FilenameUtils.getName(urlInput);
            OutputStream os = new FileOutputStream(directoryPath + "\\" + fileName);

            byte[] b = new byte[2048];
            int length;

            while ((length = is.read(b)) != -1) {
                os.write(b, 0, length);
            }
            is.close();
            os.close();
        } else {
            AutomationLogger.getLog().info("File is already exists in path directory");
            return;
        }
    }
}
