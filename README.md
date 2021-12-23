## API Automation Test https://fakestoreapi.com/
## UI Automation Test https://www.amazon.com/

:art: Tes ini dibuat oleh Anjas Muhammad Bangun untuk tujuan proses recruitment di ULA sebagai Quality Engineer

## Environment Test
**Website https://www.amazon.com/**
**API https://fakestoreapi.com/**
```
Framework dan Utilitas yang digunakan: Java JDK 8, Maven, Cucumber, JUnit, Serenity, Gherkin Syntax, BDD, Rest Assured
```

## How To Run
* 1. Clone atau download repository ini
* 2. Masuk ke direktori project
* 3. Open terminal
* 4. Jalankan perintah ini
```
$export valid_email=testerula123@gmail.com
$export valid_password=Testerula123!
```
* 6. Jalankan shell command:
```
$mvn clean verify
```

## Report Test
**Semua report test secara otomatis ada pada direktori target/site/serenity/index.html**

**How to open report?:**
```
1. Clone project
2. CD to target/site/serenity/index.html
3. Right click then open with your browser (i.e. Chrome)
```

## Summary
**Jumlah Tes: 4 Fitur dan 28 Scenario**

**Fitur yang dites:**
* (1) Sign In Amazon
* (2) Sign Up Amazon
* (3) Get Product Details Fakestore API
* (4) Create New Product Fakestore API

## Bug and Issues
**Nb: For detailed report, please refer to serenity report**

[MEDIUM] Text alert apabila user tidak mengisi field email, tidak konstan dan ada 2 kemungkinan perbedaan

[HIGH] NEED TO FIX SOON: Endpoint API at create new product isn't work well. All data is not really stored and recorded to database

## Test Coverage
**71% Passed, 21% Failed, 7% Broken**
![test_result](https://blogger.googleusercontent.com/img/a/AVvXsEjl5u_FXmxZ0rfUBWW6FmoRaH_Zu7JVTXnllGXJ-b9b1fHROW5MvwopVI8ror2lSulcqRjtKsEKUj6iAGYU0oWlfeI9pDa1GrG5IuOl6jX2i2-us0kups5FXz98_49wo-VWl0kWE_2tgifVDng17gGljmDhUSwTa3mRLk7xBHrcqRDctVLhJ_Z5aBqX=s3654)
