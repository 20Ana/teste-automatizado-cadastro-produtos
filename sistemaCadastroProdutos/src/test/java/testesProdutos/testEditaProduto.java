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

public class testEditaProduto {

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
    public void testeEditarProdutoSemOrigem () {
        driver.findElement(By.id("botao_edita")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("descricao_edita")));
        driver.findElement(By.id("descricao_edita")).sendKeys("descricao_edita test");
        driver.findElement(By.id("data_edita")).sendKeys("12/28/2018");
        driver.findElement(By.id("imagem_edita")).sendKeys("");
        driver.findElement(By.id("preco_edita")).sendKeys("2,50");
        new Select(driver.findElement(By.id("categoria_edita"))).selectByVisibleText("Livro");
        driver.findElement(By.id("botao_edita")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(""))).isDisplayed();

    }

    @Test
    public void testeEditarProdutoSemDescricao () {
        driver.findElement(By.id("botao_edita")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("descricao_edita")));
        driver.findElement(By.id("data_edita")).sendKeys("12/28/2018");
        driver.findElement(By.id("imagem_edita")).sendKeys("");
        driver.findElement(By.id("preco_edita")).sendKeys("2,50");
        driver.findElement(By.id("origem_edita")).click();
        new Select(driver.findElement(By.id("categoria_edita"))).selectByVisibleText("Livro");
        driver.findElement(By.id("botao_edita")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(""))).isDisplayed();

    }

    @Test
    public void testeEditarProdutoSemImagem () {
        driver.findElement(By.id("botao_edita")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("descricao_edita")));
        driver.findElement(By.id("descricao_edita")).sendKeys("descricao_edita test");
        driver.findElement(By.id("data_edita")).sendKeys("12/28/2018");
        driver.findElement(By.id("preco_edita")).sendKeys("2,50");
        driver.findElement(By.id("origem_edita")).click();
        new Select(driver.findElement(By.id("categoria_edita"))).selectByVisibleText("Livro");
        driver.findElement(By.id("botao_edita")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(""))).isDisplayed();

    }

    @Test
    public void testeEditarProdutoCompleto () {
        driver.findElement(By.id("botao_edita")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("descricao_edita")));
        driver.findElement(By.id("descricao_edita")).sendKeys("descricao_edita test");
        driver.findElement(By.id("data_edita")).sendKeys("12/28/2018");
        driver.findElement(By.id("imagem_edita")).sendKeys("");
        driver.findElement(By.id("preco_edita")).sendKeys("2,50");
        driver.findElement(By.id("origem_edita")).click();
        new Select(driver.findElement(By.id("categoria_edita"))).selectByVisibleText("Livro");
        driver.findElement(By.id("botao_edita")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(""))).isDisplayed();

    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
