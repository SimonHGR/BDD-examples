package mypath;

import bus.domain.Thing;

public class ThingBuilder {
	String name;
	String count;
	String other;
	
	public Thing get() {
		return new Thing(
		(name != null ? name : "Uninitialized"),
		(count != null ? count : "Uninitialized"),
		(other != null ? other : "Uninitialized")
				);
	}
}
