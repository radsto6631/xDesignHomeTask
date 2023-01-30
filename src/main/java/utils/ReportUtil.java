package utils;

import helpers.Directory;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.nio.file.Files;

public class ReportUtil {

    public static void clearDirectory() {
        File dir = new File(Directory.PROJECT_DIR + "\\report\\cucumber-reports\\");
        try {
            if (Files.exists(dir.toPath())) {
                FileUtils.cleanDirectory(dir);
            }
        } catch (Exception e) {
            throw  new AssertionError(e.getCause().getMessage());
        }
    }
}
