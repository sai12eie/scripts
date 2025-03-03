package demo.form;

import com.sahipro.lang.java.client.Browser;
import com.sahipro.lang.java.client.SahiCapabilities;
import com.sahipro.lang.java.client.SahiMarkerInterface;

public class FormTester implements SahiMarkerInterface {

	Browser b = null;


	public FormTester(SahiCapabilities modes) {
		this.b = modes.getBrowser();
	}
	
	public void testSahiDemoAccessors(){
		String baseURL = "http://sahitest.com/";
		b.navigateTo(baseURL + "/demo/formTest.htm");
		b.textbox("t1").assertValue("");
		b.textbox(1).assertExists();
		b.textbox("$a_dollar").assertExists();
		b.textbox("$a_dollar").setValue("adas");
		b.textbox(1).assertValue("");
		b.textarea("ta1").assertExists();
		b.textarea("ta1").assertValue("");
		b.textarea(1).assertExists();
		b.textarea(1).assertValue("");
		b.checkbox("c1").assertExists();
		b.checkbox("c1").assertValue("cv1");
		b.checkbox(1).assertExists();
		b.checkbox(1).assertExists();
		b.checkbox(1).assertValue("cv2");
		b.checkbox("c1[1]").assertExists();
		b.checkbox("c1[1]").assertValue("cv3");
		b.checkbox(3).assertExists();
		b.checkbox(3).assertValue("");
		b.radio("r1").assertExists();
		b.radio("r1").assertValue("rv1");
		b.password("p1").assertExists();
		b.password("p1").assertValue("");
		b.password(1).assertExists();
		b.password(1).assertValue("");
		b.select("s1").assertExists();
		b.areEqual("o1", b.select("s1").selectedText());
		b.select("s1Id[1]").assertExists();
		b.areEqual("o1", b.select("s1Id[1]").selectedText());
		b.select(2).assertExists();
		b.areEqual("o1", b.select(2).selectedText());
		b.button("button value").assertExists();
		b.button("btnName[1]").assertExists();
		b.button("btnId[2]").assertExists();
		b.button(3).assertExists();
		b.submit("Add").assertExists();
		b.submit("submitBtnName[1]").assertExists();
		b.isTrue(b.submit("submitBtnId[2]").exists());
		b.submit(3).assertExists();
		b.image("imageAlt1").assertExists();
		b.image("imageId1[1]").assertExists();
		b.image(2).assertExists();
		b.link("Back22").assertNotExists();
		b.link("Back").assertExists();
		b.byClassName("button[1]", "INPUT").assertExists();
		b.navigateTo("tableTest.htm");
	    b.byXPath("//table[1]/tbody/tr[1]/td[@id='CellWithId']").assertExists();
	}
}
