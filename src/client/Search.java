package client;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import server.prospects.Person;

public class Search extends HttpServlet
{
	private static final long serialVersionUID = 1L;
	private final int port = 3232;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		String queryStringFromBrowserForm = request.getParameter("query");

		Socket client = new Socket("localhost", port);
		ObjectOutputStream objectToServerSide = new ObjectOutputStream(client.getOutputStream());
		ObjectInputStream objectFromServerSide = new ObjectInputStream(client.getInputStream());

		objectToServerSide.writeObject(queryStringFromBrowserForm);

		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE html>");

		try
		{
			Set<Person> filteredPersons = (Set<Person>) objectFromServerSide.readObject();
			out.println("<b>Query result:</b><br>");
			for (Person person : filteredPersons)
			{
				out.println(person.toString() + "<br>");
			}
		}
		catch (ClassNotFoundException e)
		{
			System.err.println("Something went wrong!");
			e.printStackTrace();
		}
	}
}