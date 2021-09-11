package drivers;

import com.google.common.collect.ImmutableMap;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.Command;
import org.openqa.selenium.remote.CommandExecutor;

import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class ChromeConfigurator implements DriverConfigurator {
    @Override
    public WebDriver setup() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--no-sandbox");
        options.addArguments("--whitelisted-ips");
        options.addArguments("--disable-extensions");
        options.addArguments("--disable-gpu");
        options.setExperimentalOption("excludeSwitches", Collections.singletonList("enable-automation"));

        return new ChromeDriver(options);

//        WebDriver driver = new ChromeDriver(options);
//        throttle(driver);
//        return driver;
    }

    /**
     * Throttling hack - not available thru options, requires CommandExecutor and specific syntax.
     *
     * @param driver
     * @see <a href="https://codoid.com/how-to-set-network-conditions-in-selenium/"></a>
     */
    private void throttle(final WebDriver driver) {
        try {
            ChromeDriver castDriver = (ChromeDriver) driver;
            CommandExecutor executor = castDriver.getCommandExecutor();
            Map<String, Object> map = new HashMap<>();
            map.put("offline", false);
            map.put("latency", 5);
            // its in bytes per second via docu
            map.put("download_throughput", 100 * 1024);
            map.put("upload_throughput", 100 * 1024);
            executor.execute(new Command(castDriver.getSessionId(), "setNetworkConditions", ImmutableMap.of("network_conditions", ImmutableMap.copyOf(map))));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
