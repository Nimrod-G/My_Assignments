package myTests;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;
import requests.InternalServiceUtils;
import requests.UrlServiceUtils;

import java.io.File;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.List;

public class SaveJarFileFromUrlTest {

    public final String JAR_URL_PATH = "http://central.maven.org/maven2/org/apache/logging/log4j/log4j-core/2.6/log4j-core-2.6.jar";
    public final String FOLDER_NAME = "tempFilesFolder";

    String jarFileName = "log4j-core-2.6.jar";

    @Rule
    public TemporaryFolder tempFolder = new TemporaryFolder();

    @Test
    public void testJarFromUrl() throws IOException, NoSuchAlgorithmException {
        File tempFolder = this.tempFolder.newFolder(FOLDER_NAME);

        UrlServiceUtils.saveFileFromUrlIfNotExistsInDirectory(JAR_URL_PATH, tempFolder.getPath());

        Assert.assertTrue("Jar file: " + JAR_URL_PATH + " doesn't exists", InternalServiceUtils.isFileExistsInADirectory(tempFolder.getPath(), jarFileName));
    }
}
