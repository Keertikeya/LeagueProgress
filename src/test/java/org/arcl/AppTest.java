package org.arcl;

import org.testng.annotations.Test;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.time.Duration;
import java.util.*;

import org.arcl.libs.Batsman;
import org.arcl.libs.Bowler;
import org.arcl.pages.DivisionPage;
import org.arcl.pages.HomePage;
import org.arcl.pages.TeamDetailsPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;

public class AppTest {
    static String division = System.getProperty("config.division").toUpperCase();
    List<Batsman> batsmen = new ArrayList<>();
    List<Bowler> bowlers = new ArrayList<>();

    WebDriver driver;
    HomePage homePage;

    @BeforeTest
    public void setUp() {
        FirefoxProfile profile = new FirefoxProfile();
        profile.setPreference("permissions.default.geo", 2);
        FirefoxOptions options = new FirefoxOptions();
        options.setProfile(profile);
        driver = new FirefoxDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().window().maximize();
        homePage = new HomePage(driver, division);
    }
    
    @Test
    public void shouldAnswerWithTrue() throws InterruptedException{
        homePage.goToDivisionPage();
        DivisionPage divisionPage = new DivisionPage(driver, division);

        int numberOfTeams = divisionPage.getTeams().size();

        for (int i = 0; i < numberOfTeams; i++) {
            divisionPage.goToTeamPage(i);

            TeamDetailsPage teamDetailsPage = new TeamDetailsPage(driver);

            // Get info for all batsmen in the league
            List<WebElement> bastmenElements = teamDetailsPage.getBatsmanList();
            for (WebElement batsmanElement : bastmenElements) {
                batsmen.add(
                    new Batsman(
                        batsmanElement.findElement(By.xpath("td[1]")).getText(),
                        batsmanElement.findElement(By.xpath("td[3]")).getText(),
                        Integer.parseInt(batsmanElement.findElement(By.xpath("td[5]")).getText()),
                        Integer.parseInt(batsmanElement.findElement(By.xpath("td[6]")).getText()),
                        Integer.parseInt(batsmanElement.findElement(By.xpath("td[7]")).getText()),
                        Integer.parseInt(batsmanElement.findElement(By.xpath("td[8]")).getText())
                    )
                );
            }

            // Get info for all bowlers in the league
            List<WebElement> bowlerElements = teamDetailsPage.getBowlerList();
            for (WebElement bowelerElement : bowlerElements) {
                bowlers.add(
                    new Bowler(
                        bowelerElement.findElement(By.xpath("td[1]")).getText(),
                        bowelerElement.findElement(By.xpath("td[3]")).getText(),
                        Double.parseDouble(bowelerElement.findElement(By.xpath("td[5]")).getText()),
                        Integer.parseInt(bowelerElement.findElement(By.xpath("td[7]")).getText()),
                        Integer.parseInt(bowelerElement.findElement(By.xpath("td[8]")).getText())
                    )
                );
            }
            
            this.driver.navigate().back();
        }

        List<Batsman> mostRunsBatsmen = new ArrayList<>(batsmen);
        Collections.sort(mostRunsBatsmen, Batsman.mostRunsComparator);

        System.out.println(String.format("Top 10 batsmen in division %s", division));
        int counter = 1;

        for (Batsman batsman : mostRunsBatsmen) {
            System.out.println(counter + ". " + batsman.runsInfo());
            counter += 1;
            if (counter == 11) {
                break;
            }
        }

        List<Bowler> mostWicketsBowlers = new ArrayList<>(bowlers);
        Collections.sort(mostWicketsBowlers, Bowler.wicketsComparator);

        System.out.println();

        System.out.println(String.format("Top 10 bowlers in division %s", division));
        counter = 1;
        for (Bowler bowler : mostWicketsBowlers) {
            System.out.println(counter + ". " + bowler.wicketsInfo());
            counter += 1;
            if (counter == 11) {
                break;
            }
        }
    }

    @AfterTest
    public void tearDown() {
        driver.quit();
    }
}
