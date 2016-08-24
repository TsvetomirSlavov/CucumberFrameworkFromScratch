package com.thetestroom.cucumber_project;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import util.WaitTool;

public class myFirstStepDefinition{
	
	WebDriver driver;
	
	
	@Given("^I navigate to TheTestRoom\\.com$")
	public void i_navigate_to_TheTestRoom_com() throws Throwable {
		System.out.println("Going to TheTestRoom.com");
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		//driver.manage().timeouts().pageLoadTimeout(15,TimeUnit.SECONDS);
		driver.navigate().to("http://www.thetestroom.com");
	}
	
	@When("^I navigate to Cucumber Tutorial page$")
	public void i_navigate_to_Cucumber_Tutorial_page() throws Throwable{
		System.out.println("Clicking on the cucumber tutorail page");
		driver.findElement(By.linkText("Java Cucumber Tutorial")).click();		
	}
	
	@Then("^the page title should be visible$")
	public void the_page_title_should_be_visible() throws Throwable{
		System.out.println("Cheking page title");
		//WaitTool class copied from github wtbox waitForElementPresent means only dom not visible and the tile tag is only inside the dom
		//Works for what the job is but not for this case still the browserser is with a second slower than it gets the page title
		//WaitTool.waitForElementPresent(driver, By.tagName("title"), 20);
		//Thread sleep works it gives me the correct second title but I need a better solution
		//Thread.sleep(1000);
		//This works but we do not have to mix them we have to call again after that the implisitlywait
		//here nullify implicitly wait
		driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
		WebDriverWait wait = new WebDriverWait(driver, 15);
		wait.until(ExpectedConditions.titleContains("Java Cucumber Tutorial - The Test Room"));
		System.out.println(driver.getTitle());
		//here restore implicitly wait
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.quit();
	}
	
	
	
	
	
	
	
	
	
	
	
	
}