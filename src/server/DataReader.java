package server;

import java.util.Set;

import client.Person;

public abstract class DataReader
{
	private String searchCriteria;
	private SearchType searchType;

	public abstract Set<Person> getPersons(String string, SearchType searchtype);

	public abstract void setSerachCriteria(String searchcriteria);

	public abstract void setSearchType(SearchType searchtype);
}
