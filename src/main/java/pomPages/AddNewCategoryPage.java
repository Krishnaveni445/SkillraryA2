package pomPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddNewCategoryPage {
	//Declaration
	@FindBy(xpath="//b[text()='Add New Category']")
	private WebElement pageHeader;
	
	@FindBy(xpath="//input[@id='name']")
	private WebElement nameTF;
	
	@FindBy(xpath="//button[@name='add']")
	private WebElement saveButton;
	
	@FindBy(xpath="(//input[@id=\"photo\"])[2]")
	private WebElement uploadPhotoButton;
	//Initialization
		public AddNewCategoryPage(WebDriver driver) {
			PageFactory.initElements(driver, this);
		}
		//Utilization
		public String getPageHeader() {
			return pageHeader.getText();
		}
		public void clickSave() {
		saveButton.click();
		}
		public void setName(String courseName) {
		nameTF.sendKeys(courseName);
	
		}
		public void uploadPhoto(String path) {
			uploadPhotoButton.sendKeys(path);
		}
		
		
}
