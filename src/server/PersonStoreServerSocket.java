package server;

import java.util.Set;

import client.Person;

public class PersonStoreServerSocket
{

	private DataReader store = new CSVDataReader("D:\\data.csv");

	public void start()
	{
		Set<Person> filteredPersons = store.getPersons("Git", SearchType.OPTIONAL);
	}

	public static void main(String[] args)
	{
		new PersonStoreServerSocket().start();
	}

}
