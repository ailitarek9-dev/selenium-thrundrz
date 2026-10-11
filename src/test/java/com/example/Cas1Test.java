package com.example;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.Duration;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.example.Page.DashboardPage;
import com.example.Page.DevenirPartenairePage;
import com.example.Page.HomePage;

public class Cas1Test {
    WebDriver driver;
    HomePage homepage;
    DevenirPartenairePage dppage;
    DashboardPage dspage;
    WebDriverWait wait;

    @Tag("TNR")
    @Test
    public void InsecriptionValide() {
        driver = new ChromeDriver();
        homepage = new HomePage(driver);
        dppage = new DevenirPartenairePage(driver);
        dspage = new DashboardPage(driver);
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // visiter le site
        driver.get("https://preprod.thrundrz.fr/");
        // clicker sur le button devenirpartenaire
        homepage.ClickDevenirPartenaire();
        assertTrue(driver.getCurrentUrl().endsWith("/devenir-partenaire"));
        dppage.ClickInscription();
        dppage.SaisieNom("tarek");
        dppage.SaisieEmail("tarek" + ((int) Math.floor(Math.random() * 2500)) + "@gmail.com");
        dppage.SaisieMP("tarek" + ((int) Math.floor(Math.random() * 2500)));
        dppage.SaisieNum("060245" + ((int) Math.floor(Math.random() * 9000) + 1000));
        dppage.ClickInscrire();
        wait.until(ExpectedConditions.urlContains("/EspaceClient"));
        assertTrue(driver.getCurrentUrl().endsWith("/EspaceClient"));
        //wait.until(ExpectedConditions.visibilityOfElementLocated(dspage.getNomString()));
        System.out.println("========================"+dspage.getValueNom());
        assertEquals("tarek", dspage.getValueNom());
    }
}
