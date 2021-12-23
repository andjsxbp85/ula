@SignUp
Feature: Register Amazon New User
  As a User
  I want to create my new account
  So that I can access my new account and do any activities on it

  @TestCaseKey=DESKTOP-T7
  Scenario: 01 - User can go to register page from login page
    Given user membuka halaman utama Amazon
    When user mengklik button account di top navigation bar
    And user mengklik button 'Create your Amazon account'
    Then user akan diarahkan ke halaman utama sign up

  @TestCaseKey=DESKTOP-T8
  Scenario: 02 - User can't sign up using existing email on database
    Given user membuka halaman utama Amazon
    When user mengklik button account di top navigation bar
    And user mengklik button 'Create your Amazon account'
    And user mengisi email field dengan email yang telah terdaftar
    Then user akan mendapatkan pesan kegagalan sign up "Email address already in use"

  @TestCaseKey=DESKTOP-T9
  Scenario: 03 - User can't continuing to next step of sign up if all mandatory field left empty
    Given user membuka halaman utama Amazon
    When user mengklik button account di top navigation bar
    And user mengklik button 'Create your Amazon account'
    And user membiarkan seluruh field pada form sign up kosong dan mengklik button "Continue"
    Then user tetap berada di halaman Sign Up
    And seluruh alert error tiap field pada halaman sign up ditampilkan

  @TestCaseKey=DESKTOP-T10
  @TestCaseKey=DESKTOP-T11
  @TestCaseKey=DESKTOP-T12
  @TestCaseKey=DESKTOP-T13
  Scenario Outline: 04 - User can't continuing to next step of sign up if only one of mandatory field left empty
    Given user membuka halaman utama Amazon
    When user mengklik button account di top navigation bar
    And user mengklik button 'Create your Amazon account'
    And user membiarkan field <the_only_one_empty_field> pada halaman sign up kosong
    Then user tetap berada di halaman Sign Up
    And alert error pada halaman sign up untuk field <the_only_one_empty_field> akan ditampilkan
    Examples:
      | the_only_one_empty_field |
      | name                     |
      | email                    |
      | password                 |
      | re-enter pass empty      |

  @TestCaseKey=DESKTOP-T14
  Scenario: 05 - User can't continuing to next step of sign up if password and re-enter password doesnt match
    Given user membuka halaman utama Amazon
    When user mengklik button account di top navigation bar
    And user mengklik button 'Create your Amazon account'
    And user mengisi field re-enter password yang berbeda dengan field password
    Then user tetap berada di halaman Sign Up
    And alert error pada halaman sign up untuk field re-enter pass unmatch akan ditampilkan

  @TestCaseKey=DESKTOP-T15
  Scenario: 06 - User input wrong email format
    Given user membuka halaman utama Amazon
    When user mengklik button account di top navigation bar
    And user mengklik button 'Create your Amazon account'
    And user mengisi email dengan format yang invalid
    Then user tetap berada di halaman Sign Up
    And alert error pada halaman sign up untuk field email wrong format akan ditampilkan

  @TestCaseKey=DESKTOP-T16
  Scenario: 07 - User success create new account from sign up page
    Given user membuka halaman utama Amazon
    When user mengklik button account di top navigation bar
    And user mengklik button 'Create your Amazon account'
    And user mengisi seluruh field sign up form dengan benar dan sesuai
    Then user diarahkan ke halaman verifikasi email
