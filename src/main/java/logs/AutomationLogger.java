package logs;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class AutomationLogger {

    private static final Logger logger = LogManager.getLogger();

    /**
     *
     * @return  The logger instance
     */
    public static Logger getLog() {
        return logger;
    }
}
