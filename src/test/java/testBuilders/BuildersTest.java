package testBuilders;

import org.junit.Test;

import bus.domain.Thing;
import org.junit.Assert;

public class BuildersTest {
	@Test
	public void simpleBuilderMakesObjects() {
		Thing t = Thing.builder().name("Fred").count("2").other("Jones").build();
		Assert.assertEquals(t.toString(), "Thing [name=Fred, count=2, other=Jones]");
	}

	@Test
	public void simpleBuilderDefaults() {
		Thing t = Thing.builder().name("Fred").build();
		Assert.assertEquals(t.toString(), "Thing [name=Fred, count=0, other=unspecified]");
	}

	@Test(expected=RuntimeException.class)
	public void simpleBuilderFails() {
		Thing t = Thing.builder().build();
	}

	@Test(expected=RuntimeException.class)
	public void reuseFails() {
		Thing.Builder tb = Thing.builder().name("Fred");
		tb.build();
		tb.build();
	}
	
	@Test
	public void reusableWorks() {
		Thing t = Thing.modifyableBuilder().name("Fred").count("2").other("Jones").build();
		Assert.assertEquals(t.toString(), "Thing [name=Fred, count=2, other=Jones]");
	}
	
	@Test
	public void makesNewDistinctObjects() {
		Thing.ModBuilder mtb = Thing.modifyableBuilder().name("Fred").count("2").other("Jones");
		Thing t1 = mtb.build();
		Assert.assertEquals(t1.toString(), "Thing [name=Fred, count=2, other=Jones]");
		Thing t2 = mtb.build();
		Assert.assertEquals(t2.toString(), "Thing [name=Fred, count=2, other=Jones]");
		Assert.assertNotSame(t1, t2);
	}
	
	@Test
	public void makesVariations() {
		Thing.ModBuilder mtb = Thing.modifyableBuilder().name("Fred").count("2").other("Jones");
		Thing t1 = mtb.build();
		mtb.name("Jim");
		Thing t2 = mtb.build();
		Assert.assertEquals(t1.toString(), "Thing [name=Fred, count=2, other=Jones]");
		Assert.assertEquals(t2.toString(), "Thing [name=Jim, count=2, other=Jones]");
		Assert.assertNotSame(t1, t2);
		
	}
}
