/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PageObject;

import java.util.Random;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

/**
 *
 * @author DiamondStalker
 */
public class PIM_edit {
    WebDriver driver;
    
    By btnSave = By.id("btnSave");
    By Marital = By.id("personal_cmbMarital");
    By Nation = By.id("personal_cmbNation");
    By RFemale = By.id("personal_optGender_2");
    By RMale = By.id("personal_optGender_1");
    By Birth = By.id("personal_DOB");
    By ID = By.id("personal_txtEmployeeId");
    
    public PIM_edit(WebDriver driver){
        this.driver = driver;
    }
    public void clickMale(){
        driver.findElement(RMale).click();
    }
    public String getidemployee(){
        WebElement TxtBoxContent = driver.findElement(ID);
        String id = TxtBoxContent.getText();
        return id;
    }
    public void clickFemale(){
        driver.findElement(RFemale).click();
    }
    public void setselectMarital(int numero){
        WebElement cmb_marital = driver.findElement(Marital);
        Select marital = new Select(cmb_marital);
        if(numero == 1) marital.selectByVisibleText("Single");
        if(numero == 2) marital.selectByVisibleText("Married");
        if(numero == 3) marital.selectByVisibleText("Other");
    }
    public void setselectNation(int numero){
        WebElement cmb_marital = driver.findElement(Nation);
        Select nation = new Select(cmb_marital);
        nation.selectByIndex(numero);
    }
    public void setBirth(String date){
        driver.findElement(Birth).sendKeys(date);
    }
    public void clearBirth(){
        driver.findElement(Birth).clear();
    }
    public String Date(){
        Random rnd = new Random();
        /** Año **/
        String yyyy = Integer.toString(rnd.nextInt((2120-1920)+1)+ 1920);
        /** Dia **/
        String dd = Integer.toString(rnd.nextInt(31)+ 1);
        /** Mes **/
        String mm = Integer.toString(rnd.nextInt(12)+ 1);
      
        
        System.out.println("La fecha es :" + yyyy);
        System.out.println("La mm es :" + mm);
        System.out.println("La dd es :" + dd);
        
        String date = yyyy;
        if(mm.length() == 1) date += "-0" + mm;
        else date += "-" + mm;
        
        if(dd.length() == 1) date += "-0" + dd;
        else date += "-" + dd;

        System.out.println("La fecha es : " + date);
        return date;
    }
}
