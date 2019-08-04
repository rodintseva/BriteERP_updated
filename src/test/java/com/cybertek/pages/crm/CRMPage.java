package com.cybertek.pages.crm;

import com.cybertek.pages.loginpage.LoginPage;
import com.cybertek.utilities.BriteUtils;
import com.cybertek.utilities.ConfigurationReader;
import com.cybertek.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.events.WebDriverEventListener;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import java.util.List;

public class CRMPage {


    public CRMPage() {

        PageFactory.initElements(Driver.getDriver(), this);

    }


    @FindBy(css = "button[data-original-title='Pivot']")
    public WebElement pivotButtonLocator;


    @FindBy(css = "table tbody tr:nth-of-type(2) td:nth-of-type(1) ")
    public WebElement NewButtonLocator;


    @FindBy(css = "li[data-field='name']>a")
    public WebElement DropDownOpportunityLocator;


    @FindBy(css = "table tbody tr:nth-of-type(4) td:nth-of-type(2)")
    public WebElement secondRowSecondColumnLocator;

    @FindBy(css = "button[data-view-type='list']")
    public WebElement listButtonLocator;


    @FindBy(css = "table tbody tr:nth-of-type(3) td:nth-of-type(9)")
    public WebElement listMatchingTableLocator;


    @FindBy(css = "table tbody tr:nth-of-type(1) td:nth-of-type(2)")
    public WebElement totalExpectedRevenueLocator;






  public void getToOpportunity(){
      //1 1.Login
      LoginPage loginpage = new LoginPage();
      String username = ConfigurationReader.getProperty("username");
      String password = ConfigurationReader.getProperty("password");
      loginpage.login(username,password);

      // 2.click CRM button
      BriteUtils.navigateToModule(Driver.getDriver(), "CRM");

      // 3.click pivot icon
      BriteUtils.clickOn(Driver.getDriver(),pivotButtonLocator,20);

      // 4. click new and choose opportunity
      BriteUtils.clickOn(Driver.getDriver(),NewButtonLocator,20);
      BriteUtils.clickOn(Driver.getDriver(),DropDownOpportunityLocator,20);

  }



    public void selectAction(String actionName) {
        String optionLocator = "//a[contains(@data-section,'other') and contains(text(),'" + actionName + "')]";
        BriteUtils.waitForVisibility(Driver.getDriver().findElement(By.xpath(optionLocator)), 5);
        Driver.getDriver().findElement(By.xpath(optionLocator)).click();
    }


    public void verifyThatOpportunityDeleted(String opportunity) {
        String locator = "//td[text()='" + opportunity + "']";
        List<WebElement> elements = Driver.getDriver().findElements(By.xpath(locator));
        Assert.assertTrue(elements.isEmpty());
    }


    @FindBy(css = "div[class='btn-group btn-group-sm o_cp_switch_buttons']>button[accesskey='l']")
    public WebElement listIconLocator;

    @FindBy(css = "table[class^='o_list_view table table-condensed']")
    public WebElement listTable;

    @FindBy(css = "table[class^='o_list_view table table-condensed']>tbody>tr")
    public WebElement firstOptionOfTable;

    @FindBy(xpath = "//button[contains(text(),'Action')]")
    public WebElement actionButtonLOcator;

    @FindBy(css = "div[class='modal-footer']>button>span")
    public WebElement okButtonLocator;

    @FindBy(xpath = "//ol[@class='breadcrumb']//a[contains(text(),'Pipeline')]")
    public WebElement pageNameLocator;

    @FindBy(xpath = "//li[@class='active']//span[@class='oe_menu_text'][contains(text(),'Pipeline')]")
    public WebElement pipelinePage;

}