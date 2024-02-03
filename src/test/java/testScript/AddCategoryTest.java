package testScript;

import java.util.Map;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import genericUtilities.BaseClass;
import genericUtilities.IConstantPath;
//This test is used to add category to the application
public class AddCategoryTest extends BaseClass {
	@Test
	public void addCategoryTest() {
		SoftAssert soft = new SoftAssert();
		
		home.clickCoursesTab();
		home.clickCategoryLink();
		soft.assertEquals(category.getPageHeader(), "Category");
		
		category.clickNewButton();
		soft.assertEquals(addCategory.getPageHeader(), "Add New Category");
		Map<String, String> map = excel.readFromExcel("Add Category");
		addCategory.setName(map.get("Name"));
		addCategory.clickSave();
		
		soft.assertEquals(category.getSuccessMessage(), "Success!");
		System.out.println(category.getSuccessMessage());
		category.deleteCategory(web, map.get("Name"));
		soft.assertEquals(category.getSuccessMessage(), "Success!");
		if(category.getSuccessMessage().equals("Success!"))
			excel.updateTestStatus("Add Category", "Pass", IConstantPath.EXCEL_PATH);
		else
			excel.updateTestStatus("Add Category", "Fail", IConstantPath.EXCEL_PATH);
		
		soft.assertAll();
		}
}
