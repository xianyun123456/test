package enty;

public class Admin {
	private Integer id;
	private String adminName;//����Ա�˺�
	private Integer level;//����Ա����
	private String pwd;//����Ա����
	public Admin(Integer id, String adminName, Integer level, String pwd) {
		super();
		this.id = id;
		this.adminName = adminName;
		this.level = level;
		this.pwd = pwd;
	}
	public Admin() {
		super();
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getAdminName() {
		return adminName;
	}
	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}
	public Integer getLevel() {
		return level;
	}
	public void setLevel(Integer level) {
		this.level = level;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	@Override
	public String toString() {
		return "Admin [id=" + id + ", adminName=" + adminName + ", level=" + level + ", pwd=" + pwd + "]";
	}
	
}
