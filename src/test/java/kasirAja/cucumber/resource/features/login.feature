Feature: Login Page Aplikasi KasirAja

  @Regression @Positive
  Scenario: Success Login
    Given Halaman Login KasirAja
    When Input Username
    And Input Password
    And Click Login Button
    Then User In On Dashboard Page

  @Regression @Negative
  Scenario: Failed Login
    Given Halaman Login KasirAja
    When Input Username
    And Input Invalid Password
    And Click Login Button
    Then User Get Error Message

  @TDD
  Scenario Outline: User Login To kasirAja
  Given Halaman Login KasirAja
  When I input <email> as email
  And I Input <password> as password
  And click login button
  Then I verify <status> login result

    Examples:
      | email | password | status |
      | tdd-selenium@gmail.com | tdd-selenium | success |
      | failed-login@gmail.com | failed-login | failed |


  # Total Ada = 6 Step Definitions

  #   Script didapat dengan menonton video
  #   6. Topik 6 - Integrasi Gherkin dan test case - (4) Instalasi Maven Cucumber Cucumber Feature
  #   https://www.rakamin.com/dashboard/my-class/2876/module/8127/session/55862

  #   &
  #   6. Topik 6 - Integrasi Gherkin dan test case - (7) Cucumber DDT
  #   https://www.rakamin.com/dashboard/my-class/2876/module/8127/session/55896