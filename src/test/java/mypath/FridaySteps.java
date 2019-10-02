package mypath;

import java.util.List;

import bus.domain.MyBusDom;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;


public class FridaySteps {
	private MyBusDom domainData;
	public FridaySteps(MyBusDom domainData) {
		System.out.println("FridaySteps Being instatiated with " + domainData);
		this.domainData = domainData;
	}
	@Then(".*Hello.? Today is Tuesday (\\d+)/(\\d+)")
	public void today_is_Tuesday(int x, SimonsNumber y) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    System.out.println("Running today is tuesday. and x is: " + x
	    		+ " and y is " + y);
	}
	@Given("an? (banana|orange)")
	public void fruit(String fruit) {
		System.out.println("found " + fruit);
	}
	@Given("she (?:does not|doesn't) own a car")
	public void noCar() {
		System.out.println("No car...");
	}
	
	@Given("I have some things")
	public void things(List<ThingBuilder> ltb) {
//		List<Thing> lt = new ArrayList<>();
//		for (ThingBuilder tb : ltb) {
//			lt.add(tb.get());
//		}
//		lt.forEach(System.out::println);
		ltb.stream().map(ThingBuilder::get).forEach(System.out::println);
	}
	
	@Given("A message of (.*)")
	public void setMessage(String msg) {
		domainData.text.append(msg);
	}
}
