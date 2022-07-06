/*
 * Copyright 2022 HM Revenue & Customs
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package uk.gov.hmrc.test.ui.pages

import org.openqa.selenium.support.ui.Select
import uk.gov.hmrc.test.ui.conf.TestConfiguration
import uk.gov.hmrc.test.ui.cucumber.{Find, Input, Nav, Wait}

object AuthLoginPage extends BasePage {
  val url: String              = TestConfiguration.url("auth-login-stub") + "/gg-sign-in"
  val redirectUrlField: String = "redirectionUrl"
  val uploadUrl: String        = TestConfiguration.url("country-by-country-reporting-frontend")
  val enrolmentKeyField        = "enrolment[0].name"
  val enrolmentKeyFieldValue   = "HMRC-CBC-ORG"
  val identifierNameField      = "enrolment[0].taxIdentifier[0].name"
  val identifierNameValue      = "cbcId"
  val identifierValueField     = "enrolment[0].taxIdentifier[0].value"
  val identifierValueNew       = "XACBC0000123777"
  val identifierValueExisting  = "XACBC0000123778"

  def loginWithNewUserUpload(name: String): Unit = {
    Nav.navigateTo(url)
    Input.sendKeysByName(uploadUrl, redirectUrlField)
    Input.sendKeysByName(enrolmentKeyFieldValue, enrolmentKeyField)
    Input.sendKeysByName(identifierNameValue, identifierNameField)
    Input.sendKeysByName(identifierValueNew, identifierValueField)
    selectAffinityGroupOrg()
    clickSubmitButton
  }

  def loginWithOldUserUpload(name: String): Unit = {
    Nav.navigateTo(url)
    Input.sendKeysByName(uploadUrl, redirectUrlField)
    Input.sendKeysByName(enrolmentKeyFieldValue, enrolmentKeyField)
    Input.sendKeysByName(identifierNameValue, identifierNameField)
    Input.sendKeysByName(identifierValueExisting, identifierValueField)
    selectAffinityGroupOrg()
    clickSubmitButton
  }

  private def selectCredentialStrength() =
    new Select(findConfidenceLevel()).selectByVisibleText("200")

  private def selectConfidenceLevel() =
    new Select(findCredentialStrength()).selectByVisibleText("strong")

  private def selectAffinityGroupAgent() =
    new Select(findAffinityGroup()).selectByVisibleText("Agent")

  private def selectAffinityGroupOrg() =
    new Select(findAffinityGroup()).selectByVisibleText("Organisation")

  private def selectCredRoleAssistant() =
    new Select(findCredentialRole()).selectByVisibleText("Assistant")

  private def findAffinityGroup() = Find.findByName("affinityGroup")

  private def findCredentialRole() = Find.findByName("credentialRole")

  private def findCredentialStrength() = Find.findByName("credentialStrength")

  private def findConfidenceLevel() = Find.findByName("confidenceLevel")

  private def clickOnSubmit() = Wait.waitForElement("inputForm").submit()

  def clickSubmitButton = Find.findById("submit").click()

}
