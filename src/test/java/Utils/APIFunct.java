package Utils;

import io.restassured.http.Header;
import io.restassured.response.ResponseBody;
import io.restassured.response.ValidatableResponse;
import net.serenitybdd.rest.SerenityRest;

import java.util.HashMap;
import java.util.List;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

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

    //==================================== Universal GET, POST, PUT (Menggunakan Hashmap) ====================================
    public void getUniversal(String url, HashMap... header){
        if(header.length==0){
            HashMap cookie = new HashMap();
            cookie.put("Cookie",System.getenv().get("test_cookie_shopee"));
            SerenityRest
                    .given()
                    .headers(cookie)
                    .when()
                    .get(url)
                    .then();
        } else {
            SerenityRest
                    .given()
                    .headers(header[0])
                    .when()
                    .get(url)
                    .then();
        }
    }

    public void postUniversal(String url, HashMap header, String body){
        SerenityRest
                .given()
                .headers(header)
                .body(body)
                .when()
                .post(url);
    }

    public void putUniversal(String url, HashMap header, String body){
        SerenityRest
                .given()
                .headers(header)
                .body(body)
                .when()
                .put(url)
                .then();
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

    public void deleteUniversal(String url, HashMap... header){
        SerenityRest
                .given()
                .headers(header[0])
                .when()
                .delete(url)
                .then();
    }

    //==================================== Body Extraction ====================================
    public ResponseBody getResponseBody(){
        return SerenityRest.then().extract().response().getBody();
    }

    public String gettingBodyResponse(){
        return SerenityRest.then().extract().response().getBody().asString();
    }

    public List extArray(String data){
        List value = SerenityRest.then().extract().path(data);
        //String value = SerenityRest.then().extract().jsonPath().getString(data);
        return value;
    }

    public String extString(String data){
        String value = SerenityRest.then().extract().path(data);
        //String value = SerenityRest.then().extract().jsonPath().getString(data);
        return value;
    }

    public Integer extInteger(String data){
        return SerenityRest.then().extract().path(data);
    }

    public Double extDouble(String data){
        return Double.parseDouble(SerenityRest.then().extract().path(data).toString());
    }

    public HashMap extHashMap(String data){
        return SerenityRest.then().extract().path(data);
    }

    public Integer httpStatusCode() {return SerenityRest.then().extract().statusCode();}

    public String extHeader(String headerKey) {return SerenityRest.then().extract().headers().get(headerKey).toString();}

    //=================================================== Validator ===================================================
    public void schemaValidator(String namaJSchema){
        SerenityRest.then().body(matchesJsonSchemaInClasspath("JSONSchema/"+namaJSchema));
    }

    public void httpResponseCodeExpectation(int desiredHTTPResCode){
        SerenityRest.then().statusCode(desiredHTTPResCode);
    }
}