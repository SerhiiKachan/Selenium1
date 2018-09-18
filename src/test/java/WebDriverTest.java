import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class WebDriverTest {

    private WebDriver driver;

    @BeforeClass
    public void init(){
        driver = new ChromeDriver();
    }

    @Test
    public void firstTest(){
        driver.get("https://www.google.com");
        WebElement element = driver.findElement(By.name("q"));
        element.sendKeys("Apple");
        element.submit();
        (new WebDriverWait(driver, 5)).until((d) -> d.getTitle().contains("pl"));
        System.out.println("Page title is: " + driver.getTitle());
    }

    @AfterClass
    public void exit(){
        driver.quit();
    }
}
