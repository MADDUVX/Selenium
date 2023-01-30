import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PageObjects {
	
	PageObjects(WebDriver driver){
		PageFactory.initElements(driver,this);
	 	}


	@FindBy(id="identifierId")
	WebElement UserName_TextBox;
		
	@FindBy(id="identifierNext")
	WebElement UserName_Next;
	
	@FindBy(name="Passwd")
	WebElement Passwd_TextBox;
	
	@FindBy(id="passwordNext")
	WebElement Passwd_Next;
	
	@FindBy(css=".T-I.T-I-KE.L3")
	WebElement Compose;
	
	
	@FindBy(css="input.agP.aFw")
	WebElement Email_To;
	
	@FindBy(name="subjectbox")
	WebElement Email_Subject;
	
	
	@FindBy(css="td.Ap div:nth-child(2)")
	WebElement Email_Body;	
	
	@FindBy(xpath="//div[@aria-label='More options']")
	WebElement Option_Label;
	
	@FindBy(css="div.J-Ph")
	WebElement Label_Selector;
	
	@FindBy(xpath="//input[@ignoreesc='true']")
	WebElement Social_Label;
	
	@FindBy(css="td.gU.Up")
	WebElement Send_Btn;
		
	@FindBy(xpath="//a[text()='Inbox']")
	WebElement Mail_Inbox;
	
	@FindBy(css="td.apU.xY")
	WebElement Starred_Mail;
	
	@FindBy(css="table:nth-child(1) > tbody:nth-child(2) > tr:nth-child(1)>td:nth-child(5)")
	WebElement Select_Mail;
	
	@FindBy(css=".ha>h2:nth-child(1)")
	WebElement Verify_Subject;
	
	@FindBy(css="div.gs>div:last-child")
	WebElement Verify_Body;
	
	@FindBy(xpath="//div[@class='G-Ni J-J5-Ji']/div[2]")
	WebElement Label_Verify;
	
	@FindBy(xpath="//div[@class='J-M-Jz aiL']/div[1]")
	WebElement Social_Verify;			
	
	@FindBy(xpath="(//div[@class='G-Ni J-J5-Ji'])[3]")
	WebElement Refresh;
	
}
