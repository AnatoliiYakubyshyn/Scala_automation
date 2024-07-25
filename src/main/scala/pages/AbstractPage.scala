package com.solvd.scalatest
package pages

import org.openqa.selenium.WebDriver
import org.openqa.selenium.support.PageFactory

abstract class AbstractPage(private val driver: WebDriver) {

  PageFactory.initElements(driver, this)

  private var url: String = ""

  def setUrl(url: String): Unit = {
    this.url = url
  }

  def open(): Unit = {
    driver.get(url)
  }

}
