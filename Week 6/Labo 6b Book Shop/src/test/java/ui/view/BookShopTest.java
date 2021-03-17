package ui.view;

import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class BookShopTest {
    private WebDriver driver;

    @Before
    public void setUp(){
        //System.setProperty("webdriver.chrome.driver","C:\\Users\\....\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("http://localhost:8080/Book_Shop_war_exploded/");
    }

    @Test
    public void navigate_to_form(){
        assertEquals("Book Info", driver.getTitle());
    }

    @Test
    public void empty_form_generates_error(){
        driver.findElement(By.id("calculate")).click();
        ArrayList<WebElement> ps = (ArrayList<WebElement>) driver.findElements(By.tagName("p"));
        assertTrue(containsWebElementsWithText(ps,"Vul alle velden in."));
    }

    @Test
    public void correcte_gegevens_forward(){
        WebElement titelInput = driver.findElement(By.id("title"));
        titelInput.clear();
        titelInput.sendKeys("Alles komt goed");

        WebElement prijsInput = driver.findElement(By.id("price"));
        prijsInput.clear();
        prijsInput.sendKeys("10");

        WebElement aantalInput = driver.findElement(By.id("number"));
        aantalInput.clear();
        aantalInput.sendKeys("7");

        driver.findElement(By.id("calculate")).click();

        assertEquals("Book",driver.getTitle());

        ArrayList<WebElement> ps = (ArrayList<WebElement>) driver.findElements(By.tagName("p"));
        assertTrue(containsWebElementsWithText(ps,"Voor 7 exemplaren van het boek Alles komt goed moet je €70 betalen."));
    }

    @After
    public void cleanUp(){
        driver.quit();
    }

    private boolean containsWebElementsWithText(ArrayList<WebElement> elements, String text)
    {
        for (WebElement element : elements) {
            if (element.getText().equals(text)) {
                return true;
            }
        }
        return false;
    }

}
