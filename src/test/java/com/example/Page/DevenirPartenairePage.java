package com.example.Page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DevenirPartenairePage {
    WebDriver driver;

    By InscriptionBtn = By.xpath("//button[contains(text(),'Inscription')]");
    By InputNom = By.xpath("//input[@placeholder='Votre nom complet']");
    By InputEmail = By.xpath("//input[@placeholder='Votre email']");
    By InputMotpasse = By.xpath("//input[@placeholder='6 caractères minimum']");
    By InputNum = By.xpath("//input[@placeholder='Ex : 06 01 02 03 04']");
    By InscrireBtn = By.xpath("//button[contains(text(),\"S'inscrire\")]");
    By SetEmail = By.xpath("//input[@placeholder='Votre email']");
    By SetPass = By.xpath("//input[@placeholder='********']");
    By ConnexionBtn = By.xpath("//button[contains(text(),'Se connecter')]");




    public DevenirPartenairePage(WebDriver driver) {
        this.driver = driver;
    }

    public void ClickInscription() {
        driver.findElement(InscriptionBtn).click();
    }

    public void SaisieNom(String u) {
        driver.findElement(InputNom).sendKeys(u);
    }

    public void SaisieEmail(String e) {
        driver.findElement(InputEmail).sendKeys(e);
    }

    public void SaisieMP(String u) {
        driver.findElement(InputMotpasse).sendKeys(u);
    }

    public void SaisieNum(String u) {
        driver.findElement(InputNum).sendKeys(u);
    }

    public void ClickInscrire() {
        driver.findElement(InscrireBtn).click();
    }

    public void RemplirEmail(String u) {
        driver.findElement(SetEmail).sendKeys(u);
    }

    public void RemplirPass(String u) {
        driver.findElement(SetPass).sendKeys(u);
    }

    public void ClickConnexion() {
        driver.findElement(ConnexionBtn).click();
    }
}
