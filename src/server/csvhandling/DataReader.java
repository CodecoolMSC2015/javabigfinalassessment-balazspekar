package server.csvhandling;

import java.util.Set;

import server.prospects.Person;

public abstract class DataReader
{
	protected String searchCriteria;
	protected SearchType searchType;

	public abstract Set<Person> getPersons();

	public abstract void setSerachCriteria(String searchcriteria);

	public abstract void setSearchType(SearchType searchtype);
}
