package com.DaviesGroup.pages;

import com.DaviesGroup.utilities.BrowserUtils;
import com.DaviesGroup.utilities.ConfigurationReader;
import com.DaviesGroup.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;


public abstract class BasePage {

    public BasePage(){
        PageFactory.initElements(Driver.get(),this);
    }

    public void setUp(){
        Driver.get().get(ConfigurationReader.get("url"));
    }

    public String getPageTitle() {
        return Driver.get().getTitle();
    }

    public WebElement navigateToModule(String module) {

        //String manipulation
        String moduleLocator = "//a[contains(text(),'"+module+"')]";
        WebElement moduleElement=null;
        try {
            BrowserUtils.waitForClickablility(By.xpath(moduleLocator), 5);
            moduleElement = Driver.get().findElement(By.xpath(moduleLocator));
        } catch (Exception e) {
            BrowserUtils.clickWithWait(By.xpath(moduleLocator), 5);
        }
        
        return moduleElement;
    }

}
