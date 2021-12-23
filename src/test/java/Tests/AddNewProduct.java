package Tests;

import Steps.AddNewProductStep;
import Steps.GetProductsStep;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;

public class AddNewProduct {
    @Steps AddNewProductStep AddNewProductStep;
    @Steps GetProductsStep GetProductsStep;
    String title, price, desc, img, cat;
    String customReqBody;
    String productID;

    @Given("user prepare data for add new products with title {} price {} description {} image {} category {}")
    public void user_prepare_data_for_add_new_products_with_title_price_description_image_category(String title, String price, String desc, String img, String cat){
        this.title = title;
        this.price = price;
        this.desc = desc;
        this.img = img;
        this.cat = cat;
    }

    @Given("user prepare data for title add new products with integer value {}")
    public void user_prepare_data_for_title_add_new_products_with_integer_value(String title) {
        this.customReqBody = "{ \"title\": "+title+", \"price\": 13.5, \"description\": \"lorem ipsum set\", \"image\": \"https: //i.pravatar.cc\", \"category\": \"electronic\" }";
    }

    @Given("user prepare data for add new products request body with empty json")
    public void user_prepare_data_for_add_new_products_request_body_with_empty_json(){
        this.customReqBody = "{}";
    }

    @Given("user prepare data for add new products request body with empty object")
    public void user_prepare_data_for_add_new_products_request_body_with_empty_object(){
        this.customReqBody = "";
    }

    @Given("user prepare data for add new products request body with null")
    public void user_prepare_data_for_add_new_products_request_body_with_null(){
        this.customReqBody = "null";
    }

    @Given("user prepare data price for add new products request body with String value {}")
    public void user_prepare_data_price_for_add_new_products_request_body_with_String_value(String price){
        this.customReqBody = "{ \"title\": \"This Is Title\", \"price\": "+price+", \"description\": \"lorem ipsum set\", \"image\": \"https: //i.pravatar.cc\", \"category\": \"electronic\" }";
    }

    @When("user hit endpoint add new products with request data that has been prepared before")
    public void user_hit_endpoint_add_new_products_with_request_data_that_has_been_prepared_before(){
        AddNewProductStep.user_hit_endpoint_add_new_products_with_request_data_that_has_been_prepared_before( this.title, this.price, this.desc, this.img, this.cat);
    }

    @When("user hit endpoint add new products with invalid request data that has been prepared before")
    public void user_hit_endpoint_add_new_products_with_invalid_request_data_that_has_been_prepared_before(){
        AddNewProductStep.user_hit_endpoint_add_new_products_with_invalid_request_data_that_has_been_prepared_before(this.customReqBody);
    }

    @When("user mengekstrak ID baru yang terbuat dari add new produk")
    public void user_mengekstrak_ID_baru_yang_terbuat_dari_add_new_produk(){
        this.productID = AddNewProductStep.user_mengekstrak_ID_baru_yang_terbuat_dari_add_new_produk();
    }

    @When("user melakukan hit endpoint get product by ID yang diekstrak tadi")
    public void user_melakukan_hit_endpoint_get_product_by_ID_yang_diekstrak_tadi(){
        GetProductsStep.user_hit_endpoint_get_product_by_id(this.productID);
    }

    @Then("didapatkan http response code Add New Product {}")
    public void didapatkan_http_response_code_Add_New_Product_code(String code){
        AddNewProductStep.didapatkan_http_response_code_Add_New_Product_code(code);
    }

    @Then("didapatkan json schema Add New Product sesuai dengan file {}")
    public void didapatkan_json_schema_Add_New_Product_sesuai_dengan_file_dir(String dir){
        AddNewProductStep.didapatkan_json_schema_Add_New_Product_sesuai_dengan_file_dir(dir);
    }

    @Then("title response body add new product sama dengan {} pada saat request")
    public void title_response_body_add_new_product_sama_dengan_title_pada_saat_request(String title) {
        AddNewProductStep.title_response_body_add_new_product_sama_dengan_title_pada_saat_request(title);
    }

    @Then("price resposne body add new product sama dengan {} pada saat request")
    public void price_resposne_body_add_new_product_sama_dengan_price_pada_saat_request(String price) {
        AddNewProductStep.price_resposne_body_add_new_product_sama_dengan_price_pada_saat_request(price);
    }

    @Then("description response body add new product sama dengan {} pada saat request")
    public void description_response_body_add_new_product_sama_dengan_desc_pada_saat_request(String desc) {
        AddNewProductStep.description_response_body_add_new_product_sama_dengan_desc_pada_saat_request(desc);
    }

    @Then("image url response body add new product sama dengan {} pada saat request")
    public void image_url_response_body_add_new_product_sama_dengan_img_pada_saat_request(String img) {
        AddNewProductStep.image_url_response_body_add_new_product_sama_dengan_img_pada_saat_request(img);
    }

    @Then("category response body add new product sama dengan {} pada saat request")
    public void category_response_body_add_new_product_sama_dengan_cat_pada_saat_request(String cat) {
        AddNewProductStep.category_response_body_add_new_product_sama_dengan_cat_pada_saat_request(cat);
    }

    @Then("didapatkan error message add new product {}")
    public void didapatkan_error_message_add_new_product(String msg){
        AddNewProductStep.didapatkan_error_message_add_new_product(msg);
    }
}
