import java.util.ArrayList;

class Product {
    String name;
    double unitPrice;
    double gst;
    int quantity;

    public Product(String name, double unitPrice, double gst, int quantity) {
        this.name = name;
        this.unitPrice = unitPrice;
        this.gst = gst;
        this.quantity = quantity;
    }
}

 class ShopKeeper {
    public static void main(String[] args) {
        // Creating an ArrayList to hold product details in the basket
        ArrayList<Product> basket = new ArrayList<>();

        // Adding products to the basket
        basket.add(new Product("Leather wallet", 1100, 18, 1));
        basket.add(new Product("Umbrella", 900, 28, 3));
        basket.add(new Product("Cigarette", 200, 28, 3));
        basket.add(new Product("Honey", 100, 0, 2)); // Placeholder for future products

        // Identify the product for which maximum GST amount is paid
        Product maxGSTProduct = findProductWithMaxGST(basket);
        System.out.println("Product with Maximum GST: " + maxGSTProduct.name);

        // Calculating  the total amount to be paid to the shopkeeper
        double totalAmountToPay = calculateTotalAmount(basket);
        System.out.println("Total Amount to be Paid to the Shopkeeper: Rs." + String.format("%.2f", totalAmountToPay));
    }

    //  it is a Function to identify the product for which maximum GST amount is paid
    private static Product findProductWithMaxGST(ArrayList<Product> basket) {
        double maxGSTAmount = 0;
        Product maxGSTProduct = null;

        for (Product product : basket) {
            double gstAmount = (product.unitPrice * product.quantity * product.gst) / 100;

            if (gstAmount > maxGSTAmount) {
                maxGSTAmount = gstAmount;
                maxGSTProduct = product;
            }
        }

        return maxGSTProduct;
    }

    //  a Function to calculate the total amount to be paid to the shopkeeper
    private static double calculateTotalAmount(ArrayList<Product> basket) {
        double totalAmount = 0;

        for (Product product : basket) {
            double discount = 0;

            // Applying a 5% discount for products with a unit price of Rs. 500 or more
            if (product.unitPrice >= 500) {
                discount = (product.unitPrice * product.quantity * 5) / 100;
            }

            // Calculating the  total amount for each product (including discount)
            totalAmount += (product.unitPrice * product.quantity * (100 + product.gst) / 100) - discount;
        }

        return totalAmount;
    }
}
