package server;

import java.util.Set;

public abstract class DataReader
{
	protected String searchCriteria;
	protected SearchType searchType;

	public abstract Set<Person> getPersons();

	public abstract void setSerachCriteria(String searchcriteria);

	public abstract void setSearchType(SearchType searchtype);
}
