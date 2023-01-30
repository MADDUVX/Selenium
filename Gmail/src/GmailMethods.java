import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class GmailMethods {

	GmailActions actions;
	PageObjects obj;
	
	GmailMethods(WebDriver driver){

		 actions=new GmailActions(driver);
		 obj =new PageObjects(driver);
	}
	
	
	
	public void SignIn(String Username,String Password) {
		actions.SendKeys(obj.UserName_TextBox,Username);
		actions.Click(obj.UserName_Next);
		actions.SendKeys(obj.Passwd_TextBox,Password);
		actions.Click(obj.Passwd_Next);
		
	}
	
	public void ComposeMail(String subject, String body, String Mail_To) {
		actions.Click(obj.Compose);
		actions.SendKeys(obj.Email_To, Mail_To);
		actions.SendKeys(obj.Email_To, Keys.ENTER);
		actions.SendKeys(obj.Email_Subject, subject);
		actions.buildActions(obj.Email_Body, body);
		actions.Click(obj.Option_Label);
		actions.Click(obj.Label_Selector);
		actions.SendKeys(obj.Social_Label, "Social");
		actions.SendKeys(obj.Social_Label, Keys.ENTER);
		actions.Click(obj.Send_Btn);
			
	}
	
	public void OpenMail() {
		
		actions.Click(obj.Mail_Inbox);
		actions.Click(obj.Refresh);
		actions.Click(obj.Starred_Mail);
		actions.Click(obj.Select_Mail);
	}
	
	public boolean VerifySubject(String subject) {
		
		return actions.VerifyText(obj.Verify_Subject, subject);
		
	}
	
public boolean VerifyBody(String body) {
		
		return actions.VerifyText(obj.Verify_Body, body);
		
	}
	
	public boolean VerifyLabel() {
		actions.Click(obj.Label_Verify);
		return actions.VerifyText(obj.Social_Verify, "Social")&&
				actions.VerifyLabelSelected(obj.Social_Verify);
		
	}
	
	

}
