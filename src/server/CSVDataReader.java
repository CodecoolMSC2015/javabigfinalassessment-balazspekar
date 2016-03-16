package server;

import java.util.List;
import java.util.Set;

import client.Person;

public class CSVDataReader extends DataReader
{

	private String csvFilePath;
	private List<Person> persons;

	public CSVDataReader(String csvFilePath)
	{
		this.csvFilePath = csvFilePath;
	}

	@Override
	public Set<Person> getPersons(String string, SearchType searchtype)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setSerachCriteria(String searchcriteria)
	{
		// TODO Auto-generated method stub

	}

	@Override
	public void setSearchType(SearchType searchtype)
	{
		// TODO Auto-generated method stub

	}

}
