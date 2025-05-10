package org.arcl.pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TeamDetailsPage {
    private WebDriver driver;
    private WebDriverWait wait;

    public TeamDetailsPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(this.driver, Duration.ofSeconds(2));
        PageFactory.initElements(this.driver, this);
    }

    @FindBy(xpath = "(//table)[3]/tbody")
    private WebElement battingTable;

    @FindBy(xpath = "(//table)[4]/tbody")
    private WebElement bownlingTable;

    public List<WebElement> getBatsmanList() {
        wait.until(ExpectedConditions.visibilityOf(battingTable));
        List<WebElement> batsmanList = battingTable.findElements(By.xpath("tr"));
        batsmanList.remove(0);
        return batsmanList;
    }


    public List<WebElement> getBowlerList() {
        wait.until(ExpectedConditions.visibilityOf(bownlingTable));
        List<WebElement> bowlerList = bownlingTable.findElements(By.xpath("tr"));
        bowlerList.remove(0);
        return bowlerList;
    }
}
