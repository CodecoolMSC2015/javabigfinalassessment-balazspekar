package server;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Set;

import client.Person;

public class CSVDataReader extends DataReader
{

	private String csvFilePath;

	public CSVDataReader(String csvFilePath)
	{
		this.csvFilePath = csvFilePath;
	}

	@Override
	public Set<Person> getPersons()
	{
		String line = "";
		BufferedReader br;
		String csvSplitBy = ",";
		Set<Person> result = null;

		if (searchType == SearchType.OPTIONAL)
		{
			try
			{
				br = new BufferedReader(new FileReader(csvFilePath));
				while ((line = br.readLine()) != null)
				{
					String[] lineData = line.split(csvSplitBy);
					if (lineData[2].equals(searchCriteria))
					{
						createPersonObject(line);
					}
				}
			}
			catch (Exception e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

		return result;
	}

	private Person createPersonObject(String line)
	{

		System.out.println("CPO");
		System.out.println(line);
		return null;
	}

	@Override
	public void setSerachCriteria(String searchcriteria)
	{
		this.searchCriteria = searchcriteria;
	}

	@Override
	public void setSearchType(SearchType searchtype)
	{
		this.searchType = searchtype;
	}

}
