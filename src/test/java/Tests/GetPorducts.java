package Tests;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import Steps.GetProductsStep;

public class GetPorducts {
    @Steps GetProductsStep GetAllProductsStep;
    String productID;
    String param;

    @Given("user prepare data for hitting get all products endpoint {string}")
    public void user_prepare_data_for_hitting_get_all_products_endpoint(String param) {
        this.param = param;
    }

    @Given("user prepare data for hitting get product endpoint by ID {}")
    public void user_prepare_data_for_hitting_get_product_endpoint_by_id(String id) {
        this.productID = id;
    }


    @When("user hit endpoint get all products with request data that has been prepared before")
    public void user_hit_endpoint_get_all_products_with_request_data_that_has_been_prepared_before() {
        GetAllProductsStep.user_hit_endpoint_get_all_products_with_request_data_that_has_been_prepared_before(this.param);
    }

    @When("user hit endpoint get product by ID tersebut")
    public void user_hit_endpoint_get_product_by_id() {
        GetAllProductsStep.user_hit_endpoint_get_product_by_id(this.productID);
    }

    @Then("didapatkan http response code Get Product {int}")
    public void didapatkan_http_response_code_get_product(Integer code) {
        GetAllProductsStep.didapatkan_http_response_code_get_product(code);
    }

    @Then("didapatkan json schema Get Product sesuai dengan file {}")
    public void didapatkan_json_schema_get_all_product_sesuai_dengan_file_success_get_all_proudct_json(String dir) {
        GetAllProductsStep.didapatkan_json_schema_get_all_product_sesuai_dengan_file_success_get_all_proudct_json(dir);
    }

    @Then("didapatkan nama barang dari get product adalah {}")
    public void didapatkan_nama_barang_dari_get_product_adalah(String name) {
        GetAllProductsStep.didapatkan_nama_barang_dari_get_product_adalah(name);
    }

    @Then("harga barang dari get product adalah {}")
    public void harga_barang_dari_get_product_adalah(Double price) {
        GetAllProductsStep.harga_barang_dari_get_product_adalah(price);
    }

    @Then("deskripsi product dari get product adalah {}")
    public void deskripsi_product_dari_get_product_adalah(String desc) {
        GetAllProductsStep.deskripsi_product_dari_get_product_adalah(desc);
    }

    @Then("kategori product dari get product adalah {}")
    public void kategori_product_dari_get_product_adalah(String category) {
        GetAllProductsStep.kategori_product_dari_get_product_adalah(category);
    }

    @Then("alamat gambar product dari get product adalah {}")
    public void alamat_gambar_product_dari_get_product_adalah(String img) {
        GetAllProductsStep.alamat_gambar_product_dari_get_product_adalah(img);
    }

    @Then("product dari get product tersebut memiliki rating {}")
    public void product_dari_get_product_tersebut_memiliki_rating(Double rate) {
        GetAllProductsStep.product_dari_get_product_tersebut_memiliki_rating(rate);
    }

    @Then("jumlah product yang tersedia dari get product adalah {} buah")
    public void jumlah_product_yang_tersedia_dari_get_product_adalah_buah(Integer count) {
        GetAllProductsStep.jumlah_product_yang_tersedia_dari_get_product_adalah_buah(count);
    }

    @Then("body response yang didapatkan adalah null")
    public void body_response_yang_didapatkan_adalah_null(){
        GetAllProductsStep.body_response_yang_didapatkan_adalah_null();
    }

    @Then("jumlah list product yang didapatkan sesuai dengan limit={}")
    public void jumlah_list_product_yang_didapatkan_sesuai_dengan_limit(int limit){
        GetAllProductsStep.jumlah_list_product_yang_didapatkan_sesuai_dengan_limit(limit);
    }
}
