package org.se.lab;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.logging.Logger;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*
 * Test-Servlet
 * 
 * This servlet is for testing purposes only!!
 * 
 * There is no error handling code and no user interface.
 * Method calls are send directly as GET requests using querie parameters.
 * 
 * Example: http://localhost:8080/maven-jpa-simple/test?action=insert&name=homer   
 */

@WebServlet("/test")
public class TestServlet extends HttpServlet
{
	private static final long serialVersionUID = 1L;
	private final Logger LOG = Logger.getLogger(UserManager.class.getName());
	
	@Inject
	UserManager manager;

	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
		throws ServletException, IOException
	{		
		String action = req.getParameter("action");
		String name = req.getParameter("name");

		LOG.info("doGet(" + action + ", " + name + ")");

		PrintWriter writer = resp.getWriter();
		StringBuilder out = new StringBuilder();
		switch(action)
		{
			case "insert":
				User user = manager.insert(name);
				out.append("inserted " + user );
				break;
				
			case "findAll":
				List<User> users = manager.findAll();
				for(User u : users)
				{
					out.append('\t').append(u).append('\n');
				}
				break;
				
			default:
				out.append("Unknown action: " + action);
				break;
		}
			
		 writer.write(out.toString());
		 writer.close();
	}
}
