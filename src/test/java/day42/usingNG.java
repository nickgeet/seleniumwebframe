package day42;

import org.testng.annotations.Test;

public class usingNG {
	@Test(priority=1)
	void openApp() {
		System.out.println("Run app");
	}
	@Test(priority=2)
	void closeApp() {
		System.out.println("App closed");
	}

}
