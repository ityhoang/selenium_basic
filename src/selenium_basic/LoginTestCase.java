package selenium_basic;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.WheelInput;

public class LoginTestCase extends BaseChromeTest{
	final String urlLogin = Constant.base_url + "login";
	
	@Test
	public void shouldScrollFromViewportByGivenAmountFromOrigin() {
		driver.get("https://www.selenium.dev/selenium/web/scrolling_tests/frame_with_nested_scrolling_frame.html");

		WheelInput.ScrollOrigin scrollOrigin = WheelInput.ScrollOrigin.fromViewport(10, 10);
		new Actions(driver).scrollFromOrigin(scrollOrigin, 0, 200).perform();

		WebElement iframe = driver.findElement(By.tagName("iframe"));
		driver.switchTo().frame(iframe);
		WebElement checkbox = driver.findElement(By.name("scroll_checkbox"));
		Assertions.assertTrue(inViewport(checkbox));
	}

	private boolean inViewport(WebElement element) {

		String script = "for(var e=arguments[0],f=e.offsetTop,t=e.offsetLeft,o=e.offsetWidth,n=e.offsetHeight;\n"
				+ "e.offsetParent;)f+=(e=e.offsetParent).offsetTop,t+=e.offsetLeft;\n"
				+ "return f<window.pageYOffset+window.innerHeight&&t<window.pageXOffset+window.innerWidth&&f+n>\n"
				+ "window.pageYOffset&&t+o>window.pageXOffset";

		return (boolean) ((JavascriptExecutor) driver).executeScript(script, element);
	}
}
