## API Automation Test https://gorest.co.in/

:art: Tes ini dibuat oleh Anjas Muhammad Bangun untuk tujuan proses recruitment di Shopee ID sebagai Quality Engineer (Automation)

## Environment Test
**Website https://gorest.co.in/**
```
Framework dan Utilitas yang digunakan: Java JDK 8, Maven, Cucumber, JUnit, Serenity, Gherkin Syntax, BDD, Rest Assured
```

## How To Run
* 1. Clone atau download repository ini
* 2. Masuk ke direktori project
* 3. Open terminal
* 4. Jalankan perintah ini
```
$export test_cookie_shopee=_gorest_session=G1URrjM%2FWpvY%2Bp7n9kULb%2Fqsf83o0kH%2BOsslcIsFTFo4zRCaZlJim1EvpxLTCzJ2x4bctcY%2Fvtz%2FdG1t%2B3IKnEhmhC1rUzH%2BmhIgSiinG6n8zE3ismRQHVWxs6gldUi3coC4Db%2BhITNCENl6LZCJ8dvH%2BzMMSt0JIh13xUwiv3VrA0ewg9dyQMwE6ACYqAp4x3ST2qqHzrNag3tWXpJ%2B1PiPNESEioenXKbRLqjK%2Bqs1CvSVUwo20hfMliRzBQpUXKp0r4EUI63XTbpNiWyGxG3ibqburTSTEzGyG2gJfJF1KG1SkcWNOEOttCgaQ1Y%3D--EfURPrCjoZO%2BZoAF--OanUP1OgR%2FpQWPlp%2Fa%2BY%2BA%3D%3D
$export test_google_token_shopee=fyqOD6mG+K3y7ZFnLetPPPQpppk8UXKqp1MQdttjlXBy4YwE0tLdxdL28mMH1tfWrhnBvwJsazT9SxjZdzHp0w==
```
* 6. Jalankan shell command:
```
$mvn clean verify
```

## Report Test
**Semua report test secara otomatis ada pada http://anjasmbangun.com/shopeetest**

**Apabila link tersebut tidak dapat diakses, maka:**
```
1. Download file report di bit.ly/shopeetestreport
2. Extract file "Tes QA Engineer_(Anjas Muhammad Bangun).zip" ke dalam folder
3. Buka folder extract tersebut dan carilah file index.html
4. Buka file index.html dengan browser, semisal Google Chrome, dengan cara
5. double klik file index.html atau klik kanan file index.html kemudian pilih open with browser Google Chrome
```

## Summary
**Jumlah Tes: 5 Fitur dan 40 Scenario**

**Fitur yang dites:**
* (1) Get Access Token
* (2) Create New User
* (3) Get All User Details
* (4) Update User Details
* (5) Delete User

## Bug and Issues
**Nb: For detailed report, please refer to serenity report**

[MEDIUM] Tidak dapat menggunakan 'Limit' param pada endpoint Get User Details

[ISSUE] Nama dapat menggunakan special character >> perlu didiskusikan kembali dengan PM

## Test Coverage
**88% Passed, 13% Failed, 0% Broken**
![test_result](https://1.bp.blogspot.com/-PBRkmZWU8g8/YDIJ_nm-yaI/AAAAAAAABGM/X0Pv0XriJVMC8xjgphhry7Gn_aoScvy7gCLcBGAsYHQ/s16000/Result.png)
