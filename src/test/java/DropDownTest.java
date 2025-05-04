import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class DropDownTest extends BaseTest {

    @Test
    public void checkDropDown() {
        driver.get("https://the-internet.herokuapp.com/dropdown");
        WebElement dropdownElement = driver.findElement(By.id("dropdown"));
        SoftAssert softAssert = new SoftAssert();
        Select dropdown = new Select(dropdownElement);
        dropdown.selectByValue("1");
        WebElement selectOption = dropdown.getFirstSelectedOption();
        softAssert.assertEquals("1", selectOption.getDomAttribute("value"),
                "Должна быть выбрана Option 1");

        dropdown.selectByValue("2");
        selectOption = dropdown.getFirstSelectedOption();
        softAssert.assertEquals("2", selectOption.getDomAttribute("value"),
                "Должна быть выбрана Option 2");
        softAssert.assertAll();
    }
}
