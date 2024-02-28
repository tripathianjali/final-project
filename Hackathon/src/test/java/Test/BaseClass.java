package Test;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Date;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Properties;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.WebDriver;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import org.testng.annotations.Parameters;
import org.openqa.selenium.Platform;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class BaseClass {

    public static WebDriver driver;
    public static Logger logger;
    public Properties p;

    @BeforeTest
    @Parameters({"os", "browser"})
    public void setup(String os, String browser) throws IOException {
        // Loading properties file
        FileReader file = new FileReader(".//src//test//resources//config.properties");
        p = new Properties();
        p.load(file);
        // Loading log4j2 file
        logger = (Logger) LogManager.getLogger(this.getClass());

        if (p.getProperty("execution_env").equalsIgnoreCase("remote")) {
            DesiredCapabilities capabilities = new DesiredCapabilities();
            // os
            if (os.equalsIgnoreCase("windows")) {
                capabilities.setPlatform(Platform.WINDOWS);
            } else if (os.equalsIgnoreCase("mac")) {
                capabilities.setPlatform(Platform.MAC);
            } else {
                System.out.println("no matching os .....");
                return;
            }
            // browser
            if (browser.equalsIgnoreCase("chrome")) {
                capabilities.setBrowserName("chrome");
            } else if (browser.equalsIgnoreCase("edge")) {
                capabilities.setBrowserName("MicrosoftEdge");
            } else {
                System.out.println("no matching browser .....");
                return;
            }

            driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), capabilities);
        } else if (p.getProperty("execution_env").equalsIgnoreCase("local")) {
            if (browser.equalsIgnoreCase("chrome")) {
                driver = new ChromeDriver();
            } else if (browser.equalsIgnoreCase("edge")) {
                driver = new EdgeDriver();

            } else {
                System.out.println("No matching browser..........");
            }
        }

        driver.get(p.getProperty("link"));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.manage().window().maximize();
    }

    public String captureScreen(String tname) throws IOException {
        String timeStamp = new SimpleDateFormat("yyyMMddhhmmss").format(new Date());

        TakesScreenshot ts = (TakesScreenshot) driver;
        File sourceFile = ts.getScreenshotAs(OutputType.FILE);

        String targetFilePath = System.getProperty("user.dir") + "\\screenshots\\" + tname + "_" + timeStamp + ".png";
        File targetFile = new File(targetFilePath);
        FileUtils.copyFile(sourceFile, targetFile);

        return targetFilePath;
    }

    @AfterTest
    public void tearDown() {
        driver.quit();
    }
}

