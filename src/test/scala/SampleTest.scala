package com.solvd.scalatest


import java.net.URL
import java.util.concurrent.TimeUnit
import org.openqa.selenium.chrome.ChromeOptions
import org.openqa.selenium.remote.{DesiredCapabilities, RemoteWebDriver}
import org.scalatest.funsuite.AnyFunSuite

import com.solvd.scalatest.pages.HomePage

class SampleTest extends AnyFunSuite {

  test("about page should be displayed after navigation") {
    val selenoidUrl = "http://localhost:4445/wd/hub"
    val options = new ChromeOptions()
    options.setCapability("browserName", "chrome")
    options.setCapability("browserVersion", "125")
    options.addArguments("--headless") // Enable headless mode
    options.addArguments("--disable-gpu") // Disable GPU acceleration
    options.addArguments("--no-sandbox") // Bypass OS security model
    options.addArguments("--disable-dev-shm-usage") // Overcome limited resource problems

    // Configure Selenoid options
    val selenoidOptions = new java.util.HashMap[String, Object]()
    selenoidOptions.put("sessionTimeout", "15m")
    options.setCapability("selenoid:options", selenoidOptions)

    // Create RemoteWebDriver instance
    val driver = new RemoteWebDriver(new URL(selenoidUrl), options)


    driver.manage().timeouts().implicitlyWait(10000,TimeUnit.MILLISECONDS)
    driver.manage().window().maximize()
    val homePage = new HomePage(driver)
    homePage.open()
    homePage.search("hello");
    assert(driver.getCurrentUrl.contains("hello"))
    driver.quit()
  }

}
