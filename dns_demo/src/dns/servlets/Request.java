package dns.servlets;

import java.io.IOException;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

import dns.beans.Coyote;

public class Request extends HttpServlet {

	public void doGet( HttpServletRequest request, HttpServletResponse response )	throws ServletException, IOException {

		String Adresse = request.getParameter("domain");
		String message = null;
		String url = "jdbc:mysql://127.0.0.1:3306/cascadon_matching";
		String utilisateur = "cascadon_root";
		String motDePasse = "YVVeguhO07";
		Connection connexion = null;
		
		try {
			Class.forName( "com.mysql.jdbc.Driver" );
		} catch ( ClassNotFoundException e ) {

		}
		
		try {
			connexion = (Connection) DriverManager.getConnection( url,  utilisateur, motDePasse );
			System.out.println("coonection effectuée)");
			java.sql.Statement statement = connexion.createStatement();
			ResultSet resultat = statement.executeQuery( "SELECT ip FROM matching WHERE domain = '"+Adresse+"';" );
			resultat.next();
			message = resultat.getString( "ip" );
		} catch ( SQLException e ) {

		} finally {
			if ( connexion != null )
				try {
					connexion.close();
				} catch ( SQLException ignore ) {

				}

			request.setAttribute( "test", message );
			request.setAttribute( "add", Adresse );
			this.getServletContext().getRequestDispatcher( "/WEB-INF/Main.jsp" ).forward( request, response );


		}
	}
}
