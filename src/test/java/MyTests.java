import org.junit.Assert;
import org.junit.Test;
import requests.InternalServiceUtils;
import requests.UrlServiceUtils;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.List;

public class MyTests {

    public final static String DIRECTORY = "C:\\Users\\Inbar Ardity\\Desktop\\myTemp";
    public final static String JAR_FILE_NAME = "log4j-core-2.6.jar";

    @Test
    public void testJar() throws IOException, NoSuchAlgorithmException {
        UrlServiceUtils.saveFileFromUrlIfNotExistsInDirectory("http://central.maven.org/maven2/org/apache/logging/log4j/log4j-core/2.6/log4j-core-2.6.jar", DIRECTORY);
        InternalServiceUtils.getDirectoryFiles(DIRECTORY, false);

        Assert.assertTrue("Jar file: " + JAR_FILE_NAME + " doesn't exists", InternalServiceUtils.isFileExistsInADirectory(DIRECTORY, JAR_FILE_NAME));
    }

}
