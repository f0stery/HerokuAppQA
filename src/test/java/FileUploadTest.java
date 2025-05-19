import org.openqa.selenium.By;
import org.testng.annotations.Test;
import java.io.File;
import static org.testng.Assert.assertEquals;

public class FileUploadTest extends BaseTest {

    @Test (testName = "Валидация имени загруженного файла File Upload")
    public void checkUploadFile() {
        driver.get("https://the-internet.herokuapp.com/upload");
        File file = new File("src/test/java/Files/TestFileName");
        driver.findElement(By.id("file-upload")).sendKeys(file.getAbsolutePath());
        driver.findElement(By.cssSelector(".button")).click();
        assertEquals(driver.findElement(By.id("uploaded-files")).getText(), "TestFileName",
                "Название файла не совпадает!");
    }
}
