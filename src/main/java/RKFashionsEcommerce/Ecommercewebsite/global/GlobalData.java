package RKFashionsEcommerce.Ecommercewebsite.global;

import RKFashionsEcommerce.Ecommercewebsite.model.Product;

import java.util.ArrayList;
import java.util.List;

public class GlobalData {
    public static List<Product> cart;
    static {
        cart = new ArrayList<Product>();
    }

}
