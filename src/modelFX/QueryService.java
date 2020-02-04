package modelFX;

import java.util.List;

import org.apache.jena.query.Query;
import org.apache.jena.query.QueryFactory;

public class QueryService {


	private Query query;
	private String sparqlQuery;

	public List<String> getpersonTypes()
	{
		sparqlQuery = "SELECT *";
		query = QueryFactory.create(sparqlQuery) ;
		return null;
	}
}
