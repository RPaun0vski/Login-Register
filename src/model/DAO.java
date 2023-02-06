// vazni importi 
package model;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.util.ArrayList;
public class DAO {
      private DataSource ds;

// DEFINICIJA KONEKCIONIH STRINGOVA
	private static String SELECTUSERS = "SELECT * FROM users";
	
	private static String SELECTUSERSBY_USERNAME_AND_PASSWORD = "SELECT * FROM users where username = ? AND password = ?";
	private static String SELECTUSERSBY_USERNAME = "SELECT * FROM users where username = ?";
	
	private static String INSERT_USER = "INSERT INTO users (ime, prezime, godiste, username, password) VALUES (?,?,?,?,?)";
	
	// DEFINICIJA KONSTRUKTORA ZA PODESAVNJE KONEKCIJE – UVEK ISTO
	public DAO(){
	try {
		InitialContext cxt = new InitialContext();
		if ( cxt == null ) { 
		} 
		ds = (DataSource) cxt.lookup( "java:/comp/env/jdbc/mysql" ); 
		if ( ds == null ) { 
		} 		
		} catch (NamingException e) {
		}
	}
	// DEFINICIJA METODE 
	public ArrayList<User> selectUsers(){
		Connection con = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		// POMOCNE PROMENLJIVE ZA KONKRETNU METODU 
		ArrayList<User> lo = new ArrayList<User>();
		User pom = null;
				
            try {
			con = ds.getConnection();
			pstm = con.prepareStatement(SELECTUSERS);

			// DOPUNJAVANJE SQL STRINGA, SVAKI ? SE MORA PODESITI 
//			pstm.setString(1, ime);
			pstm.execute();

//****POCETAK AKO UPIT VRACA REZULTAT TREBA SLEDECI DEO 
			rs = pstm.getResultSet();

			while(rs.next()){ // if UMESTO while AKO UPIT VRACA JEDAN REZULTAT
				// KREIRANJE INSTANCE KLASE PREKO PODRAZUMEVANOG KONSTRUKTORA
				pom = new User();
				// SET-OVANJE SVIH ATRIBUTA KLASE SA ODGOVARAJUCIM VREDNOSTIMA IZ RESULTSET-A rs
				pom.setId(rs.getInt("id"));
				pom.setIme(rs.getString("ime"));
				pom.setPrezime(rs.getString("prezime"));
				pom.setGodiste(rs.getInt("godiste"));
				pom.setUsername(rs.getString("username"));
				pom.setPassword(rs.getString("password"));
				// DODAVANJE INSTANCE U LISTU AKO METODA VRACA LISTU, AKO NE VRACA ONDA NE TREBA 
				lo.add(pom);
			}
//****KRAJ OBRADE ResultSet-a	
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		// VRACANJE REZULTATA AKO METODA VRACA REZULTAT
		return lo; 
	}
	// DEFINICIJA OSTALIH METODA ... 
	public User selectUsersByUsernameAndPassword(String username, String password){
		Connection con = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		// POMOCNE PROMENLJIVE ZA KONKRETNU METODU 
		User pom = null;
				
            try {
			con = ds.getConnection();
			pstm = con.prepareStatement(SELECTUSERSBY_USERNAME_AND_PASSWORD);

			// DOPUNJAVANJE SQL STRINGA, SVAKI ? SE MORA PODESITI 
			pstm.setString(1, username);
			pstm.setString(2, password);
			pstm.execute();

//****POCETAK AKO UPIT VRACA REZULTAT TREBA SLEDECI DEO 
			rs = pstm.getResultSet();

			if(rs.next()){ // if UMESTO while AKO UPIT VRACA JEDAN REZULTAT
				// KREIRANJE INSTANCE KLASE PREKO PODRAZUMEVANOG KONSTRUKTORA
				pom = new User();
				// SET-OVANJE SVIH ATRIBUTA KLASE SA ODGOVARAJUCIM VREDNOSTIMA IZ RESULTSET-A rs
				pom.setId(rs.getInt("id"));
				pom.setIme(rs.getString("ime"));
				pom.setPrezime(rs.getString("prezime"));
				pom.setGodiste(rs.getInt("godiste"));
				pom.setUsername(rs.getString("username"));
				pom.setPassword(rs.getString("password"));
				// DODAVANJE INSTANCE U LISTU AKO METODA VRACA LISTU, AKO NE VRACA ONDA NE TREBA 
			}
//****KRAJ OBRADE ResultSet-a	
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		// VRACANJE REZULTATA AKO METODA VRACA REZULTAT
		return pom; 
	}
	
	public boolean selectUsersByUsername(String username){
		Connection con = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		// POMOCNE PROMENLJIVE ZA KONKRETNU METODU 
		boolean rez = false;		
            try {
			con = ds.getConnection();
			pstm = con.prepareStatement(SELECTUSERSBY_USERNAME);

			// DOPUNJAVANJE SQL STRINGA, SVAKI ? SE MORA PODESITI 
			pstm.setString(1, username);
			pstm.execute();

//****POCETAK AKO UPIT VRACA REZULTAT TREBA SLEDECI DEO 
			rs = pstm.getResultSet();

			if(rs.next()){ // if UMESTO while AKO UPIT VRACA JEDAN REZULTAT
				rez = true;
			}
//****KRAJ OBRADE ResultSet-a	
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		// VRACANJE REZULTATA AKO METODA VRACA REZULTAT
		
		return rez; 
	}
	
	// DEFINICIJA METODE 
		public void insertUser(User u){
			Connection con = null;
			PreparedStatement pstm = null;
			ResultSet rs = null;
			// POMOCNE PROMENLJIVE ZA KONKRETNU METODU 
					
	            try {
				con = ds.getConnection();
				pstm = con.prepareStatement(INSERT_USER);

				// DOPUNJAVANJE SQL STRINGA, SVAKI ? SE MORA PODESITI 
				pstm.setString(1, u.getIme());
				pstm.setString(2, u.getPrezime());
				pstm.setInt(3, u.getGodiste());
				pstm.setString(4, u.getUsername());
				pstm.setString(5, u.getPassword());
				
				pstm.execute();

	//****POCETAK AKO UPIT VRACA REZULTAT TREBA SLEDECI DEO 
				rs = pstm.getResultSet();

	//****KRAJ OBRADE ResultSet-a	
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			// VRACANJE REZULTATA AKO METODA VRACA REZULTAT
		}
}
