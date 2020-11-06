/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


/**
 *
 * @author DiamondStalker
 */
public class PIM {
    WebDriver driver;
    By PIM = By.id("menu_pim_viewPimModule");
    By addEmployee = By.id("menu_pim_addEmployee");
    
    By firstName = By.id("firstName");
    By middleName = By.id("middleName");
    By lastName = By.id("lastName");
    
    By btnSave = By.id("btnSave");
    
    
    
    
    public PIM(WebDriver driver){
        this.driver = driver;
    }
    public void setfirstName(String fname){
        driver.findElement(firstName).sendKeys(fname);
    }
    public void setmiddleName(String mname){
        driver.findElement(middleName).sendKeys(mname);
    }
    public void setlastName(String lname){
        driver.findElement(lastName).sendKeys(lname);
    }
    public void clickPIM(){
        driver.findElement(PIM).click();
    }
    public void clickaddEmployee(){
        driver.findElement(addEmployee).click();
    }
    public void clickbtnSave(){
        driver.findElement(btnSave).click();
    }
    
    public void addemployee(String firtname,String middleName,String lastName){
        this.setfirstName(firtname);
        this.setmiddleName(middleName);
        this.setlastName(lastName);
        this.clickbtnSave();
    }
}
