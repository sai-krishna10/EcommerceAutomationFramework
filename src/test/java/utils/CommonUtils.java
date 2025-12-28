package utils;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Properties;

public class CommonUtils {

    private static String folderName;

    public static void initScreenshotFolder() {
        if (folderName == null) {
            String timestamp = LocalDateTime.now()
                    .format(DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss"));

            folderName = System.getProperty("user.dir")
                    + "/src/test/resources/screenshots/screenshots_" + timestamp;

            File folder = new File(folderName);
            if (!folder.exists()) {
                folder.mkdirs();
            }
        }
    }

    public Properties getProperties() throws IOException {
        Properties properties = new Properties();
        FileReader file = new FileReader(System.getProperty("user.dir")+"\\src\\test\\resources\\config\\Config.properties");
        properties.load(file);
        return properties;
    }

    public static String getScreenshot(WebDriver driver,String testcase) throws IOException {
        TakesScreenshot takesScreenshot = (TakesScreenshot)driver;
        File srcFile = takesScreenshot.getScreenshotAs(OutputType.FILE);
        String fileName = testcase+"_"+LocalDateTime.now().format(DateTimeFormatter.ofPattern("HHmmss"))+ ".png";
        File targetFile = new File(folderName + "/" + fileName);
        FileUtils.copyFile(srcFile, targetFile);
        return targetFile.getAbsolutePath();
    }

    public static String generateRandomEmail(){
        return LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss")) +"@gmail.com";
    }
}
