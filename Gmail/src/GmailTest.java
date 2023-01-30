import java.io.File;
import java.io.FileReader;
import java.util.Properties;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class GmailTest {

	private  WebDriver driver;
	private Properties properties = new Properties();
	private String username = null;
	private String password = null;
	private String mailSubject = "TestMail";
	private String mailBody = "TestMail Body";

   
	
    @BeforeTest
	public void setUp() throws Exception {
		
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		properties.load(new FileReader(new File("test.properties")));
		username = properties.getProperty("username");
		password = properties.getProperty("password");
		
		 
	}

	@AfterTest
	public void tearDown() throws Exception {
		driver.quit();
	}

	@Test
	public void testSendEmail() throws Exception {
		GmailMethods email=new GmailMethods(driver);
		driver.get("https://gmail.com");
		email.SignIn(username, password);
		email.ComposeMail(mailSubject, mailBody,username+"@gmail.com");
		email.OpenMail();
		
	    Assert.assertTrue(email.VerifySubject(mailSubject));
	    Assert.assertTrue(email.VerifyLabel());
	    Assert.assertTrue(email.VerifyBody(mailBody));
        
		
	}
}