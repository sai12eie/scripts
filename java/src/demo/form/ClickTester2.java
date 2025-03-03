package demo.form;

import com.sahipro.lang.java.client.Browser;
import com.sahipro.lang.java.client.SahiCapabilities;
import com.sahipro.lang.java.client.SahiMarkerInterface;

public class ClickTester2 implements SahiMarkerInterface {
	
	Browser b = null;


	public ClickTester2(SahiCapabilities modes) {
		this.b = modes.getBrowser();
	}

	public void click(){
		String baseURL = "http://sahitest.com/";
		b.navigateTo(baseURL + "/demo/formTest.htm");
		b.checkbox("c1").assertExists();
	    b.checkbox("c1").click();
	    b.checkbox("c1").assertChecked();
	    b.isTrue(b.checkbox("c1").fetch("checked").equals("true"));
	    b.checkbox("c1").click();
	    b.areEqual("false", b.checkbox("c1").fetch("checked"));
	    
	    b.radio("r1").assertExists();;
	    b.radio("r1").click();
	    b.areEqual("true", b.radio("r1").fetch("checked"));
	    b.radio("r1").assertChecked();;
	    b.radio("r1[1]").assertNotChecked();;
	    b.radio("r1[1]").click();
	    b.areEqual("false", b.radio("r1").fetch("checked"));
	    b.isTrue(b.radio("r1[1]").checked());
	    b.isFalse(b.radio("r1").checked());
	}


}
