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

package uk.gov.hmrc.test.ui.cucumber.stepdefs

import io.cucumber.datatable.DataTable
import uk.gov.hmrc.test.ui.cucumber.Find.findById
import uk.gov.hmrc.test.ui.cucumber.{Check, Input, Nav, Wait}
import uk.gov.hmrc.test.ui.pages.AuthLoginPage

class StepDef extends BaseStepDef {

  Given("""^(.*) logs in to access file upload page$""") { name: String =>
    name match {
      case "New User" => AuthLoginPage.loginWithNewUserUpload(name)
      case "Old User" => AuthLoginPage.loginWithOldUserUpload(name)
    }
  }

  Given("""^The Heading should be (.*)$""") { header: String =>
    Check.checkH1(header)
  }

  Then("""^I navigate to (.*) page$""") { page: String =>
    page match {
      case "details" =>
        Nav.navigateTo("http://localhost:10024/send-a-country-by-country-report/change-contact/details")
    }
  }

  And(
    """^(click Continue button|click Confirm and send)$"""
  ) { (negate: String) =>
    Input.clickSubmit
  }

  Then("""^I enter (.*) in (.*)$""") { (text: String, id: String) =>
    Input.sendKeysById(text, id)
  }

  And("""^I select (.*) and continue$""") { (id: String) =>
    Input.clickById(id)
    Input.clickSubmit
  }

  And("""^I click (.*)$""") { (id: String) =>
    Input.clickByLinkText(id)
  }

  And("""^click (.*) element$""") { (id: String) =>
    Input.clickById(id)
  }

  Then("""^The Page should include (.*)$""") { text: String =>
    Check.checkBodyText(text)

  }

  Then("""wait for (.*) seconds$""") { (secs: Int) =>
    Wait.secondsWait(secs)
  }

  Then("""^The Subheading should be (.*)$""") { header: String =>
    Check.checkSubHeading(header)
  }

  Then("""^The subheading becomes (.*)$""") { header: String =>
    Check.checkUploadSubheading(header)
  }

  Given("""^the user should be on the new window with title "([^"]*)" page""") { (title: String) =>
    Input.switchToNewWindow
    Check.checkH1(title)
  }

  Then("""^The error table should show the following errors$""") { data: DataTable =>
    val row = data.asMaps(classOf[String], classOf[String]).iterator
    while (row.hasNext) {
      val map   = row.next
      val line  = map.get("line").toString
      val error = map.get("error").toString

      findById(s"lineNumber_$line").getText   shouldBe line
      findById(s"errorMessage_$line").getText shouldBe error

    }
  }

}
