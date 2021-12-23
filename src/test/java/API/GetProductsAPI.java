package API;

import Utils.APIFunct;
import Utils.database;

import java.util.HashMap;

public class GetProductsAPI extends APIFunct implements database {
    String responseBody;
    Integer statusCode;

    public String getAllProductList(String param){
        //Setup Header
        HashMap header = new HashMap();
        header.put("Accept","application/json");
        header.put("Content-Type","application/json");

        //Setup Endpoint
        String endpoint = (param.equals("") || param == null) ? _baseURL + _productEP : _baseURL + _productEP + "?" + param;

        //Hit POST Method
        getUniversal(endpoint,header);

        //Save response to responseBody
        this.responseBody = gettingBodyResponse();
        this.statusCode = httpStatusCode();

        return responseBody;
    }

    public String getProductDetailByID(String id){
        //Setup Header
        HashMap header = new HashMap();
        header.put("Accept","application/json");
        header.put("Content-Type","application/json");

        //Setup Endpoint
        String endpoint = _baseURL + _productEP + "/" + id;

        //Hit POST Method
        getUniversal(endpoint,header);

        //Save response to responseBody
        this.responseBody = gettingBodyResponse();
        this.statusCode = httpStatusCode();

        return responseBody;
    }
}
