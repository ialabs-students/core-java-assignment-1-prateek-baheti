
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class Product {
    //here we declare Data members
    private int productCode;
    private String name;
    private double price;
    private String category;

    //  creating Parameterised constructor
    public Product(int productCode, String name, double price, String category) {
        this.productCode = productCode;
        this.name = name;
        this.price = price;
        this.category = category;
    }

    // Getters and Setters
    public int getProductCode() {
        return productCode;
    }

    public void setProductCode(int productCode) {
        this.productCode = productCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public static ArrayList<Product> getProductsList() //here we take return type arraylist<product> becz the return type is array of list
    {
        // here we are Creating user defined Product Array List
        ArrayList<Product> container = new ArrayList<>();
        Product prop1= new Product(1, "Tshirt", 300.0, "cloths");
        Product prop2 = new Product(2, "shirt", 399, "cloths");
        Product prop3= new Product(3, "lower", 2999.00, "cloths");
        Product  prop4= new Product(4, "samsung", 20999.00, "mobile");
        Product prop5= new Product(5, "apple", 60999.00, "mobile");
        Product prop6= new Product(6, "nokia", 60999.00, "mobile");
        // Adding properties inside the list
        container.add(prop1);
        container.add(prop2);
        container.add(prop3);
        container.add(prop4);
        container.add(prop5);
        container.add(prop6);
        //here we are returning the array of list
        return container;
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("enter yours code");
        int product_Id=sc.nextInt();
        System.out.println("enter yours product name for finding max price");
        sc.nextLine();
        String product_Name=sc.nextLine();
        System.out.println("enter yours product name to display their category");
        String product_categories =sc.nextLine();
        
        // now we have to create the object of class productservice
        ProductService productService = new ProductService();
        //now here we are calling the fun of class productservice with one argument
        System.out.println(productService.findNameByCode(product_Id));
        

        // calling the method findMaxPriceProduct from Product service and pass the one argument
        System.out.println(productService.findMaxPriceProduct(product_Name));//// It will return product object
        
        // calling the method getProductsByCatagory from Product service and pass the

        ArrayList<Product> products = productService.getProductsByCategory(product_categories);
        if (products != null) {
            Iterator iterate = products.iterator();
            while (iterate.hasNext()) {
                Product product = (Product) iterate.next();
                System.out.println("[ product code: " + product.getProductCode() + ", product name: "
                        + product.getName() + ", product price: Rs." + product.getPrice() + ", product catagory: "
                        + product.getCategory() + " ]"); // it will return the list of products
            }
        }
    }
}