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
public class Login {
    WebDriver driver;
    By User = By.id("txtUsername");
    By txtPassword = By.id("txtPassword");
    By Loggin = By.id("btnLogin");
    By spanMessage = By.id("spanMessage");
   
    public Login(WebDriver driver){
        this.driver = driver;
    }
    public void setUserName(String user){
        driver.findElement(User).sendKeys(user);
    }
    public void setpassword(String passw){
        driver.findElement(txtPassword).sendKeys(passw);
    }
    public void ClickLoggin(){
        driver.findElement(Loggin).click();
    }
    public String GetMessage(){
        String message = driver.findElement(spanMessage).getText();
        return message;
    }
    public void Loggin(String username,String Password){
        this.setUserName(username);
        this.setpassword(Password);
        this.ClickLoggin();
    }
}
