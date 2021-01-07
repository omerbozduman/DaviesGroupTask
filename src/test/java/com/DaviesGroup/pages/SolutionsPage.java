package com.DaviesGroup.pages;

import com.DaviesGroup.utilities.BrowserUtils;
import com.DaviesGroup.utilities.Driver;
import io.cucumber.java.Scenario;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import java.io.File;
import java.io.IOException;


public class SolutionsPage extends BasePage{

    @FindBy(xpath = "//a[contains(text(),'Solutions')]")
    public WebElement solutionsButton;

    @FindBy(xpath = "//p[contains(text(),'View All')]")
    public WebElement viewAllButton;

    @FindBy(id="select2--container")
    public WebElement searchBox;

    @FindBy(className = "select2-search__field")
    public WebElement searchField;

    @FindBy(xpath = "//h2[contains(text(),'Results')]")
    public WebElement results;

    @FindBy(xpath = "(//h2[contains(text(),'Results')]/../p)[2]")
    public WebElement resultText;

    Actions actions= new Actions(Driver.get());

    public void clickViewAll(){
 //       solutionsButton.click();
        BrowserUtils.waitForClickablility(viewAllButton,10);
//        JavascriptExecutor jsx = (JavascriptExecutor)Driver.get();
//        jsx.executeScript("window.scrollBy(910,1815)", "");
        BrowserUtils.clickWithJS(viewAllButton);
//
//        actions.moveToElement(viewAllButton).click(viewAllButton).perform();

    }

    public void sendKey(){

        BrowserUtils.waitForPageToLoad(10);
        searchBox.click();
        searchField.sendKeys("Fire investigation" + Keys.ENTER);

    }

    public void captureResult() throws IOException {

   //     BrowserUtils.hover(resultText);

        ((JavascriptExecutor) Driver.get()).executeScript("arguments[0].scrollIntoView(false);", resultText);

        BrowserUtils.waitFor(3);

        File scrFile = ((TakesScreenshot)Driver.get()).getScreenshotAs(OutputType.FILE);
        String projectPath = System.getProperty("user.dir");
        String relativePath = "/target/capture/";
        String filePath=projectPath + relativePath;
        FileUtils.copyFile(scrFile, new File(filePath+"results.png"));
    //    FileUtils.copyFile(scrFile, new File("/Users/omerbozduman/IdeaProjects/DaviesGroupTask/target/capture/results.png"));
    }
}
