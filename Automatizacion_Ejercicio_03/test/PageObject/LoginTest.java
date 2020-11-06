/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PageObject;

import java.util.Random;
import java.util.concurrent.TimeUnit;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Sleeper;

/**
 *
 * @author user
 */
public class LoginTest {

    private static WebDriver driver = null;
    
    Random rnd = new Random();
    
    Login Loggin;
    PIM pim;
    PIM_edit pimedit;
    
    public static void sleep(){
       try {
           Thread.sleep(1000);
       } catch (Exception e) {
       }
    }

    @BeforeClass
    public static void setUpClass() {
        System.setProperty("webdriver.chrome.driver", "drivers\\chromedriver.exe");
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://opensource-demo.orangehrmlive.com/index.php/pim/viewMemberships/empNumber/42");
        Loggin = new Login(driver);
        pim = new PIM(driver);
        pimedit = new PIM_edit(driver);
    }

    @After
    public void tearDown() {
        driver.quit();
    }

    /**
     * Test of setUserName method, of class Login.
     */
    /*@Test
    public void TestlogginFail() {
        String username = "admin";
        String password = "admin123";
        Loggin.Loggin(username);
        String Message = Loggin.GetMessage();
        assertEquals("NO ingreso la contraseña", "", "Password cannot be empty");
    }
*/
    @Test
    public void TestlogginPass() {
        
        /**
         * Loggin
         */
        String username = "Admin";
        String password = "admin123";
        Loggin.Loggin(username,password);
        
        /**
         * Add employee
         */
        pim.clickPIM();
        sleep();
        pim.clickaddEmployee();
        
        String Fname = "Diamond";
        String Mname = "";
        String Lname = "Stalker";
        sleep();
        pim.addemployee(Fname, Mname, Lname);
        sleep();
        
        pim.clickbtnSave();
        sleep();
        
        
        /**
         * Add employee
         */
        
        String id = pimedit.getidemployee();
        System.out.println("El id del usuario creado es : " + id);
        System.out.println("---La id del empleado es : " + pimedit.getidemployee());
        int randomNum = rnd.nextInt(2) + 1;
        if(randomNum == 1)pimedit.clickMale();
        else pimedit.clickFemale();
        
        /** Single married other**/
        
        int Marital = rnd.nextInt(3)+ 1;
        pimedit.setselectMarital(Marital);
        sleep();
        /**Nation**/
        int Nation = rnd.nextInt(193)+ 1;
        pimedit.setselectNation(Nation);
        sleep();
        /** DATE**/
        String Date = pimedit.Date();
        pimedit.clearBirth();
        sleep();
        pimedit.setBirth(Date);
        pim.clickbtnSave();
        sleep();sleep();sleep();sleep();
    }
}
