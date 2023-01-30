package steps;

import com.cucumber.listener.Reporter;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import managers.DriverBoss;
import utils.ReportUtil;

import java.time.Duration;

public class UiHook {

    @Before
    public void startTest(){
        ReportUtil.clearDirectory();
        DriverBoss.getInstance();
        DriverBoss.getInstance().navigate().to("https://fe-automation-tool.s3.eu-west-1.amazonaws.com/index.html");
        DriverBoss.getInstance().manage().window().maximize();
        DriverBoss.getInstance().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @After
    public void closeBrowser(){
        DriverBoss.closeDriver();
    }

    @After
    public static void writeExtentReport() {
        Reporter.loadXMLConfig("src/main/resources/extent-config.xml");
    }

}
