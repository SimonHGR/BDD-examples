package mypath;

import org.junit.Assert;

import bus.domain.MyBusDom;
import cucumber.api.java.en.Then;

public class MoreSteps {
	MyBusDom domain;
	public MoreSteps(MyBusDom domain) {
		System.out.println("in MoreSteps constructor with " + domain);
		this.domain = domain;
	}
	
	@Then("I should see the data (.*+)")
	public void verifyData(String data) {
		Assert.assertEquals("should be equal", data, domain.text.toString());
	}
}
