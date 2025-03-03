package demo.links;

import com.sahipro.lang.java.client.Browser;
import com.sahipro.lang.java.client.SahiCapabilities;
import com.sahipro.lang.java.client.SahiMarkerInterface;

public class TestLinks implements SahiMarkerInterface {
	
	Browser b = null;

	public TestLinks(SahiCapabilities modes) {
		this.b = modes.getBrowser();
	}
	
	public void navigateTo() {
		String baseURL = "http://sahitest.com/";
		b.navigateTo(baseURL + "/demo/index.htm");
	}
	
	public void testLinks() {
		navigateTo();
		b.link("Link Test").click();
		b.link("linkByContent").click();
		b.link("Back").click();
		b.link("link with return true").click();
		b.assertExists(b.textarea("ta1"));
		b.assertValue(b.textarea("ta1"), "");

		b.link("Back").click();
		b.link("Link Test").click();
		b.link("link with return false").click();
		b.assertExists(b.textbox("t1"));
		b.assertValue(b.textbox("t1"), "formTest link with return false");
		
		b.assertExists(b.link("linkByContent"));

		b.link("link with returnValue=false").click();
		b.assertExists(b.textbox("t1"));
		b.assertValue(b.textbox("t1"), "formTest link with returnValue=false");
		b.link("added handler using js").click();
		b.assertExists(b.textbox("t1"));
		b.assertValue(b.textbox("t1"), "myFn called");
		b.textbox("t1").setValue("");
		b.image("imgWithLink").click();
		b.link("Link Test").click();
		b.image("imgWithLinkNoClick").click();
		b.assertExists(b.textbox("t1"));
		b.assertValue(b.textbox("t1"), "myFn called");
		b.link("Back").click();		
	}
	
	public void testTitle(){
		navigateTo();
		b.areEqual(b.title(),"Sahi Tests");
		b.link("Form Test").click();
		b.areEqual("Form Test", b.title());
		b.link("Back").click();
	}

	public void testIsVisible(){
		navigateTo();
		b.link("Visible Test").click();
		b.spandiv("using display").assertVisible();

		b.button("Display none").click();
		b.assertNotVisible(b.spandiv("using display"));
		b.button("Display block").click();
		b.assertVisible(b.spandiv("using display"));

		b.button("Display none").click();
		b.assertNotVisible(b.spandiv("using display"));
		b.button("Display inline").click();
		b.assertVisible(b.spandiv("using display"));

		b.assertVisible(b.spandiv("using visibility"));
		b.button("Visibility hidden").click();
		b.assertNotVisible(b.spandiv("using visibility"));
		b.button("Visibility visible").click();
		b.assertVisible(b.spandiv("using visibility"));

		b.assertNotVisible(b.byId("nestedBlockInNone"));
		b.assertNotVisible(b.byId("absoluteNestedBlockInNone"));
	}
}
