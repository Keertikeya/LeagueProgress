package org.arcl.pages;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DivisionPage {
    WebDriver driver;
    WebDriverWait wait;
    private String division;

    public DivisionPage(WebDriver driver, String division) {
        this.driver = driver;
        this.wait = new WebDriverWait(this.driver, Duration.ofSeconds(2));
        PageFactory.initElements(this.driver, this);

        this.division = division;
    }

    @FindBy(xpath = "//table[1]/tbody")
    private WebElement tableBody;

    public List<WebElement> getTeams() {
        List<WebElement> table = tableBody.findElements(By.xpath("tr"));
        table.remove(0);
        return table;
    }

    public void goToTeamPage(int i) {
        List<WebElement> teams = this.getTeams();
        WebElement teamLink = teams.get(i).findElement(By.xpath("td[1]/a"));
        wait.until(ExpectedConditions.elementToBeClickable(teamLink));
        teamLink.click();
    }
}
