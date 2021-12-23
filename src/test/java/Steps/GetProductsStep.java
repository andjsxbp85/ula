package Steps;

import API.GetProductsAPI;
import io.cucumber.java.en.Then;
import org.junit.Assert;

public class GetProductsStep {
    GetProductsAPI GetAllProductsAPI;

    public void user_hit_endpoint_get_all_products_with_request_data_that_has_been_prepared_before(String param){
        GetAllProductsAPI.getAllProductList(param);
    }

    public void didapatkan_http_response_code_get_product(Integer code) {
        GetAllProductsAPI.httpResponseCodeExpectation(code);
    }

    public void didapatkan_json_schema_get_all_product_sesuai_dengan_file_success_get_all_proudct_json(String dir) {
        GetAllProductsAPI.schemaValidator(dir);
    }

    public void user_hit_endpoint_get_product_by_id(String id) {
        GetAllProductsAPI.getProductDetailByID(id);
    }

    public void didapatkan_nama_barang_dari_get_product_adalah(String name) {
        Assert.assertTrue(GetAllProductsAPI.extString("title").equals(name));
    }

    public void harga_barang_dari_get_product_adalah(Double price) {
        Assert.assertTrue(GetAllProductsAPI.extDouble("price").equals(price));
    }

    public void deskripsi_product_dari_get_product_adalah(String desc) {
        Assert.assertTrue(GetAllProductsAPI.extString("description").equals(desc));
    }

    public void kategori_product_dari_get_product_adalah(String category) {
        Assert.assertTrue(GetAllProductsAPI.extString("category").equals(category));
    }

    public void alamat_gambar_product_dari_get_product_adalah(String img) {
        Assert.assertTrue(GetAllProductsAPI.extString("image").equals(img));
    }

    public void product_dari_get_product_tersebut_memiliki_rating(Double rate) {
        Assert.assertTrue(GetAllProductsAPI.extDouble("rating.rate").equals(rate));
    }

    public void jumlah_product_yang_tersedia_dari_get_product_adalah_buah(Integer count) {
        Assert.assertTrue(GetAllProductsAPI.extInteger("rating.count").equals(count));
    }

    public void body_response_yang_didapatkan_adalah_null(){
        Assert.assertTrue(GetAllProductsAPI.gettingBodyResponse().equals("null"));
    }

    public void jumlah_list_product_yang_didapatkan_sesuai_dengan_limit(int limit){
        Assert.assertTrue(GetAllProductsAPI.extArray("").size() == limit);
        System.out.println("HASIL LIST= "+GetAllProductsAPI.extArray(""));
    }
}
