package com.example.Page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
    WebDriver driver;
    // ==> //a[@href="/devenir-partenaire"]
    By DevenirPartenaire = By.xpath("//a[@href='/devenir-partenaire']");

    //constricteur
    public HomePage(WebDriver driver){
        this.driver = driver;
    }
    //methode
    public void ClickDevenirPartenaire(){
        driver.findElement(DevenirPartenaire).click();
    }
}
