package com.example;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.File;
import java.time.Duration;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.example.Page.CommunautePage;
import com.example.Page.DashboardPage;
import com.example.Page.DevenirPartenairePage;
import com.example.Page.HomePage;

public class Cas2Test {
    WebDriver driver;
    HomePage homepage;
    DevenirPartenairePage dppage;
    DashboardPage dspage;
    CommunautePage cpage;
    WebDriverWait wait;

    @BeforeEach
    public void setUp(){
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        homepage = new HomePage(driver);
        dppage = new DevenirPartenairePage(driver);
        dspage = new DashboardPage(driver);
        cpage = new CommunautePage(driver);
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        driver.get("https://preprod.thrundrz.fr/");
        homepage.ClickDevenirPartenaire();
        assertTrue(driver.getCurrentUrl().endsWith("/devenir-partenaire"));
        dppage.RemplirEmail("ailitarek9@gmail.com");
        dppage.RemplirPass("tarek1234");
        dppage.ClickConnexion();
    }

    @AfterEach
    public void tearDown(){
        if(driver != null){
            driver.quit();
            driver = null;
        }
    }

@Test
public void Connexion(){
    wait.until(ExpectedConditions.urlContains("/EspaceClient"));
    dspage.ClickCommunauté();
    wait.until(ExpectedConditions.urlContains("/EspaceClient/communaute"));

    cpage.ClickMespublicationsBtn();
    wait.until(ExpectedConditions.visibilityOfElementLocated(
        By.xpath("//button[normalize-space()='Nouvelle annonce']")));

    cpage.ClickNvlAnnonce();
    wait.until(ExpectedConditions.visibilityOfElementLocated(
        By.xpath("//input[@placeholder='Titre de votre annonce']")));

    cpage.SaisirTitre("Lafete");
    cpage.SaisirDescription("Description");
    cpage.ClickBtnImage(new File("src/test/resources/image.png").getAbsolutePath());

    cpage.ClickBtnPublier();

    // Vérifie que la publication a bien marché
    wait.until(ExpectedConditions.visibilityOfElementLocated(
        By.xpath("//*[contains(text(),'Lafete')]")));
}
}