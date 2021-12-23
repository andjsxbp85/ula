@getALLPorduct
Feature: Login Amazon
  As a User
  I want to get All product list from BE side
  So that FE side can visualize its response data

  @TestCaseKey=API-T1
  Scenario: 01 - User can get all products list
    Given user prepare data for hitting get all products endpoint ''
    When user hit endpoint get all products with request data that has been prepared before
    Then didapatkan http response code Get Product 200
    And didapatkan json schema Get Product sesuai dengan file GetProduct/successGetAllProduct.json

  @TestCaseKey=API-T2
  Scenario: 02 - User can get all products list with limit param
    Given user prepare data for hitting get all products endpoint 'limit=5'
    When user hit endpoint get all products with request data that has been prepared before
    Then didapatkan http response code Get Product 200
    And jumlah list product yang didapatkan sesuai dengan limit=5
    And didapatkan json schema Get Product sesuai dengan file GetProduct/successGetAllProduct.json

  @TestCaseKey=API-T3
  Scenario: 03 - User can get product detail by ID
    Given user prepare data for hitting get product endpoint by ID 1
    When user hit endpoint get product by ID tersebut
    Then didapatkan http response code Get Product 200
    And didapatkan nama barang dari get product adalah "Fjallraven - Foldsack No. 1 Backpack, Fits 15 Laptops"
    And harga barang dari get product adalah 109.95
    And deskripsi product dari get product adalah "Your perfect pack for everyday use and walks in the forest. Stash your laptop (up to 15 inches) in the padded sleeve, your everyday"
    And kategori product dari get product adalah "men's clothing"
    And alamat gambar product dari get product adalah "https://fakestoreapi.com/img/81fPKd-2AYL._AC_SL1500_.jpg"
    And product dari get product tersebut memiliki rating 3.9
    And jumlah product yang tersedia dari get product adalah 120 buah
    And didapatkan json schema Get Product sesuai dengan file GetProduct/successGetProductByID.json

  @TestCaseKey=API-T4
  Scenario: 04 - User will get null response if set ID in negative value
    Given user prepare data for hitting get product endpoint by ID -1
    When user hit endpoint get product by ID tersebut
    Then didapatkan http response code Get Product 200
    And body response yang didapatkan adalah null

  @TestCaseKey=API-T5
  Scenario: 05 - User will get null response if set ID in very big number (product id not exist)
    Given user prepare data for hitting get product endpoint by ID 99999999999
    When user hit endpoint get product by ID tersebut
    Then didapatkan http response code Get Product 200
    And body response yang didapatkan adalah null