package testesProdutos;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

public class testApagaProduto {

    WebDriver driver;
    WebDriverWait wait;

    @Before
    public void setUp(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        wait = new WebDriverWait(driver, 5);
        driver.get("http://localhost/produtos/lista-produto.php");
    }

    @Test
    public void testeRemoveProduto () {
        driver.findElement(By.id("botao_remove")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("msg_produto_removido"))).isDisplayed();
    }

    @After
    public void tearDown() {
        driver.quit();
    }

}
