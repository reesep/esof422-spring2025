
public class BookOrder {

	//this is fine
	private final int order_num;
	
	//TO DO: Define domain primitives for ISBN, Title, Quantity, Email, and SourceIPAddress
	//   --> Validate input in constructor of those classes.
	//TO DO: Make sure they are immutable
	private String isbn;
	private String title;
	private int quantity;
	private String email;
	private String source_ip_address;
	
	
	// TO DO: You will need to modify this constructor
	//  The arguments should stay the same, the body of the constructor will need to change to implement domain primitives.
	public BookOrder(int order_num, String isbn, String title, int quantity, String email, String source_ip_address) {
		try {
			this.order_num = order_num;
			this.isbn = isbn;
			this.title = title;
			this.quantity = quantity;
			this.email = email;
			this.source_ip_address = source_ip_address;
		} catch(IllegalArgumentException e) {
			//error occurred during input validation
			throw new IllegalArgumentException();
		}
	}
	
	//This method should still work after refactoring (no object memory addresses)
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(("Order Number: " + order_num  + "\n"));
		sb.append(("ISBN: " + isbn  + "\n"));
		sb.append(("Title: " + title  + "\n"));
		sb.append(("Quantity: " + quantity  + "\n"));
		sb.append(("Email: " + email  + "\n"));
		sb.append(("Source IP Address: " + source_ip_address  + "\n"));
		return sb.toString();
	}
	
	public int getOrderNumber() {
		return this.order_num;
	}
	
	
}
