package client;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.net.Socket;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Search extends HttpServlet
{
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE html>");

		String query = request.getParameter("query");

		Socket client = new Socket("localhost", 3232);
		ObjectOutputStream objectToServerSide = new ObjectOutputStream(client.getOutputStream());
		ObjectInputStream objectFromServerSide = new ObjectInputStream(client.getInputStream());

		objectToServerSide.writeObject(query);
	}

}
