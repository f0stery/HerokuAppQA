import org.openqa.selenium.By;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class FramesTest extends BaseTest {

    @Test (testName = "Валидация текста в iFrame")
    public void checkFrameText() {
        driver.get("https://the-internet.herokuapp.com/iframe");
        driver.switchTo().frame(driver.findElement(By.id("mce_0_ifr")));
        String text = driver.findElement(By.cssSelector("#tinymce p")).getText();
        assertEquals(text, "Your content goes here.",
                "Текст не совпадает!");
        driver.switchTo().defaultContent();
    }
}
