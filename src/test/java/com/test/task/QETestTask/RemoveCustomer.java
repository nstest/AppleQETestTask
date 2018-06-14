package com.test.task.QETestTask;

import org.openqa.selenium.By;
import org.testng.Assert;

import ru.yandex.qatools.allure.annotations.Step;

public class RemoveCustomer extends Base {

	@Step("Remove a customer")
	public void removeCustomer(String firstName, String lastName, String birthDate) {
		
		driver.findElement(By.id("firstName")).sendKeys(firstName);
		driver.findElement(By.id("lastName")).sendKeys(lastName);
		driver.findElement(By.id("birthDate")).sendKeys(birthDate);
		driver.findElement(By.id("submit")).click();
	}

	@Step("Verify if the customer is removed")
	public void verifyExistingCustomerRemoved() {
		Assert.assertTrue(driver.findElement(By.className("message"))
				.isDisplayed()
				&& driver.findElement(By.className("message")).getText()
						.contains("Customer removed from the database"),
				"Customer details removed successfully");
		
	}

	@Step("Verify if the customer is not removed")
	public void verifyNonExistingCustomerRemoved() {
		Assert.assertTrue(driver.findElement(By.className("message"))
				.isDisplayed()
				&& driver.findElement(By.className("message")).getText()
						.contains("Customer does not exist in the database. No record has been removed"),
				"Customer details were not removed since the customer does not exist");
		
	}

}
