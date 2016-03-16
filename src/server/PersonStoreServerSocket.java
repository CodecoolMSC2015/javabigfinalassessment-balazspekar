package server;

import java.util.Set;

import server.csvhandling.CSVDataReader;
import server.csvhandling.DataReader;
import server.csvhandling.SearchType;
import server.prospects.Person;

public class PersonStoreServerSocket
{

	private DataReader store = new CSVDataReader("D:\\persons.csv");

	public void start()
	{
		store.setSearchType(SearchType.OPTIONAL);
		store.setSerachCriteria("Java");
		Set<Person> filteredPersons = store.getPersons();
		System.out.println(filteredPersons);
	}

	public static void main(String[] args)
	{
		System.out.println("Starting Storage Server");
		new PersonStoreServerSocket().start();
	}

}
