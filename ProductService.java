
import java.util.ArrayList;
import java.util.Locale.Category;

public class ProductService {
    // making references and creating variables!
    Product product;
     ArrayList<Product> properties = Product.getProductsList();
    String prodName;
    
    Product pro_obj, temp_obj;

    // Creating an array list of product type
    ArrayList<Product> newList = new ArrayList<>();

    
    public String findNameByCode(int product) {
        try{
            properties.forEach(
                    pro -> {
                        if (product == pro.getProductCode()) {
                            prodName = pro.getName();

                        } 

                    });
                    return (" your Product Name is: " + prodName);
                }
           
        catch (Exception e){
            prodName = null;
            return ("Product Name: " + prodName);// - If no product is found for the given product code, return null
        }
       
    }

    double temp = 0.00;
    
    public Product findMaxPriceProduct(String catagory) {
        
        try{
            properties.forEach(
                pro-> {
                    if (catagory.equals(pro.getCategory())) {
                        pro_obj = pro;
                        if (temp < pro.getPrice()) {
                            temp = pro.getPrice();
                            temp_obj = pro;
                        }
                    }   
                });
       
        }
        catch (Exception e){
            pro_obj= null;//// - If no product is found for the given category, return null
        }
        return (temp_obj);
        }

    
    public ArrayList<Product> getProductsByCategory(String catagory) {
        properties.forEach(
                pro -> {
                    if (catagory.equals(pro.getCategory())) {
                        newList.add(pro);
                    } else {
                        pro_obj = null;
                    }
                });
        return newList;// - If no product are found for the given category, return null
    }
}