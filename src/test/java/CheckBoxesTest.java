import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.List;

public class CheckBoxesTest extends BaseTest {

    @Test
    public void checkFirstBox() {
        driver.get("https://the-internet.herokuapp.com/checkboxes");
        List<WebElement> boxes = driver.findElements(By.cssSelector("input[type=checkbox]"));
        SoftAssert softAssert = new SoftAssert();
        boolean checkFirstBox = boxes.get(0).isSelected();
        softAssert.assertFalse(checkFirstBox, "Первый чек-бокс выбран");
        boxes.get(0).click();
        checkFirstBox = boxes.get(0).isSelected();
        softAssert.assertTrue(checkFirstBox, "Первый чек-бокс не выбран");
        boolean checkSecondBox = boxes.get(1).isSelected();
        softAssert.assertTrue(checkSecondBox, "Второй чек-бокс не выбран");
        boxes.get(1).click();
        checkSecondBox = boxes.get(1).isSelected();
        softAssert.assertFalse(checkSecondBox, "Второй чек-блок не выбран");
        softAssert.assertAll();
    }
}
