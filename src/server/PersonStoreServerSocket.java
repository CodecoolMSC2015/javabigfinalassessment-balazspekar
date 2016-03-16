package server;

import java.util.Set;

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
