package com.example.Page;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CommunautePage {
    WebDriver driver;

    By MespublicationsBtn = By.xpath("//button[@title='Mes publications']");
    By NvlAnnonce = By.xpath("//button[normalize-space()='Nouvelle annonce']");
    By Titre = By.xpath("//input[@placeholder='Titre de votre annonce']");
    By Description = By.xpath("//textarea[@placeholder='Écrivez votre description ici…']");
    By BtnImage = By.xpath("//input[@type='file']");
    By BtnPublier = By.xpath("//button[normalize-space()='Publier']");

    public CommunautePage(WebDriver driver){
        this.driver = driver;
    }
    public void ClickMespublicationsBtn(){
        driver.findElement(MespublicationsBtn).click();
    }
    public void ClickNvlAnnonce(){
        driver.findElement(NvlAnnonce).click();
    }
    public void SaisirTitre(String u){
        driver.findElement(Titre).sendKeys(u);
    }
    public void SaisirDescription(String u){
        driver.findElement(Description).sendKeys(u);
    }
    public void ClickBtnImage(String u){
        driver.findElement(BtnImage).sendKeys(u);
    }
    public void ClickBtnPublier(){
    ((JavascriptExecutor) driver).executeScript("arguments[0].click();", driver.findElement(BtnPublier));
    }
}