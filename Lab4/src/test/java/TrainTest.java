import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;

public class TrainTest {

    private WebDriver driver;

    @BeforeClass
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\chromedriver\\chromedriver.exe");
        driver = new ChromeDriver();
    }

    @Test
    public void searchMilan() throws InterruptedException {
        driver.get("https://www.italiarail.com/");

        WebElement searchInput = driver.findElement(By.id("edit-keys"));
        searchInput.sendKeys("Milan");
        searchInput.submit();   
        WebElement results = driver.findElement(By.linkText("Train from Milan Malpensa Airport to Milan"));
        Thread.sleep(2000);
        System.out.println(results.getText());
        Assert.assertEquals(results.getText(), "Train from Milan Malpensa Airport to Milan");
    }

    @Test
    public void checkTimetableOfTrains() throws InterruptedException {
        driver.get("https://www.italiarail.com/");

        WebElement fromInput = driver.findElement(By.name("faresearch_route-origin"));
        fromInput.sendKeys("Rome");
        Thread.sleep(1000);

        WebElement toInput = driver.findElement(By.name("faresearch_route-destination"));
        toInput.sendKeys("Florence");
        Thread.sleep(1000);

        WebElement calendar = driver.findElement(By.name("faresearch_route-departure_date"));
        calendar.click();
        WebElement dateInput = driver.findElement(By.linkText("12"));
        dateInput.click();
        Thread.sleep(1000);

        driver.findElement(By.id("submit")).submit();



        List<WebElement> trains = driver.findElements(By.className("soln-container"));
        Thread.sleep(1000);
        System.out.println(trains.size());

        Assert.assertNotEquals(trains.size(), 0);
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}