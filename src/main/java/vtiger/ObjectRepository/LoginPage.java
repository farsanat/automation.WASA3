package vtiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	
		//rule1:create pom class for every web page
		//rule2:identify the webelements with @findBy,@findAll and findBys
		@FindBy(name ="username") private WebElement UsernameEdt;
		
		@FindAll({@FindBy(name="password"),@FindBy(xpath="//input[@type='password']")})private WebElement PasswordEdt;
		
		@FindBy(xpath="//button[text()='Sign in']") private WebElement SubmitBtn;
		 
         
	//rule3:create a constructor to initialize these web elements
		public LoginPage(WebDriver driver)
		{
			PageFactory.initElements(driver,this);
		}
		//rule4:provide getters to access these elements


		public WebElement getUsernameEdt()
		{
			return UsernameEdt;
		}


		public WebElement getPasswordEdt() 
		{
			return PasswordEdt;
		}


		
        public WebElement getSubmitBtn() 
        {
			return SubmitBtn;
		}

//business libraries-generic methods specific to current project
        public void loginToApp( String username,String password)
        {
        UsernameEdt.sendKeys(username);
        PasswordEdt.sendKeys(password);
        
        }
        public void clicksubmit()
        {
        	SubmitBtn.click();
        }
		
		

}
