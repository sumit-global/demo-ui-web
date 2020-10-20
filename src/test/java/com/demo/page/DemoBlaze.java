package com.demo.page;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;

public class DemoBlaze extends PageObject {

	@FindBy(css = ".list-group [onclick*='notebook']")
	private WebElementFacade laptop;

	@FindBy(css = ".navbar-brand")
	private WebElementFacade homescreen;

	@FindBy(xpath = "//*[text()='Add to cart']")
	private WebElementFacade addToCart;

	@FindBy(xpath = "//*[text()='Cart']")
	private WebElementFacade goToCart;

	private org.openqa.selenium.By fill = By.cssSelector("[class='modal fade show'] input");

	@FindBy(css = "[class='modal fade show'] input")
	private WebElementFacade fillForm;
	
	@FindBy(css = "[class='lead text-muted ']")
	private WebElementFacade getOrderInfo;
	
	@FindBy(css = "#totalp")
	private WebElementFacade totalAmt;
	
	private String totalAmount =null;
	private String logId=null;
	private Map<String,String> values = new HashMap<String,String>();
	
	

	public void addProductToCart(String productName) {
		laptop.waitUntilVisible().click();
		WebElementFacade ele = waitFor(getDriver().findElement(By.xpath("//*[text()='" + productName + "']")));
		ele.waitUntilVisible().click();
		addToCart.waitUntilVisible().click();
		waitFor(ExpectedConditions.alertIsPresent());
		getDriver().switchTo().alert().accept();
	}

	public void navigateToHome() {
		homescreen.waitUntilVisible().click();
	}

	public void navigateToCart() {
		goToCart.waitUntilVisible().click();
	}

	public void removeItemFromCart(String row, String col) {

		WebElementFacade ele = waitFor(getDriver().findElement(By.xpath("//tbody/tr[" + row + "]/td[" + col + "]/a")));
		ele.waitUntilVisible().click();
		ele.waitUntilNotVisible();
	}

	public void clickOnButton(String buttonName) {
		WebElementFacade ele = waitFor(getDriver().findElement(By.xpath("//*[text()='" + buttonName + "']")));
		ele.waitUntilVisible().click();
	}

	public void fillTheForm(List<String> table) {
		List<WebElementFacade> ele = findAll(fill);

		for (int i = 0; i < ele.size(); i++) {
			ele.get(i).waitUntilVisible().type(table.get(i));
		}
	}
	
	public void getTotalAmnt() {
		totalAmount = totalAmt.waitUntilVisible().getText();
	}
	
	public void getLogAndAssertAmnt() {
		String amount = getOrderInfo.waitUntilVisible().getText();
		String[] values = amount.split("\n");
		
		for(String val:values) {
			this.values.put(val.split(":")[0].trim(), val.split(":")[1].trim());
		}
			Assert.assertTrue(this.values.get("Amount").split(" ")[0].equalsIgnoreCase(totalAmount));	
	}

}
