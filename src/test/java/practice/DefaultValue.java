package practice;

import org.testng.annotations.Test;

public class DefaultValue {
	
	String string;
	int a;
	char c;
	@Test
	public void defaultValue() {
		System.out.println(string);
		System.out.println(a);
		System.out.println((int)c);
	}

}
