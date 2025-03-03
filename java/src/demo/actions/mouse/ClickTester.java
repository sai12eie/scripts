package demo.actions.mouse;

import com.sahipro.lang.java.client.Browser;
import com.sahipro.lang.java.client.SahiCapabilities;
import com.sahipro.lang.java.client.SahiMarkerInterface;

public class ClickTester implements SahiMarkerInterface {

	Browser b = null;

	public ClickTester(SahiCapabilities modes) {
		this.b = modes.getBrowser();
	}

	public void navigateTo() {
		String baseURL = "http://sahitest.com/";
		b.navigateTo(baseURL + "/demo/clicks.htm");
	}

	public void rightClick() {
		navigateTo();
		b.rightClick(b.div("right click me"));
		b.assertValue(b.textarea("t2"), "[RIGHT_CLICK]");
		b.textarea("t2").assertValue("[RIGHT_CLICK]");

		b.assertNotValue(b.textarea("t2"), "[DOUBLE_CLICK]");
		b.textarea("t2").assertNotValue("[DOUBLE_CLICK]");

		b.click(b.button("Clear"));
	}

	public void doubleClick() {
		navigateTo();
		b.assertExists(b.div("dbl click me"));

		b.doubleClick(b.div("dbl click me"));
		b.assertValue(b.textarea("t2"), "[DOUBLE_CLICK]");
		b.textarea("t2").assertValue("[DOUBLE_CLICK]");

		b.assertNotValue(b.textarea("t2"), "[RIGHT_CLICK]");
		b.textarea("t2").assertNotValue("[RIGHT_CLICK]");

		b.click(b.button("Clear"));
	}

	public void click() {
		navigateTo();
		b.click(b.button("click me"));
		b.assertValue(b.textarea("t2"), "[CLICK]");
		b.textarea("t2").assertValue("[CLICK]");

		b.assertNotValue(b.textarea("t2"), "[DOUBLE_CLICK]");
		b.textarea("t2").assertNotValue("[DOUBLE_CLICK]");

		b.click(b.button("Clear"));
	}

	public void clickCheckbox() {
		navigateTo();
		b.click(b.checkbox(0));
		b.assertChecked(b.checkbox(0));
		b.checkbox(0).assertChecked();

		if (b.isIE() || b.isSafari() || b.isEdge()) {
			b.assertValue(b.textarea("t2"), "onclick_c1");
		} else {
			b.assertValue(b.textarea("t2"), "onchange_c1");
		}

		b.click(b.checkbox(0));
		b.assertNotChecked(b.checkbox(0));

		b.click(b.button("Clear"));
	}

	public void clickRadioButton() {
		navigateTo();

		b.click(b.radio(0));
		b.assertChecked(b.radio(0));

		if (b.isIE() || b.isSafari() || b.isEdge()) {
			b.assertValue(b.textarea("t2"), "onclick_r1");
		} else {
			b.assertValue(b.textarea("t2"), "onchange_r1");
		}

		b.click(b.radio(1));
		b.assertNotChecked(b.radio(0));
		b.assertChecked(b.radio(1));

	}
}
