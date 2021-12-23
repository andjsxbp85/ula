package API;

import Utils.APIFunct;
import Utils.database;
import io.restassured.response.ResponseBody;

import java.util.HashMap;
import java.util.Map;

public class AddNewProductAPI extends APIFunct implements database {
    String requestBody;
    HashMap requestHeader = new HashMap();;
    ResponseBody responseBody;
    int statusCode;

    public void buildAddNewProductBodyReq(String title, String price, String desc, String img, String cat){
        this.requestBody = "{ \"title\": \""+title+"\", \"price\": "+price+", \"description\": \""+desc+"\", \"image\": \""+img+"\", \"category\": \""+cat+"\" }";
    }

    public void buildAddNewProductCustomBodyReq(String reqBody){
        this.requestBody = reqBody;
    }

    public void buildAddNewProductHeaderReq(Map... keyValue){
        this.requestHeader.clear();
        this.requestHeader.put("Accept","application/json");
        this.requestHeader.put("Content-Type","application/json");
        if(keyValue.length!=0) this.requestHeader.putAll(keyValue[0]);
    }

    public String addNewProduct(){
        //Setup Endpoint
        String endpoint = _baseURL + _productEP;

        //Hit POST Method
        postUniversal(endpoint, this.requestHeader, this.requestBody);

        //Save response to responseBody
        this.responseBody = getResponseBody();
        this.statusCode = httpStatusCode();

        return responseBody.toString();
    }
}
