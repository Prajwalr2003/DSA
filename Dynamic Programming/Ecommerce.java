import java.util.*;

class User{
    int id;
    String username;
    private String password;
    private String email;

    public User(int id, String username, String password, String email){
        this.id = id;
        this.username=username;
        this.password=password;
        this.email=email;    
    }

    public String getUsername(){
        return username;
    }

    public String getPassword(){
        return password;
    }

    public String getEmail(){
        return email;
    }

    public void setUsername(String username){
        this.username=username;
    }

    public void setPassword(String password){
        this.password=password;
    }

    public void setEmail(String email){
        this.email=email;
    }
}

class Seller extends User{
    List<Product> products;

    public Seller(User user){
        super(user.id, user.getUsername(), user.getPassword(), user.getEmail());
        this.products = new ArrayList<>();
    }

    public void addProduct(Product product){
        products.add(product);
    }

    public void deleteProduct(int id){
        for(Product p : products){
            if(p.id == id){
                products.remove(p);
                return;
            }
        }
        System.out.println("Product with ID " + id + " not found.");
    }

    public void getRecentAddedProduct(){
        Product p = products.get(products.size()-1);
        System.out.println("[ Product Name = "+p.productName+" , "+
        "Description = "+p.description+" , "+
        "Images = "+p.images+" , "+
        "Price = "+p.price+" , "+
        "Stock = "+p.stock+" ]");
    }

    public void getAllProducts(){
        for(Product p : products){
            System.out.println("[ Product Name = "+p.productName+" , "+
        "Description = "+p.description+" , "+
        "Images = "+p.images+" , "+
        "Price = "+p.price+" , "+
        "Stock = "+p.stock+" ]");
            System.out.println();
        }
    }
}

class Product{
    int id;
    String productName;
    String description;
    List<String> images = new ArrayList<>();
    double price;
    int stock;
    public Product(int id, String productName, String description, 
        List<String> images, double price, int stock){
        this.id=id;
        this.productName=productName;
        this.description=description;
        this.images.addAll(images);
        this.price = price;
        this.stock = stock;
    }

    public void getProduct(){
        System.out.println("[ Product Name = "+productName+" , "+
        "Description = "+description+" , "+
        "Images = "+images+" , "+
        "Price = "+price+" , "+
        "Stock = "+stock+" ]");
    }
}

class Ecommerce {
    public static void main(String[] args) {
        User user = new User(1, "Prajwal", "Prajwal@123", "prajwal@gmail.com");
        Seller seller = new Seller(user);

        Product apple = new Product(1, "IPhone 15 Pro Max", "The flagship most awaited phone launched recently", 
            Arrays.asList("image1", "image2", "image3"), 500.0, 30);

        Product shirt = new Product(2, "Jocky Casual T-Shirt", "The Most Branded and Purchased T-Shirt for You", 
            Arrays.asList("shirtImage1", "shirtImage2", "shirtImage3"), 200.0, 100);

        seller.addProduct(apple);
        seller.addProduct(shirt);

        // seller.getRecentAddedProduct();
        
        seller.getAllProducts();
    }
}
