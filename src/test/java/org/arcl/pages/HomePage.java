package org.arcl.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {
    private WebDriver driver;
    private WebDriverWait wait;
    private String url = "https://arcl.org/";
    private WebElement divisionLink;

    public HomePage(WebDriver driver, String division) {
        this.driver = driver;
        this.wait = new WebDriverWait(this.driver, Duration.ofSeconds(2));
        PageFactory.initElements(this.driver, this);
        
        this.driver.get(this.url);
        this.divisionLink = getDivisionElement(division);
    }

    private WebElement getDivisionElement(String division) {
        String xpath = String.format("//a[text()='Div %s']", division.toUpperCase());
        return this.driver.findElement(By.xpath(xpath));
    }

    public void goToDivisionPage() {
        wait.until(ExpectedConditions.elementToBeClickable(this.divisionLink));
        this.divisionLink.click();
    }
}
