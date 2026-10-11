package com.example.Page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DashboardPage {
    WebDriver driver;
    By nomTarek = By.xpath("//header//span[normalize-space(text())='tarek']");
    By CommunautéBtn = By.xpath("//button[.//p[normalize-space()='Communauté']]");
    public DashboardPage(WebDriver driver){
        this.driver = driver;
    }
    public String getValueNom(){
        return driver.findElement(nomTarek).getText();
    }
    public By getNomString(){
        return nomTarek;
    }
    public void ClickCommunauté() {
        driver.findElement(CommunautéBtn).click();
    }
}
