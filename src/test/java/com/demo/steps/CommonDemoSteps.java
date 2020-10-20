package com.demo.steps;

import java.util.List;

import com.demo.page.DemoBlaze;

import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import net.serenitybdd.core.pages.PageObject;

public class CommonDemoSteps extends PageObject{
	
	DemoBlaze objDemoBlaze; 
	
	@Given("^I am on Demo online webpage$")
	public void openWebPage() {
		open();
	}
	
	
	@Given("^I added \"([^\"]*)\" to the cart$")
	public void addProductToCart(String prductName) {
		objDemoBlaze.addProductToCart(prductName);
	}
	@Given("^I navigated back to Home screen$")
	public void navigateToHomeScreen( ) {
		objDemoBlaze.navigateToHome();
	}
	
	@Given("^I navigate to cart screen$")
	public void navigateToCart( ) {
		objDemoBlaze.navigateToCart();
	}
	
	@Given("^I delete item from \"([^\"]*)\" row and \"([^\"]*)\" column$")
	public void deleteItemFromTable(String row, String col) {
		objDemoBlaze.removeItemFromCart(row, col);
	}
	
	@Given("^I click on \"([^\"]*)\" button$")
	public void clickOnButton(String buttonName) {
		objDemoBlaze.clickOnButton(buttonName);
	}
	
	@Given("^I fill the user form using$")
	public void fillTheForm(List<String> table) {
		objDemoBlaze.fillTheForm(table);
	}
	
	@Given("^I save total amount$")
	public void captureAmnt() {
		objDemoBlaze.getTotalAmnt();
	}
	
	@Given("^I capture LogId and assert total amount$")
	public void getLogAndAssertAmnt() {
		objDemoBlaze.getLogAndAssertAmnt();
	}
	
	
}
