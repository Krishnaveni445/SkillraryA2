package pomPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	//Declaration
	@FindBy(xpath="//a[text()=' Home']")
	private WebElement pageHeader;
	
	@FindBy (xpath="//span[text()='Users']")
	private WebElement usersTab;
	
	@FindBy (xpath="//span[text()='Courses']")
	private WebElement coursesTab;
	
	@FindBy (xpath="//a[text()=' Course List']")
	private WebElement courseListlink;
	
	@FindBy(xpath="//a[text()=' Category']")
	private WebElement categorylink;
	
	@FindBy(xpath="//span[text()='SkillRary Admin']")
	private WebElement skillraryAdminIcon;
	
	@FindBy(xpath="//a[text()='Sign out']")
	private WebElement signoutLink;
	
	//Initialization
	public  HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	//utilization
	public String getPageHeader() {
		return pageHeader.getText();
	}
	public void clickUsersTab() {
		usersTab.click();
	}
	public void clickCoursesTab() {
		coursesTab.click();
	}
	public void clickCourseListLink() {
		courseListlink.click();
	}
	public void clickCategoryLink() {
		categorylink.click();
	}
	public void signoutLink() {
		skillraryAdminIcon.click();
		signoutLink.click();
	}
}
