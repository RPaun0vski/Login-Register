package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.DAO;
import model.User;

/**
 * Servlet implementation class LoginController
 */
@WebServlet("/LoginController")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public LoginController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		if(action!=null && action.length()>0) {
			switch (action) {
			case "Logout":
				request.getSession().invalidate();
				response.sendRedirect("index.jsp");
				break;

			default:
				break;
			}
		}else {
			response.getWriter().println("Error 403, Bad request");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DAO dao = new DAO();


		String action = request.getParameter("action");
		if(action!=null && action.length()>0) {
			switch (action) {
			case "Login":
				String username = request.getParameter("username");
				String password = request.getParameter("password");

				if(username!=null && username.length()>0 && password!=null && password.length()>0) {
					User user= dao.selectUsersByUsernameAndPassword(username, password);

					if(user!=null) {
						// sesije
						//1.nacin
						/*
						HttpSession sesija = request.getSession();
						sesija.setAttribute("user", user);
						 */
						//2.nacin
						request.getSession().setAttribute("user", user); //SESIJA

						response.sendRedirect("prikaz.jsp");
					}else {
						request.setAttribute("msg", "Pogresni parametri za logovanje");
						request.getRequestDispatcher("index.jsp").forward(request, response);
					}
				}else {
					request.setAttribute("msg", "Morate popuniti sva polja");
					request.getRequestDispatcher("index.jsp").forward(request, response);
				}
				break;
			case "Register":
				String ime = request.getParameter("ime");
				String prezime = request.getParameter("prezime");
				String godiste = request.getParameter("godiste");
				username = request.getParameter("username");
				password = request.getParameter("password");
				String password2 = request.getParameter("password2");

				if(ime!=null && ime.length()>0 &&
						prezime!=null && prezime.length()>0 &&
						godiste!=null && godiste.length()>0 && 
						username!=null && username.length()>0 && 
						password!=null && password.length()>0 &&
						password2!=null && password2.length()>0) {


					if(password.equals(password2)) {
						try {
							int g = Integer.parseInt(godiste);
							
							if(!dao.selectUsersByUsername(username)) {
								dao.insertUser(new User(ime, prezime, g, username, password));
								request.setAttribute("msg", "Username: '"+username+"' je uspesno registrovan");
								request.getRequestDispatcher("register.jsp").forward(request, response);
								
							}else {
								request.setAttribute("msg", "Username: '"+username+"' je zauzet");
								request.getRequestDispatcher("register.jsp").forward(request, response);
							}
						} catch (Exception e) {
							request.setAttribute("msg", "Godiste mora biti broj");
							request.getRequestDispatcher("register.jsp").forward(request, response);
						}

					}else {
						request.setAttribute("msg", "Sifre se ne poklapaju");
						request.getRequestDispatcher("register.jsp").forward(request, response);
					}
					
				}else {
					request.setAttribute("msg", "Morate popuniti sva polja");
					request.getRequestDispatcher("register.jsp").forward(request, response);
				}
				break;

			default:
				break;
			}

		}else {
			response.getWriter().println("Error 403, Bad request");
		}
	}

}
