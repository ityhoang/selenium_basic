package selenium_basic;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginTestCase extends BaseChromeTest {
	final String urlLogin = Constant.base_url + "login";

	@Test
	public void LoginSuccess() throws InterruptedException {
		driver.get(urlLogin);

		WebElement userField = driver.findElement(By.cssSelector("input[formcontrolname=\"username\"]"));
		WebElement passField = driver.findElement(By.cssSelector("input[formcontrolname=\"password\"]"));
		userField.sendKeys("test1");
		passField.sendKeys("12345678aA");
		WebElement buttonLogin = driver.findElement(
				By.cssSelector(".mdc-button.mdc-button--raised.mat-mdc-raised-button.mat-primary.mat-mdc-button-base"));
		buttonLogin.click();
		Thread.sleep(2000);

		Assertions.assertTrue(!driver.getCurrentUrl().equals(urlLogin));
	}

	@Test
	public void LoginFail() throws InterruptedException {
		driver.get(urlLogin);

		WebElement userField = driver.findElement(By.cssSelector("input[formcontrolname=\"username\"]"));
		WebElement passField = driver.findElement(By.cssSelector("input[formcontrolname=\"password\"]"));
		userField.sendKeys("test1");
		passField.sendKeys("12345678aAa");
		WebElement buttonLogin = driver.findElement(
				By.cssSelector(".mdc-button.mdc-button--raised.mat-mdc-raised-button.mat-primary.mat-mdc-button-base"));
		buttonLogin.click();
		Thread.sleep(2000);
//		WebElement errorMsg = driver.findElement(By.id("mat-mdc-error-1"));
//		Boolean isError = errorMsg.getText().equals("Username or Password is incorrect.");
		Boolean isChangeUrlFail = driver.getCurrentUrl().equals(urlLogin);
		Assertions.assertTrue(isChangeUrlFail);
	}
	
	@Test
	public void LoginEmptyPass() throws InterruptedException {
		driver.get(urlLogin);

		WebElement userField = driver.findElement(By.cssSelector("input[formcontrolname=\"username\"]"));
		WebElement passField = driver.findElement(By.cssSelector("input[formcontrolname=\"password\"]"));
		userField.sendKeys("test1");
		passField.sendKeys("");
		WebElement buttonLogin = driver.findElement(
				By.cssSelector(".mdc-button.mdc-button--raised.mat-mdc-raised-button.mat-primary.mat-mdc-button-base"));
		buttonLogin.click();
		Thread.sleep(2000);

		Assertions.assertTrue(driver.getCurrentUrl().equals(urlLogin));
	}
	
	@Test
	public void LoginEmptyUser() throws InterruptedException {
		driver.get(urlLogin);

		WebElement userField = driver.findElement(By.cssSelector("input[formcontrolname=\"username\"]"));
		WebElement passField = driver.findElement(By.cssSelector("input[formcontrolname=\"password\"]"));
		userField.sendKeys("");
		passField.sendKeys("12345678aAa");
		WebElement buttonLogin = driver.findElement(
				By.cssSelector(".mdc-button.mdc-button--raised.mat-mdc-raised-button.mat-primary.mat-mdc-button-base"));
		buttonLogin.click();
		Thread.sleep(2000);

		Assertions.assertTrue(driver.getCurrentUrl().equals(urlLogin));
	}
}
