package testNGDataProvider;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestNGDataProvider {

	@DataProvider(name = "test-data")
	public static Object[][] dataProvFunc() {
		return new Object[][] { { "Lambda Test" }, { "Automation" } };
	}

	// handel dataProvider
	@DataProvider(name = "simpleTest1")
	public Object[][] getData1(){
		return new Object[][]{{"test1","test2"},{"test3","test4"},{"test5","test6"}};
	}
	@DataProvider(name = "simpleTest2")
	public Object[][] getData2(){
		return new Object[][]{{"test1"},{"test3"},{"test5"}};
	}
	@DataProvider(name = "simpleTest3")
	public String[][] getData3(){
		return pages.PageBase.readExcelData("Sheet1");
	}
	@Test(dataProvider = "simpleTest1",enabled = false)
	public void test1(String name,String value){
		System.out.println(name+"   "+value);
	}
	@Test(dataProvider = "simpleTest2",enabled = false)
	public void test2(String name){
		System.out.println(name);
	}
	@Test(dataProvider = "simpleTest3")
	public void test3(String name,String value){
		System.out.println(name+"   "+value);
	}

}
