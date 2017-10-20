package enty;

public class User {
	private Integer id;
	private String userName;
	private String gender;
	private Double price;
	private Integer amount;
	private String display;
	private String pwd;
	public User(Integer id, String userName, String gender, Double price, Integer amount, String display, String pwd) {
		super();
		this.id = id;
		this.userName = userName;
		this.gender = gender;
		this.price = price;
		this.amount = amount;
		this.display = display;
		this.pwd = pwd;
	}
	public User(){
		
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public Integer getAmount() {
		return amount;
	}
	public void setAmount(Integer amount) {
		this.amount = amount;
	}
	public String getDisplay() {
		return display;
	}
	public void setDisplay(String display) {
		this.display = display;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", userName=" + userName + ", gender=" + gender + ", price=" + price + ", amount="
				+ amount + ", dispaly=" + display + ", pwd=" + pwd + "]";
	}
	
}
