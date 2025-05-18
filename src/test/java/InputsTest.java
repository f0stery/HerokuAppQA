import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class InputsTest extends BaseTest {

    @Test (testName = "Валидация поля для ввода")
    public void checkInputs() {
        SoftAssert softAssert = new SoftAssert();
        driver.get("https://the-internet.herokuapp.com/inputs");
        WebElement inputSimbol = driver.findElement(By.tagName("input"));

        inputSimbol.sendKeys("abc");
        softAssert.assertEquals("", inputSimbol.getAttribute("value"),
                "Не должно быть символов");

        inputSimbol.sendKeys("123");
        softAssert.assertEquals("123", inputSimbol.getAttribute("value"),
                "Должны быть число 123");

        inputSimbol.sendKeys(Keys.ARROW_UP);
        softAssert.assertEquals("124", inputSimbol.getAttribute("value"),
                "Должны быть число 124");

        inputSimbol.sendKeys(Keys.ARROW_UP, Keys.ARROW_UP, Keys.ARROW_UP);
        softAssert.assertEquals("127", inputSimbol.getAttribute("value"),
                "Должны быть число 127");

        inputSimbol.sendKeys(Keys.ARROW_DOWN, Keys.ARROW_DOWN);
        softAssert.assertEquals("125", inputSimbol.getAttribute("value"),
                "Должны быть число 125");

        inputSimbol.clear();
        inputSimbol.sendKeys("1e2");
        softAssert.assertEquals("1e2", inputSimbol.getAttribute("value"),
                "Должны быть число 1e2");
        inputSimbol.sendKeys(Keys.ARROW_DOWN);
        softAssert.assertEquals("99", inputSimbol.getAttribute("value"),
                "Должны быть число 99");

        softAssert.assertAll();
    }
}
