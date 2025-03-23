import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonReader;
import javax.json.JsonObject;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.List;


public class HWDemo {

	public static void main(String[] args) {
		
		List<BookOrder> orders = new LinkedList<>();
		
		fillOrders(orders, "orders.json");
		
	}

	private static void fillOrders(List<BookOrder> orders, String filename) {
		
		 try (FileInputStream fis = new FileInputStream("orders.json");
	            JsonReader reader = Json.createReader(fis)) {
	            JsonArray jsonArray = reader.readArray();
	            jsonArray.forEach(jsonValue -> {
	            	
	                var obj = jsonValue.asJsonObject();
	                
	                int  order_num = obj.getInt("order_number");	           
	                String isbn = obj.getString("ISBN");	                
	                String book_title = obj.getString("title");	                
	                int quantity = obj.getInt("quantity");	                
	                String email = obj.getString("user_email");	                
	                String ip = obj.getString("source_ip");
	                   
	                try {
	                	BookOrder b = new BookOrder(order_num, isbn, book_title, quantity, email, ip);
	                	orders.add(b);
	                	System.out.println("Order " + b.getOrderNumber() + " accepted");
	                	//all orders are read in, and they can now be processed!! hopefully there is nothing malicious in there...
	                }
	                catch(IllegalArgumentException  e) {
	                	System.out.println("Order " + order_num + " denied...");
	                }
	            });

	        } catch (Exception e) {
	        	System.out.println("Something went wrong with reading the JSON.");
	            e.printStackTrace();
	        }
	    
		
	}

}
