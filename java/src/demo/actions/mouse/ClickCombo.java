package demo.actions.mouse;

import com.sahipro.lang.java.client.Browser;
import com.sahipro.lang.java.client.SahiCapabilities;

public class ClickCombo {
	
	Browser b = null;
	 
	public ClickCombo(SahiCapabilities modes) {
		this.b = modes.getBrowser();
	}
	
	public void click(String combo, String expected) {
		b.click(b.div("Experiment Zone"), combo);
		b.assertText(b.textbox("tb"), expected);
		b.areEqual(expected, b.textbox("tb").value());
	}
	
	public void navigateTo() {
		String baseURL = "http://sahitest.com/";
		b.navigateTo(baseURL + "/demo/clickCombo.htm");
	}
	
	public void tearDown() {
		navigateTo();
		b.setValue(b.textbox("tb"), "");
	}
	
	public void testNormalClick() {
		navigateTo();
		click(null, "click");
	}

	public void testCtrlClick() {
		navigateTo();
		click("CTRL", "<ctrl>click");
	}
	
	public void  testAltClick() {
		navigateTo();
		click("ALT", "<alt>click");
	}

	public void  testShiftClick() {
		navigateTo();
		click("SHIFT", "<shift>click");
	}

	public void  testMetaClick() {
		navigateTo();
		click("META", "<meta>click");
	}

	public void  testCombinationClicks() {
		navigateTo();
		click("CTRL|ALT", "<ctrl><alt>click");
		click("CTRL|SHIFT", "<ctrl><shift>click");
		click("ALT|SHIFT", "<alt><shift>click");
		click("SHIFT|ALT", "<alt><shift>click");
		click("CTRL|ALT|SHIFT", "<ctrl><alt><shift>click");
	}
	
}
