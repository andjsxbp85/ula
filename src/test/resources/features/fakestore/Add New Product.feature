@getALLPorduct
Feature: Create New Product
  As a User
  I want to create new product from BE side
  So that the data can be recorded and can be used by FE team to build other environment

  @TestCaseKey=API-06
  Scenario Outline: 01 - User success add new product with valid Json data
    Given user prepare data for add new products with title <title> price <price> description <desc> image <img> category <cat>
    When user hit endpoint add new products with request data that has been prepared before
    Then didapatkan http response code Add New Product 200
    And didapatkan json schema Add New Product sesuai dengan file AddProduct/successAddNewProduct.json
    And title response body add new product sama dengan <title> pada saat request
    And price resposne body add new product sama dengan <price> pada saat request
    And description response body add new product sama dengan <desc> pada saat request
    And image url response body add new product sama dengan <img> pada saat request
    And category response body add new product sama dengan <cat> pada saat request
    Examples:
      | title        | price | desc                | img                   | cat        |
      | test product | 13.5  | lorem ipsum sedolor | https://i.pravatar.cc | electronic |

  @TestCaseKey=API-07
  Scenario: 02 - User will get error response if title value set as integer
    Given user prepare data for title add new products with integer value 9123812941924
    When user hit endpoint add new products with invalid request data that has been prepared before
    Then didapatkan http response code Add New Product 400
    And didapatkan error message add new product "Please check your title request body!"
    And didapatkan json schema Add New Product sesuai dengan file AddProduct/generalInvalidAddNewProduct.json

  @TestCaseKey=API-08
  Scenario: 03 - User will get error response if request body is empty json
    Given user prepare data for add new products request body with empty json
    When user hit endpoint add new products with invalid request data that has been prepared before
    Then didapatkan http response code Add New Product 400
    And didapatkan error message add new product "Please check your request body json format!"
    And didapatkan json schema Add New Product sesuai dengan file AddProduct/generalInvalidAddNewProduct.json

  @TestCaseKey=API-09
  Scenario: 04 - User will get error response if request body is empty object
    Given user prepare data for add new products request body with empty object
    When user hit endpoint add new products with invalid request data that has been prepared before
    Then didapatkan http response code Add New Product 400
    And didapatkan error message add new product "Please check your request body json format!"
    And didapatkan json schema Add New Product sesuai dengan file AddProduct/generalInvalidAddNewProduct.json

  @TestCaseKey=API-11
  Scenario: 05 - User will get error response if request body is null
    Given user prepare data for add new products request body with null
    When user hit endpoint add new products with invalid request data that has been prepared before
    Then didapatkan http response code Add New Product 400
    And didapatkan error message add new product "Please check your request body json format!"
    And didapatkan json schema Add New Product sesuai dengan file AddProduct/generalInvalidAddNewProduct.json

  @TestCaseKey=API-12
  Scenario: 06 - User will get error response if price field set as String value
    Given user prepare data price for add new products request body with String value "Ayam Bekakak"
    When user hit endpoint add new products with invalid request data that has been prepared before
    Then didapatkan http response code Add New Product 400
    And didapatkan error message add new product "Please check your request body json format!"
    And didapatkan json schema Add New Product sesuai dengan file AddProduct/generalInvalidAddNewProduct.json

  @TestCaseKey=API-13
  Scenario Outline: 07 - Creating new product will be recorded in DB and can be access using get product method
    Given user prepare data for add new products with title <title> price <price> description <desc> image <img> category <cat>
    When user hit endpoint add new products with request data that has been prepared before
    And user mengekstrak ID baru yang terbuat dari add new produk
    And user melakukan hit endpoint get product by ID yang diekstrak tadi
    Then didapatkan http response code Get Product 200
    And didapatkan nama barang dari get product adalah <title>
    And harga barang dari get product adalah <price>
    And deskripsi product dari get product adalah <desc>
    And kategori product dari get product adalah <img>
    And alamat gambar product dari get product adalah <cat>
    And didapatkan json schema Get Product sesuai dengan file GetProduct/successGetProductByID.json
    Examples:
      | title        | price | desc                | img                   | cat        |
      | test product | 13.5  | lorem ipsum sedolor | https://i.pravatar.cc | electronic |