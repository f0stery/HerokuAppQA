import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class TyposTest extends BaseTest {

    @Test (testName = "Проверка корректности текста на странице")
    public void checkTypos() {
        driver.get("https://the-internet.herokuapp.com/typos");
        WebElement paragraph = driver.findElement(By.tagName("p"));
        String expectedText = paragraph.getText();
        boolean foundCorrectVersion = false;

        for (int i = 0; i < 10; i++) {
            paragraph = driver.findElement(By.tagName("p"));
            String actualText = paragraph.getText().trim();
            if (actualText.equals(expectedText)) {
                foundCorrectVersion = true;
                break;
            } else {
                driver.navigate().refresh();
            }
        }
        softAssert.assertTrue(foundCorrectVersion, "За 10 попыток не найдена корректная версия текста");
        softAssert.assertAll();
    }
}
