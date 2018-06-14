package com.test.task.QETestTask;

import org.testng.annotations.Test;

public class RemoveCustomerTest extends Base {
	
	HomePage homePage = new HomePage();
	AddCustomer addCustomer = new AddCustomer();
	RemoveCustomer removeCustomer = new RemoveCustomer();
	
	@Test(groups={"regression"})
	public void removeExistingCustomer() {
		
		homePage.clickAddCustomer();
		addCustomer.addCustomer("RemoveFirst", "RemoveLast", "1989-04-23", "111-111-1111", "new@address.com");
		addCustomer.verifyCustomerAdded();
		addCustomer.navigateToHomePage();
		homePage.clickRemoveCustomer();
		removeCustomer.removeCustomer("RemoveFirst", "RemoveLast", "1989-04-23");
		removeCustomer.verifyExistingCustomerRemoved();
	}
	
	@Test(groups={"regression"})
	public void removeNonExistingCustomer() {
		
		homePage.clickAddCustomer();
		removeCustomer.removeCustomer("RemoveFirstCust", "RemoveLastCust", "1989-04-23");
		removeCustomer.verifyNonExistingCustomerRemoved();
	}

}
