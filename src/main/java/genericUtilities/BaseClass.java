package genericUtilities;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import pomPages.AddNewCategoryPage;
import pomPages.AddNewCoursePage;
import pomPages.AddNewUsersPage;
import pomPages.CategoryPage;
import pomPages.HomePage;
import pomPages.LoginPage;
import pomPages.UsersPage;
import pomPages.courseListPage;

public class BaseClass {
	protected WebDriver driver;
	protected propertiesUtility property;
	protected JavaUtility jutil;
	protected WebDriverUtility web;
	protected ExcelUtility excel;
	
	protected LoginPage login;
	protected HomePage home;
	protected UsersPage users;
	protected courseListPage courseList;
	protected CategoryPage category;
	protected AddNewCategoryPage addCategory;
	protected AddNewCoursePage addCourse;
	protected AddNewUsersPage addUser;
	
	public static WebDriver sdriver;
	public static JavaUtility sjutil;
	//@BeforeSuite
	//@BeforeTest
	
	@BeforeClass
	public void classSetuo() {
		web = new WebDriverUtility();
		jutil = new JavaUtility();
		property = new propertiesUtility();
		excel = new ExcelUtility();
		
		property.propertiesInit(IConstantPath.PROPERTIES_FILE_PATH);
		
		driver = web.LaunchBrowser(property.readFromProperties("browser"));
		web.waitTillElementFound(Long.parseLong(property.readFromProperties("timeouts")));
		sdriver =driver;
		sjutil =jutil;
	}
		
		@BeforeMethod
		public void methodSetup() {
			login = new LoginPage(driver);
			home = new HomePage(driver);
			users = new UsersPage(driver);
			category = new CategoryPage(driver);
			courseList = new courseListPage(driver);
			addCourse = new AddNewCoursePage(driver);
			addUser = new AddNewUsersPage(driver);
			addCategory = new AddNewCategoryPage(driver);
			
			excel.excelInit(IConstantPath.EXCEL_PATH, "Sheet1");
			
			web.navigateToApp(property.readFromProperties("url"));
			Assert.assertEquals(login.getPageHeader(), "Login");
			login.loginToApp(property.readFromProperties("username"),property.readFromProperties("password"));
			Assert.assertEquals(home.getPageHeader(), "Home");
		}
		
		@AfterMethod
		public void methodTearDown() {
			excel.closeExcel();
			home.signoutLink();
		}
		
		@AfterClass
		public void classTearDown() {
			web.quitAllWindows();
		}
		
		//@AfterTest
		//@AfterSuite
	}

