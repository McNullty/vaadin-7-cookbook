package com.analemma.vaadin_testbench;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.vaadin.testbench.By;
import com.vaadin.testbench.TestBench;
import com.vaadin.testbench.TestBenchTestCase;

public class SimplePlusTest2 extends TestBenchTestCase {
  private WebDriver driver;
  private String baseUrl;
  private final StringBuffer verificationErrors = new StringBuffer();

  @Before
  public void setUp() throws Exception {
    driver = TestBench.createDriver(new FirefoxDriver());
    baseUrl = "http://localhost:8080/11_04_vaadin_testbench/";
  }

  @Test
  public void testSimplePlusTest2() throws Exception {
    driver.get(concatUrl(baseUrl, "/"));
    testBenchElement(driver.findElement(By.id("txtNr1"))).click(59, 11);
    driver.findElement(By.id("txtNr1")).clear();
    driver.findElement(By.id("txtNr1")).sendKeys("15");
    testBenchElement(driver.findElement(By.id("txtNr2"))).click(20, 14);
    driver.findElement(By.id("txtNr2")).clear();
    driver.findElement(By.id("txtNr2")).sendKeys("10");
    testBenchElement(driver.findElement(By.id("txtResult"))).click(74, 15);
    driver.findElement(By.xpath("//span/span")).click();
    try {
      assertEquals("25", driver.findElement(By.id("txtResult")).getAttribute("value"));
    } catch (final Error e) {
      verificationErrors.append(e.toString());
    }
  }

  @After
  public void tearDown() throws Exception {
    driver.quit();
    final String verificationErrorString = verificationErrors.toString();
    if (!"".equals(verificationErrorString)) {
      fail(verificationErrorString);
    }
  }
}
