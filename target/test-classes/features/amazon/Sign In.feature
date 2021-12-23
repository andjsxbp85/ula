@Login
Feature: Login Amazon
  As a User
  I want to login to my account
  So that I can access my account and do any activities on it

  @TestCaseKey=DESKTOP-T1
  Scenario: 01 - User can go to login page from clicking account navigation bar
    Given user membuka halaman utama Amazon
    When user mengklik button account di top navigation bar
    Then user akan diarahkan ke halaman utama login

  @TestCaseKey=DESKTOP-T2
  Scenario: 02 - User can go to login page from clicking button sign in from account navigation bar dropdown menu
    Given user membuka halaman utama Amazon
    When user melakukan hovering mouse ke button account di top navigation bar
    And user mengklik button Sign In pada account nav bar
    Then user akan diarahkan ke halaman utama login

  @TestCaseKey=DESKTOP-T3
  Scenario: 03 - Success Login Using Correct Email and Password
    Given user membuka halaman utama Amazon
    When user mengklik button account di top navigation bar
    And user mengisi email field dengan email yang valid
    And user mengklik button Continue
    And user mengisi password field dengan password yang valid
    And user mengklik button Sign In di halaman login
    Then user akan diarahkan ke home page dengan account name "Tester"

  @TestCaseKey=DESKTOP-T4
  Scenario: 04 - Failed Login Using incorrect Email and Password
    Given user membuka halaman utama Amazon
    When user mengklik button account di top navigation bar
    And user mengisi email field dengan email yang valid
    And user mengklik button Continue
    And user mengisi password field dengan password yang invalid
    And user mengklik button Sign In di halaman login
    Then user tetap berada di halaman Sign In isi password
    And user akan mendapatkan alert error header "There was a problem" dan pesan "Your password is incorrect"

  @TestCaseKey=DESKTOP-T5
  Scenario: 05 - User Cannot Continuing to Login if Email Field Left Empty
    Given user membuka halaman utama Amazon
    When user mengklik button account di top navigation bar
    And user membiarkan email field kosong dan tidak terisi
    And user mengklik button Continue
    Then user mendapati alert error email invalid "Enter your email or mobile phone number"

  @TestCaseKey=DESKTOP-T6
  Scenario: 06 - User Cannot Continuing to Login if Password Field Left Empty
    Given user membuka halaman utama Amazon
    When user mengklik button account di top navigation bar
    And user mengisi email field dengan email yang valid
    And user mengklik button Continue
    And user membiarkan password field kosong dan tidak terisi
    And user mengklik button Sign In di halaman login
    Then user mendapati alert error password invalid "Enter your password"
