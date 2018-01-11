package shop.test.features.utils.populate;


import org.elasticsearch.action.index.IndexResponse;
import shop.entity.product.Product;
import shop.test.features.getdata.ProductsFromXML;
import shop.test.features.utils.ElasticCRUD;

import java.util.ArrayList;

public class PopulateElasticByProducts {
    public static void populate() {
        ProductsFromXML p = new ProductsFromXML();
        System.out.println("qq");
        ArrayList<Product> products = p.GetProducts();
        System.out.println("qq1");
        System.out.println(products.size());
        System.out.println("start populate");
        int i=0;
        for (Product product : products) {
//            System.out.println(i++);
          IndexResponse resp= ElasticCRUD.put("products", "product", product.getProductId(), product.getXContent());
//            System.out.println(resp);

        }
    }
}
/*
        curl -XGET 'localhost:9200/products/product/_count?pretty' -H 'Content-Type: application/json' -d'
        {
        "query" : {
         "match_all" : {}
        }
        }
        '
*/