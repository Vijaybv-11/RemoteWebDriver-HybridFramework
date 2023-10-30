package com.Banking.PageFactory;



import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.Banking.Utils.BaseClass;



public class BasePage extends BaseClass {
    /**
     *
     * @param driver
     * @author Vijay
     *
     */

    public BasePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

}