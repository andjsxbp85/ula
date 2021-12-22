package Utils.SSH;

public class ListQuery {
    //ALL DEFAULT QUERY > EXAMPLE
    String queryMutasi = "INSERT INTO core_dev_box.bank_statements " +
            "(bank_id, account_number, debit, credit, remark, description, currency, status, type, used, transaction_type, transaction_id, hash_code, notes, created_at, transferred_at, version)\n" +
            "VALUES ("+"'bca', '5465387111', 0, 6550, 'lorem', 'ipsum', 'IDR', 1, 1, 0, null, null, 'f648dff8e41c6c29431dfed6f737dfd7be91ea35507772eebce793472db408e9708a700d5a52133815d28afebbb77495121c329be39264e874a51a76250f1781', '', 1603321494, 1603321494, null)";
    String queryHapusCreateDigitalProdTrf = "DELETE FROM core_dev_box.digital_products WHERE id = 1";
    //atau
    String queryHapusCreateDigitalProdTrf2 = "DELETE FROM core_dev_box.digital_products WHERE account_number = '+6281217894255'";
}
