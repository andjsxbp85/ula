package Steps;

import API.AddNewProductAPI;
import org.junit.Assert;

public class AddNewProductStep {
    AddNewProductAPI AddNewProductAPI;

    public void user_hit_endpoint_add_new_products_with_request_data_that_has_been_prepared_before(String title, String price, String desc, String img, String cat){
        AddNewProductAPI.buildAddNewProductHeaderReq();
        AddNewProductAPI.buildAddNewProductBodyReq(title, price, desc, img, cat);
        AddNewProductAPI.addNewProduct();
    }

    public void user_hit_endpoint_add_new_products_with_invalid_request_data_that_has_been_prepared_before(String reqBody){
        AddNewProductAPI.buildAddNewProductHeaderReq();
        AddNewProductAPI.buildAddNewProductCustomBodyReq(reqBody);
        AddNewProductAPI.addNewProduct();
    }

    public String user_mengekstrak_ID_baru_yang_terbuat_dari_add_new_produk(){
        return String.valueOf(AddNewProductAPI.extInteger("id"));
    }

    public void didapatkan_http_response_code_Add_New_Product_code(String code){
        AddNewProductAPI.httpResponseCodeExpectation(Integer.valueOf(code));
    }

    public void didapatkan_json_schema_Add_New_Product_sesuai_dengan_file_dir(String dir){
        AddNewProductAPI.schemaValidator(dir);
    }

    public void title_response_body_add_new_product_sama_dengan_title_pada_saat_request(String title) {
        Assert.assertTrue(AddNewProductAPI.extString("title").equals(title));
    }

    public void price_resposne_body_add_new_product_sama_dengan_price_pada_saat_request(String price) {
        Assert.assertTrue(AddNewProductAPI.extDouble("price").equals(Double.parseDouble(price)));
    }

    public void description_response_body_add_new_product_sama_dengan_desc_pada_saat_request(String desc) {
        Assert.assertTrue(AddNewProductAPI.extString("description").equals(desc));
    }

    public void image_url_response_body_add_new_product_sama_dengan_img_pada_saat_request(String img) {
        Assert.assertTrue(AddNewProductAPI.extString("image").equals(img));
    }

    public void category_response_body_add_new_product_sama_dengan_cat_pada_saat_request(String cat) {
        Assert.assertTrue(AddNewProductAPI.extString("category").equals(cat));
    }

    public void didapatkan_error_message_add_new_product(String msg){
        Assert.assertTrue(AddNewProductAPI.extString("err_message").equals(msg));
    }
}
