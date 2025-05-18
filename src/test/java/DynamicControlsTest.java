import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import java.time.Duration;

import static org.testng.Assert.assertTrue;

public class DynamicControlsTest extends BaseTest{

    @Test (testName = "Dynamic Control")
    public void checkDynamicControls() {
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");
        driver.findElement(By.xpath("//*[text()='Remove']")).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("message")));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("checkbox")));
        boolean isDisable = !driver.findElement(By.cssSelector("[type='text']")).isEnabled();
        assertTrue(isDisable, "Поле должно быть заблокировано!");
        driver.findElement(By.xpath("//*[text()='Enable']")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("message")));
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("[type='text']")));
    }
}
