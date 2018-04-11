import java.io.*;
import java.util.*;
import java.io.IOException;
import java.io.File;
import java.util.HashMap;

public class Cart
{

HashMap<String, Double> cartItems;

public Cart(){
     cartItems = new HashMap<>();
 }

public HashMap getCartItems(){
       return cartItems;
   }

public void addToCart(String name, double price){
       cartItems.put(name, price);
   }


}
