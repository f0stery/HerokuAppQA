import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import java.time.Duration;
import static org.testng.Assert.assertEquals;

public class ContextMenuTest extends BaseTest{

    @Test (testName = "Валидация текста на alerts Context Menu")
    public void checkContextMenu() {
        driver.get("https://the-internet.herokuapp.com/context_menu");
        Actions actions = new Actions(driver);
        actions.contextClick(driver.findElement(By.id("hot-spot")));
        actions.perform();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        assertEquals(alert.getText(), "You selected a context menu", "Текст не совпадает!");
        alert.accept();
    }
}
