package demo.training;


import com.sahipro.lang.java.client.Browser;
import com.sahipro.lang.java.client.SahiCapabilities;
import com.sahipro.lang.java.client.SahiMarkerInterface;

public class UserModule implements SahiMarkerInterface {
	Browser b = null;
 	
	public UserModule(SahiCapabilities modes) {
		this.b = modes.getBrowser();
	}

	public void login(String username, String password) {
		String baseURL = "http://sahitest.com/";
		b.navigateTo(baseURL + "/demo/training/login.htm");

		b.textbox("user").setValue(username);
		b.password("password").setValue(password);
		
		checkAssertionsOnLoginPage();
		
		b.click(b.submit("Login"));
//		System.out.println("UserModule ClassLoader:   "+UserModule.class.getClassLoader());
	}

	private void checkAssertionsOnLoginPage() {
		// browser level
		b.assertVisible(b.textbox("user"));
		b.assertValue(b.textbox("user"),"test");
		b.assertText(b.submit("Login"), "Login");
		b.assertContainsText(b.submit("Login"), "/Log/");
		b.assertNotContainsText(b.submit("Login"), "xxxx", "Should Pass");
		
		//element level
		b.textbox("user").assertVisible();
		b.textbox("user").assertValue("test");
		b.textbox("user").assertVisible();
		b.submit("Login").assertContainsText("Login");
		b.submit("Login").assertText("Login");
	}
	
	public int addBooks(int java, int ruby, int python) {	
		int total = java*300 + ruby*200 + python*350;
		b.setValue(b.textbox("q").near(b.cell("Core Java")), java+"");
		b.setValue(b.textbox("q").near(b.cell("Ruby for Rails")), ruby+"");
		b.setValue(b.textbox("q").near(b.cell("Python Cookbook")), python+"");
		b.click(b.button("Add"));
		return total;
	}

	public void verifyTotal(int total) {
		b.areEqual(total+"", b.textbox("total").getValue());
	}
	
	public void logout() {
		b.click(b.button("Logout"));
	}
	
	public void verifyNotLoggedIn() {
		b.assertExists(b.textbox("user"));
	}
	
	public void verifyErrorMessage(String message) {
		b.assertVisible(b.div("errorMessage"));
		b.assertText(b.div("errorMessage"), message);
		b.areEqual(message, b.getText(b.div("errorMessage")));
	}
	
	public void testSpecialCharacters() throws Exception {
		String baseURL = "http://sahitest.com/";
		b.navigateTo(baseURL + "/demo/training/login.htm");
		b.textbox(0).setValue("This ~ !s @ #test f$r %Special_char (2%2=0 1^1 1&1 2*2=4 2-2=0 2+2=4)");
		b.textbox(0).assertText("This ~ !s @ #test f$r %Special_char (2%2=0 1^1 1&1 2*2=4 2-2=0 2+2=4)");
		b.textbox(0).setValue("[\"Sahi 'Pro'\" {Tyto} | Version:7.0.0 Pro,Plus; <Special\\char>] / tesing ?");
		b.textbox(0).assertText("[\"Sahi 'Pro'\" {Tyto} | Version:7.0.0 Pro,Plus; <Special\\char>] / tesing ?");
	}

}
