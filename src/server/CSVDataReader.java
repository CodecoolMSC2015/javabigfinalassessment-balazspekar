package server;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashSet;
import java.util.Set;

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
		Set<Person> result = new HashSet<Person>();

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
						result.add(createPersonObject(line));
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
		//System.out.println(line);
		String csvSplitBy = ",";
		String[] lineData = line.split(csvSplitBy);
		//System.out.println("Name: " + lineData[0]);
		//System.out.println("Email: " + lineData[1]);
		return new Person(lineData[0], lineData[1]);
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
