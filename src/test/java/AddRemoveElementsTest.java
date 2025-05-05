import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.List;

public class AddRemoveElementsTest extends BaseTest {

    @Test
    public void checkAddRemoveElements() {
        driver.get("https://the-internet.herokuapp.com/add_remove_elements/");
        driver.findElement(By.xpath("//button[text()='Add Element']")).click();
        driver.findElement(By.xpath("//button[text()='Add Element']")).click();
        List<WebElement> buttons = driver.findElements(By.xpath("//button[text()='Delete']"));
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(buttons.size(), 2);
        buttons.get(1).click();
        List<WebElement> buttonsAfterDelete = driver.findElements(By.xpath("//button[text()='Delete']"));
        softAssert.assertEquals(buttonsAfterDelete.size(), 1);
        softAssert.assertAll();
    }
}
