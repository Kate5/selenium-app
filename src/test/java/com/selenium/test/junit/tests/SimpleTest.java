package com.selenium.test.junit.tests;

import com.selenium.test.junit.rules.ScreenShotOnFailRule;
import com.selenium.test.webtestsbase.WebDriverFactory;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static com.selenium.test.webtestsbase.WebDriverFactory.takeScreenShot;
import static org.junit.Assert.assertTrue;


public class SimpleTest {

    @Rule
    public ScreenShotOnFailRule screenShotOnFailRule = new ScreenShotOnFailRule();

    @Before
    public void beforeTest() {
        WebDriverFactory.startBrowser(true);
    }


    @Test
    public void testFillGoogleForm() {
        String toSearch = "Selenium";
        WebDriverFactory.getDriver().get("http://www.youtube.com");
        WebElement searchString = WebDriverFactory.getDriver().findElement(By.cssSelector("#masthead-search-term"));
        searchString.sendKeys(toSearch);
        String searchStringText = searchString.getAttribute("value");
        assertTrue("Text from page(" + searchStringText + ") not equals to text from test(" + toSearch + ")",
                searchStringText.equals("ewew"));
    }

    @After
    public void afterTest() {
        WebDriverFactory.finishBrowser();
    }

}
