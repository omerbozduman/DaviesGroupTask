package com.DaviesGroup.pages;

import com.DaviesGroup.utilities.BrowserUtils;
import com.DaviesGroup.utilities.Driver;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.MoveTargetOutOfBoundsException;
import org.openqa.selenium.support.FindBy;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.List;

public class AboutPage extends BasePage {

    @FindBy(xpath = "//a[contains(text(),'About')]")
    public WebElement aboutModule;

//    @FindBy(xpath = "//a[contains(text(),'Locations')]")
//    public WebElement locationsSubModule;

    @FindBy(css = ".location__marker")
    public List<WebElement> locations;

    @FindBy(id="marker0_12")
    public WebElement stokeElement;

    @FindBy(xpath = "//li[@id='desc0_12']/h3")
    public WebElement stokeAddress;

    public void clickSubModule(String subModule) {
        String locator = "//a[contains(text(),'"+subModule+"')]";
        WebElement subModuleElement = Driver.get().findElement(By.xpath(locator));
        BrowserUtils.clickWithJS(subModuleElement);
    }

    public String getOfficeLocation(String officeLocation) throws IOException {



        Actions actions = new Actions(Driver.get());
        String locationAdres=null;
        WebElement addressElement = null;
        for (int i = 0; i < locations.size(); i++) {
            BrowserUtils.clickWithJS(locations.get(i));
            String locator = "//li[@id='desc0_"+ i +"']/h3";
            WebElement locationName = Driver.get().findElement(By.xpath(locator));
            String locatorAddress= "desc0_"+ i ;
            addressElement = Driver.get().findElement(By.id(locatorAddress));
            BrowserUtils.waitForVisibility(locationName, 10);
            if (locationName.getText().contains(officeLocation)) {
               ((JavascriptExecutor) Driver.get()).executeScript("arguments[0].scrollIntoView(false);", addressElement);
               BrowserUtils.waitFor(3);
                File scrFile = ((TakesScreenshot)Driver.get()).getScreenshotAs(OutputType.FILE);
                String projectPath = System.getProperty("user.dir");
                String relativePath = "/target/capture/";
                String filePath=projectPath + relativePath;
                FileUtils.copyFile(scrFile, new File(filePath+"officelocation.png"));

                locationAdres=locationName.getText();
                break;
            }
        }
        System.out.println("address of location = " + addressElement.getText());
        return locationAdres;


    }
    

}
