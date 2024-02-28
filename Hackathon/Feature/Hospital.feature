Feature: Finding Hospital

  @sanity
  Scenario: Finding Doctors and applying Filters
    Given Setup of browser for the given application
    When Search for the desired location and speciality of Doctor
    And add the required filters for searching doctors
    Then capture the details of first 5 doctors
    When the user is on Surgery Page and the list of types of Surgeries are displayed
    Then capture the list of Popular Surgeries in excel
    And all the details of form with invalid email
    When the email is invalid
    Then validate if Taking a demo button is disabled
    And if email is valid capture ThankYou