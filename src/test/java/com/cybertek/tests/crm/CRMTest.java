package com.cybertek.tests.crm;

import com.cybertek.pages.crm.CRMPage;
import com.cybertek.pages.loginpage.LoginPage;
import com.cybertek.utilities.BriteUtils;
import com.cybertek.utilities.ConfigurationReader;
import com.cybertek.utilities.Driver;
import com.cybertek.utilities.TestBase;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CRMTest extends TestBase {


    @Test  //(priority = 1)
    public void Test1() {
        CRMPage crmpage = new CRMPage();
        // 1.log in
        // 2.click CRM button
        // 3.click pivot icon
        // 4. click new and choose opportunity
        crmpage.getToOpportunity();

        // 5.choose second row and second column /on list board it is first one
        String secondRowSecondColumnExpectedRevenue = crmpage.secondRowSecondColumnLocator.getText();
        System.out.println(secondRowSecondColumnExpectedRevenue);//8,765.00

        BriteUtils.clickOn(Driver.getDriver(), crmpage.listIconLocator, 20);
        String listMatchingTableExpectedRevenue = crmpage.listMatchingTableLocator.getText();
        System.out.println(listMatchingTableExpectedRevenue);

        //verify they have same revenue
        Assert.assertTrue(secondRowSecondColumnExpectedRevenue.equals(listMatchingTableExpectedRevenue));
    }

    @Test  //(priority = 2)
    public void Test2() {
        CRMPage crmpage = new CRMPage();
        // 1.log in
        // 2.click CRM button
        // 3.click pivot icon
        // 4. click new and choose opportunity
        crmpage.getToOpportunity();

        // Verify that on the pivot table, the total expected revenue
        // should be the sum of all opportunities’ expected revenue.
        int sum=0;
        for(int i=3;i<=7;i++) {
            String totalRevenueLocator = Driver.getDriver().findElement(By.cssSelector(("table tbody tr:nth-of-type(") + (i) + (") td:nth-of-type(2)"))).getText().replaceAll("[^\\d]", "");
            int eachRevenue = Integer.parseInt(totalRevenueLocator);
            sum += eachRevenue;
        }

        String totalExpectedRevenuestr = crmpage.totalExpectedRevenueLocator.getText().replaceAll("[^\\d]", "" );//8,765.00
        int totalExpectedRevenue = Integer.parseInt(totalExpectedRevenuestr);
        System.out.println(sum);
        System.out.println(totalExpectedRevenue);
         Assert.assertTrue(sum==totalExpectedRevenue);


    }
}










//*
//        Verify that second opportunity’ Expected Revenue value on the
//        Pivot board should be the sameas the Expected revenue column value on the list board.
//
//        */

//    Verify that on the pivot table, the total expected revenue should be the sum of all opportunities’ expected revenue.
// 1.log in
// 2.click CRM button
// 3.click pivot icon
// 4. click new and choose opportunity
// 5.choose second row and second column /on list board it is first one
//verify they have same revenue

// Verify that on the pivot table, the total expected revenue should be the sum of all opportunities’ expected revenue.
//1. PreCondition- each CRM manager user should create at least 3 opportunities on the CRM module.
// (create 2 opportunity just in case)
// 2.Pre-condition two: on Pivot table expand total and select opportunity from the dropdown.
