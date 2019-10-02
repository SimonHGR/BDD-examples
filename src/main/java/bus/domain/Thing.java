package bus.domain;

public class Thing {
	String name;
	String count;
	String other;
	public Thing(String name, String count, String other) {
		super();
		System.out.println("in Thing constructor...");
		this.name = name;
		this.count = count;
		this.other = other;
	}
	
	private Thing() {} // supports builder
	
	@Override
	public String toString() {
		return "Thing [name=" + name + ", count=" + count + ", other=" + other + "]";
	}
	
	public static Builder builder() { return new Builder(); }
	public static class Builder {
		private Thing self = new Thing(); // uninitialized...
		private Builder() {}
		public Builder name(String n) {
			self.name = n;
			return this;
		}
		public Builder count(String count) {
			self.count = count;
			return this;
		}
		public Builder other(String other) {
			self.other = other;
			return this;
		}
		
		public Thing build() {
			// validate the proposed object...
			if (self.name == null) throw new RuntimeException();
			// apply defaults
			if (self.count == null) self.count = "0";
			if (self.other == null) self.other = "unspecified";
			Thing retval = self;
			self = null; // don't let subsequent use of this builder work (will throw NPE)
			return retval;
		}
	}
	public static ModBuilder modifyableBuilder() { return new ModBuilder(); }
	public static class ModBuilder {
		private String name; //
		private String count;
		private String other;
		
		private ModBuilder() {}
		public ModBuilder name(String n) {
			this.name = n;
			return this;
		}
		public ModBuilder count(String count) {
			this.count = count;
			return this;
		}
		public ModBuilder other(String other) {
			this.other = other;
			return this;
		}
		
		public Thing build() {
			// validate the proposed object...
			if (this.name == null) throw new RuntimeException();
			// defaults applied at first initialization
			
			return new Thing(name, count, other);
		}
	}
}
