package pom;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utility.Parametrization;

public class SwagLabsLoginPage {

	@FindBy (xpath="//input[@id='user-name']") private WebElement userID;
	@FindBy (xpath="//input[@id='password']") private WebElement password;
	@FindBy (xpath="//input[@id='login-button']") private WebElement login;
	@FindBy (xpath="//div[@class='error-message-container error']") private WebElement errormsg;
	
	public SwagLabsLoginPage(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}
	
	public void enterUserID(int row,int cell) throws EncryptedDocumentException, IOException {
		userID.sendKeys(Parametrization.getExcelSheet(row, cell, "sheet1"));
	}
	
	public void enterPassword(int row,int cell) throws EncryptedDocumentException, IOException {
		password.sendKeys(Parametrization.getExcelSheet(row, cell,"sheet1"));
	}
	
	public void clickOnLogin() {
		login.click();
	}
	
	public String getErrorMsg() {
		String error1 = errormsg.getText();
		return error1;
	}
	
	
}
