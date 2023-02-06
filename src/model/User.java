package model;

public class User {
	private int id;
	private String ime, prezime;
	private int godiste;
	private String username, password;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getIme() {
		return ime;
	}
	public void setIme(String ime) {
		this.ime = ime;
	}
	public String getPrezime() {
		return prezime;
	}
	public void setPrezime(String prezime) {
		this.prezime = prezime;
	}
	public int getGodiste() {
		return godiste;
	}
	public void setGodiste(int godiste) {
		this.godiste = godiste;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	public User(String ime, String prezime, int godiste, String username, String password) {
		super();
		this.ime = ime;
		this.prezime = prezime;
		this.godiste = godiste;
		this.username = username;
		this.password = password;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", ime=" + ime + ", prezime=" + prezime + ", godiste=" + godiste + ", username="
				+ username + ", password=" + password + "]";
	}
	
	
}
