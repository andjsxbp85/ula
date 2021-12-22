@regis
Feature: Register New User

  Background: User membuka app
    Given user membuka aplikasi Selendroid
    And user mengklik button 'ok' pada pop up
    And user mengklik button 'register'

  Scenario: user mengirim pesan
    When user mengisi "Singleandjsxbp85"
    And mengisi alamat "Singleanjas@alterra.id"
    And mengisi sandi "Single12345678"
    And mengisi nama lengkap "Single Anjas Muhammad"
    And memilih bahasa "Java"
    And User menyetujui kebijakan
    And user mengklik button 'Register Now'
    Then User diarahkan ke halaman validasi

#  Scenario Outline: Banyak user mengirim pesan
#    When user mengisi "<username>"
#    And mengisi alamat "<E-mail>"
#    And mengisi sandi "<Password>"
#    And mengisi nama lengkap "<Name>"
#    And memilih bahasa "<Program>"
#    And User menyetujui kebijakan
#    And user mengklik button 'Register Now'
#    Then User diarahkan ke halaman validasi
#    Examples:
#      |username|E-mail|Password|Name|Program|
#      |andjsxbp85|anjas@alterra.id|123456789|Anjas Muhammad|Java|
#      |superandjs|anjasmuhammadb123@gmail.com|987654321|Bangun Muhammad|C++|