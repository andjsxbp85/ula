package Utils;

import io.restassured.http.ContentType;
import io.restassured.http.Header;
import io.restassured.response.ValidatableResponse;
import net.serenitybdd.rest.SerenityRest;

import java.util.HashMap;

public class APIFunct extends WebExe {
    public void APIFunct(){}
    public void post(String url,int statusCode, String body){
        SerenityRest
                .given()
                .header(new Header("content-type","application/json"))
                .body(body)
                .when()
                .post(url)
                .then()
                .statusCode(statusCode);
    }

    public void post(String url,int statusCode, String body, String bearerToken){
        SerenityRest
                .given()
                .header(new Header("content-type","application/json"))
                .header(new Header("Authorization","Bearer "+bearerToken))
                .body(body)
                .when()
                .post(url)
                .then()
                .statusCode(statusCode);
    }

    public void get(String url,int statusCode, String bearerToken){
        ValidatableResponse body = SerenityRest
                .given()
                .header(new Header("Authorization","Bearer "+bearerToken))
                .contentType("application/json")
                .when()
                .log().all()
                .get(url)
                .then()
                .statusCode(statusCode);
    }

    public String gettingBodyResponse(){
        return SerenityRest.then().extract().response().getBody().asString();
    }

    public String extString(String data){
        String value = SerenityRest.then().extract().path(data);
        //String value = SerenityRest.then().extract().jsonPath().getString(data);
        return value;
    }

    public Integer extInteger(String data){
        return SerenityRest.then().extract().path(data);
    }

    public HashMap exHashMap(String data){
        return SerenityRest.then().extract().path(data);
    }

    //==================================== Universal GET, POST, PUT (Menggunakan Hashmap) ====================================
    public void getUniversal(String url,int statusCode, HashMap header, String body){
        SerenityRest
                .given()
                .headers(header)
                .body(body)
                .when()
                .get(url)
                .then()
                .statusCode(statusCode);
    }

    public void postUniversal(String url,int statusCode, HashMap header, String body){
                SerenityRest
                .given()
                    .headers(header)
                    .body(body)
                .when()
                    .post(url)
                .then()
                    .statusCode(statusCode);
    }

    public void putUniversal(String url,int statusCode, HashMap header, String body){
        SerenityRest
                .given()
                    .headers(header)
                    .body(body)
                .when()
                    .put(url)
                .then()
                    .statusCode(statusCode);
    }

    public void putUniversal(String url,int statusCode, HashMap header){
        SerenityRest
                .given()
                    .headers(header)
                .when()
                    .put(url)
                .then()
                    .statusCode(statusCode);
    }

    //=================================================== CATATAN ===================================================
}
