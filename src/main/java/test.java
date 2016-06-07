import requests.InternalServiceUtils;
import requests.UrlServiceUtils;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;

public class test {

    static final String URL = "http://central.maven.org/maven2/org/apache/logging/log4j/log4j-core/2.6/log4j-core-2.6.jar";

    public static void main(String[] args) throws IOException, NoSuchAlgorithmException {
        UrlServiceUtils.saveFileFromUrlIfNotExistsInDirectory("http://central.maven.org/maven2/org/apache/logging/log4j/log4j-core/2.6/log4j-core-2.6.jar", "C:\\Users\\Inbar Ardity\\Desktop\\myTemp");
        int q = 0;
    }
}
