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

package uk.gov.hmrc.test.ui.cucumber

object Forms {

  val firstName            = "FirstName"
  val secondName           = "LastName"
  val soleTraderFirstName  = "sfirstname"
  val soleTraderSecondName = "slastname"
  val dob_day              = "01"
  val dob_month            = "01"
  val dob_year             = "1909"
  val addressLine1         = "17 Beechfield Manor"
  val addressLine2         = "Aghalee"
  val city                 = "Paris"
  val region               = "North"
  val county               = "Tyne and wear"
  val postcode             = "NE13 2XH"
  val nino                 = "CS700100A"

  def whatIsYourName = {
    Input.sendKeysById(firstName, "firstName")
    Input.sendKeysById(secondName, "lastName")
  }

  def whatIsYourNameForSoleTrader = {
    Input.sendKeysById(soleTraderFirstName, "firstName")
    Input.sendKeysById(soleTraderSecondName, "lastName")
  }

  def whatIsYourNameForNonMatch = {
    Input.sendKeysById("FirstNameNonMatch", "firstName")
    Input.sendKeysById("secondNameNonMatch", "lastName")
  }

  def whatIsYourNameForWithoutNino = {
    Input.sendKeysById(firstName, "givenName")
    Input.sendKeysById(secondName, "familyName")
  }

  def dateOfBirth = {
    Input.sendKeysById(dob_day, "value_day")
    Input.sendKeysById(dob_month, "value_month")
    Input.sendKeysById(dob_year, "value_year")
  }

  def addressUK() = {
    Input.sendKeysById(addressLine1, "addressLine1")
    Input.sendKeysById(addressLine2, "addressLine2")
    Input.sendKeysById(city, "addressLine3")
    Input.sendKeysById(county, "addressLine3")
    Input.sendKeysById(postcode, "postCode")
  }

  def addressNonUK() = {
    Input.sendKeysById(addressLine1, "addressLine1")
    Input.sendKeysById(addressLine2, "addressLine2")
    Input.sendKeysById(city, "addressLine3")
    Input.sendKeysById(region, "addressLine4")
    Input.sendKeysById(postcode, "postCode")
    Forms.countryAutoSelect("country", "France")
  }

  def countryAutoSelect(id: String, countryName: String) = {
    Input.clickById(id)
    Input.sendKeysById(countryName, id)
    Input.clickById(id + "__option--0")
  }

}
