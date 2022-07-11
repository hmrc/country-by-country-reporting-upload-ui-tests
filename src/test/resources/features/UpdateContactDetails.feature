@tests @ZAP
Feature: Contact Details

  Scenario: 1 - Existing 2 contacts user  updating contact details
    Given Existing User with 2 contact logs in to access file upload page
    Then The Heading should be Report cross-border arrangements for CBC
    And I click change your contact details
    Then The Heading should be Contact details at your organisation
    Then click contact-name element
    Then The Heading should be Who can we contact if we have questions about your reports?
    And I enter Primary contact name updated in value
    And click Continue button
    Then The Heading should be What is the email address for Primary contact name updated?
    And I enter FirstContactUpdated@haddonfield.com in value
    And click Continue button
    Then The Heading should be Can we contact Primary contact name updated by telephone?
    When I select value and continue
    Then The Heading should be What is the telephone number for Primary contact name updated?
    And I enter 01632 960 001 in value
    And click Continue button
    Then The Heading should be Contact details at your organisation
    Then The Page should include Primary contact name updated
    Then The Page should include FirstContactUpdated@haddonfield.com
    Then The Page should include  01632 960 001
    # updating additional contact
    And click second-contact element
    Then The Heading should be Is there someone else we can contact if Primary contact name updated is not available?
    When I select value and continue
    Then The Heading should be What is the name of the individual or team we should contact?
    And I enter additional contact in value
    And click Continue button
    Then The Heading should be What is the email address for additional contact?
    And I enter additionalContact@email.com in value
    And click Continue button
    Then The Heading should be Can we contact additional contact by telephone?
    When I select value and continue
    Then The Heading should be What is the telephone number for additional contact?
    And I enter +44 808 157 0192 in value
    And click Continue button
    Then The Heading should be Contact details at your organisation
    Then The Page should include additional contact
    Then The Page should include additionalContact@email.com
    Then The Page should include +44 808 157 0192
    # removing additional contact
    Then click second-contact element
    Then The Heading should be Is there someone else we can contact if Primary contact name updated is not available?
    When I select value-no and continue
    Then The Heading should be Contact details at your organisation
    Then The Page should include No
    When click Confirm and send
    Then The Heading should be Contact details updated
    Then I click Back to send a CBC report
    Then The Heading should be Report cross-border arrangements for CBC

  Scenario: 2 - Existing 1 contact user adds second contact details
    Given Existing User with 1 contact logs in to access file upload page
    Then The Heading should be Report cross-border arrangements for CBC
    And I click change your contact details
    Then The Heading should be Contact details at your organisation
    Then click contact-name element
    Then The Heading should be Who can we contact if we have questions about your reports?
    And I enter Primary contact name updated in value
    And click Continue button
    Then The Heading should be What is the email address for Primary contact name updated?
    And I enter FirstContactUpdated@haddonfield.com in value
    And click Continue button
    Then The Heading should be Can we contact Primary contact name updated by telephone?
    When I select value and continue
    Then The Heading should be What is the telephone number for Primary contact name updated?
    And I enter 01632 960 001 in value
    And click Continue button
    Then The Heading should be Contact details at your organisation
    Then The Page should include Primary contact name updated
    Then The Page should include FirstContactUpdated@haddonfield.com
    Then The Page should include  01632 960 001
    # updating additional contact
    And click second-contact element
    Then The Heading should be Is there someone else we can contact if Primary contact name updated is not available?
    When I select value and continue
    Then The Heading should be What is the name of the individual or team we should contact?
    And I enter additional contact in value
    And click Continue button
    Then The Heading should be What is the email address for additional contact?
    And I enter additionalContact@email.com in value
    And click Continue button
    Then The Heading should be Can we contact additional contact by telephone?
    When I select value and continue
    Then The Heading should be What is the telephone number for additional contact?
    And I enter +44 808 157 0192 in value
    And click Continue button
    Then The Heading should be Contact details at your organisation
    Then The Page should include additional contact
    Then The Page should include additionalContact@email.com
    Then The Page should include +44 808 157 0192
    Then The Heading should be Contact details at your organisation
    Then The Page should include No
    When click Confirm and send
    Then The Heading should be Contact details updated
    Then I click Back to send a CBC report
    Then The Heading should be Report cross-border arrangements for CBC

  Scenario: 3 - New user to cbc online -  provides 2 contacts
    Given New User logs in to access file upload page
    Then The Heading should be We need your contact details
    And click Continue button
    Then The Heading should be Who can we contact if we have questions about your reports?
    And I enter Primary contact name in value
    And click Continue button
    Then The Heading should be What is the email address for Primary contact name?
    And I enter FirstContact@haddonfield.com in value
    And click Continue button
    Then The Heading should be Can we contact Primary contact name by telephone?
    When I select value-no and continue
    Then The Heading should be Is there someone else we can contact if Primary contact name is not available?
    When I select value and continue
    Then The Heading should be What is the name of the individual or team we should contact?
    And I enter additional contact in value
    And click Continue button
    Then The Heading should be What is the email address for additional contact?
    And I enter additionalContact@email.com in value
    And click Continue button
    Then The Heading should be Can we contact additional contact by telephone?
    When I select value and continue
    Then The Heading should be What is the telephone number for additional contact?
    And I enter +44 808 157 0192 in value
    And click Continue button
    Then The Heading should be Contact details at your organisation
    Then The Page should include Primary contact name
    Then The Page should include FirstContact@haddonfield.com
    Then The Page should include additional contact
    Then The Page should include additionalContact@email.com
    Then The Page should include +44 808 157 0192
    When click Confirm and send
    Then The Heading should be Contact details updated

  Scenario: 4 - New user to cbc online - provides 1 contact
    Given New User logs in to access file upload page
    Then The Heading should be We need your contact details
    And click Continue button
    Then The Heading should be Who can we contact if we have questions about your reports?
    And I enter Primary contact name in value
    And click Continue button
    Then The Heading should be What is the email address for Primary contact name?
    And I enter FirstContact@haddonfield.com in value
    And click Continue button
    Then The Heading should be Can we contact Primary contact name by telephone?
    When I select value and continue
    Then The Heading should be What is the telephone number for Primary contact name?
    And I enter 01632 960 001 in value
    And click Continue button
    Then The Heading should be Is there someone else we can contact if Primary contact name is not available?
    When I select value-no and continue
    Then The Heading should be Contact details at your organisation
    Then The Page should include Primary contact name
    Then The Page should include FirstContact@haddonfield.com
    Then The Page should include  01632 960 001
    When click Confirm and send
    Then The Heading should be Contact details updated
    Then I click Back to send a CBC report
    Then The Heading should be Report cross-border arrangements for CBC