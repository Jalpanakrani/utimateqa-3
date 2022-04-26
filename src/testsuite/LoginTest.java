package testsuite;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.Utility;

public class LoginTest extends Utility {
    String baseUrl = "https://courses.ultimateqa.com/";

    @Before
    public void setup(){
        openBrowser(baseUrl);
    }

    @Test
    public void verifyUserShouldNavigateToLoginPageSuccessfully(){
        //find sign in link and click on SignInButton
        clickOnElement(By.linkText("Sign in"));
        //This is from requirement
        String expectedMessage = "Welcome Back!";

        //find the welcome back text element and get the text
        String actualMessage = getTextFromElement(By.xpath("//h1[contains(text(),'Welcome Back!"));
        //validate actual and expected message

        Assert.assertEquals("Not navigate to login page", expectedMessage, actualMessage);
    }

    @Test
    public void verifyErrorMessageWithInvalidCredentials(){
        //Find Sign in link and click on sign in link
        clickOnElement(By.linkText("Sign in"));
        //Enter invalid username
        clickOnElement(By.name("user[email]"));
        // Find the invalid password field element
        clickOnElement(By.name("user[password]"));
        //Sending invalid Password to password field element
        sendTextToElement(By.name("user[password]"),"jalpa123");
        //Find the login button and click on it
        clickOnElement(By.xpath("//body/main[@id='main-content']/div[1]/div[1]/article[1]/form[1]/div[4]/input[1]"));
        //This is from requirement
        String expectedMessage = "Invalid email or password.";
        //invalid email or password text element and get the text
        String actualMessage = getTextFromElement(By.xpath("//li[contains(text(),'Invalid email or password.')]"));
        //validate actual and expected message
        org.junit.Assert.assertEquals("Not navigate to login page", expectedMessage, actualMessage);
        String expectedErrorMessage = "Login was unsuccessful. Please correct the errors and try again.\n"
                + "No customer account found";
    }

    @After
    public void tearDown(){
        closeBrowser();
    }
}

