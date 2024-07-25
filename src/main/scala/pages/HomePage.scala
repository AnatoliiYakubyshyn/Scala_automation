package com.solvd.scalatest.pages

import org.openqa.selenium.support.FindBy
import org.openqa.selenium.{Keys, WebDriver, WebElement}

class HomePage(driver: WebDriver) extends AbstractPage(driver) {
  setUrl("https://www.google.com/")

  @FindBy(xpath = "//textarea[contains(@class,'gLFyf')]")
  private var searchPanel: WebElement = _

  def search(text:String): Unit = {
    searchPanel.sendKeys(text,Keys.ENTER)
  }
}
