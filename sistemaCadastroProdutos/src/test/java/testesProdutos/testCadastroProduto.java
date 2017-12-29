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

public class testCadastroProduto {

    WebDriver driver;
    WebDriverWait wait;

    @Before
    public void setUp(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();;
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        wait = new WebDriverWait(driver, 5);
        driver.get("http://localhost/produtos");
    }

    @Test
    public void testeCadastroProdutoSemOrigem () {
        driver.findElement(By.id("botao_cadastra_index")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("descricao")));
        driver.findElement(By.id("descricao")).sendKeys("Qualquer Descrição");
        driver.findElement(By.id("data")).sendKeys("12/12/2018");
        driver.findElement(By.id("imagem")).sendKeys("https://dummyimage.com/600x400/000e12/f5f5f5.jpg&text=Produto+sem+imagem");
        driver.findElement(By.id("preco")).sendKeys("2,50");
        new Select(driver.findElement(By.id("categoria"))).selectByVisibleText("Livro");
        driver.findElement(By.id("botao_cadastra")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("msg_produto_cadastrado"))).isDisplayed();

    }

    @Test
    public void testeCadastroProdutoSemDescricao () {
        driver.findElement(By.id("botao_cadastra_index")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("descricao")));
        driver.findElement(By.id("descricao")).sendKeys("Qualquer Descrição");
        driver.findElement(By.id("data")).sendKeys("12/12/2018");
        driver.findElement(By.id("imagem")).sendKeys("https://dummyimage.com/600x400/000e12/f5f5f5.jpg&text=Produto+sem+imagem");
        driver.findElement(By.id("preco")).sendKeys("2,50");
        driver.findElement(By.id("origem")).click();
        driver.findElement(By.id("botao_cadastra")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("msg_produto_cadastrado"))).isDisplayed();

    }
    @Test
    public void testeCadastroProdutoSemImagem () {
        driver.findElement(By.id("botao_cadastra_index")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("descricao")));
        driver.findElement(By.id("descricao")).sendKeys("Qualquer Descrição");
        driver.findElement(By.id("data")).sendKeys("12/12/2018");
        driver.findElement(By.id("preco")).sendKeys("2,50");
        driver.findElement(By.id("origem")).click();
        new Select(driver.findElement(By.id("categoria"))).selectByVisibleText("Livro");
        driver.findElement(By.id("botao_cadastra")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("msg_produto_cadastrado"))).isDisplayed();

    }
    @Test
    public void testeCadastroProdutoCompleto () {
        driver.findElement(By.id("botao_cadastra_index")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("descricao")));
        driver.findElement(By.id("descricao")).sendKeys("Qualquer Descrição");
        driver.findElement(By.id("data")).sendKeys("12/12/2018");
        driver.findElement(By.id("imagem")).sendKeys("https://dummyimage.com/600x400/000e12/f5f5f5.jpg&text=Produto+sem+imagem");
        driver.findElement(By.id("preco")).sendKeys("2,50");
        driver.findElement(By.id("origem")).click();
        new Select(driver.findElement(By.id("categoria"))).selectByVisibleText("Livro");
        driver.findElement(By.id("botao_cadastra")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("msg_produto_cadastrado"))).isDisplayed();

    }
    @After
    public void tearDown() {
        driver.quit();
    }
}
