package server;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Set;

import server.csvhandling.CSVDataReader;
import server.csvhandling.DataReader;
import server.csvhandling.SearchType;
import server.prospects.Person;

public class PersonStoreServerSocket
{
	private DataReader store = new CSVDataReader("D:\\persons.csv");
	private final int port = 3232;

	public void start()
	{

		try
		{
			ServerSocket storageServer = new ServerSocket(port);
			Socket server = storageServer.accept();
			ObjectInputStream objectFromClientSide = new ObjectInputStream(server.getInputStream());
			ObjectOutputStream objectToClientSide = new ObjectOutputStream(server.getOutputStream());

			String queryFromClient = (String) objectFromClientSide.readObject();

			System.out.println("This is is the query received from the Client: ");

			store.setSearchType(SearchType.OPTIONAL);
			store.setSerachCriteria(queryFromClient);
			Set<Person> filteredPersons = store.getPersons();
			System.out.println(filteredPersons);

			objectToClientSide.writeObject(filteredPersons);
			objectFromClientSide.close();
			objectFromClientSide.close();

		}
		catch (Exception e)
		{
			e.printStackTrace();
		}

	}

	public static void main(String[] args)
	{
		System.out.println("Starting Storage Server");
		new PersonStoreServerSocket().start();
	}

}
