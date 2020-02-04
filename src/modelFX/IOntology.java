package modelFX;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.jena.ontology.DatatypeProperty;
import org.apache.jena.ontology.ObjectProperty;
import org.apache.jena.ontology.OntClass;
import org.apache.jena.ontology.OntModel;
import org.apache.jena.ontology.OntModelSpec;
import org.apache.jena.ontology.OntResource;
import org.apache.jena.rdf.model.ModelFactory;
import org.apache.jena.rdf.model.Statement;
import org.apache.jena.rdf.model.StmtIterator;
import org.apache.jena.util.iterator.ExtendedIterator;

public class IOntology {

	private final String path_to_file = "file:C:/Users/Asus/Desktop/S10_Mines/Knowledge_Modeling/project_voyage.owl";
	private OntModel myModel;
	private HashMap<String,List<String>> classes;
	private HashMap<String,List<String>> student;
	private HashMap<String,List<String>> businessman;
	private HashMap<String,List<String>> random;
	private List<String> objects;
	private List<String> datas;

	public IOntology()
	{
		myModel = ModelFactory.createOntologyModel(OntModelSpec.OWL_MEM_MICRO_RULE_INF,null);
		classes = new HashMap<String,List<String>>();
		student = new HashMap<String,List<String>>();
		businessman = new HashMap<String,List<String>>();
		random = new HashMap<String,List<String>>();
		objects = new ArrayList<String>();
		datas = new ArrayList<String>();
		readOntology();
		readClasses();
		readTriples();
	}
	public OntModel getMyModel() {
		return myModel;
	}
	public HashMap<String, List<String>> getClasses() {
		return classes;
	}
	public void readOntology()
	{
		myModel.read(path_to_file);
	}
	public void listClass()
	{
		ExtendedIterator<OntClass> itClass = myModel.listClasses();
		while(itClass.hasNext())
		{
			System.out.println("Class : "+itClass.next().getLocalName());
		}
	}
	public void listObject()
	{
		ExtendedIterator<ObjectProperty> itObject = myModel.listObjectProperties();
		while(itObject.hasNext())
		{
			System.out.println("Object : "+itObject.next().getLocalName());
		}
	}
	public void listData()
	{
		ExtendedIterator<DatatypeProperty> itData = myModel.listDatatypeProperties();
		while(itData.hasNext())
		{
			System.out.println("Data : "+itData.next().getLocalName());
		}
	}
	public HashMap<String,List<String>> readClasses()
	{
		ExtendedIterator<OntClass> itClass = myModel.listClasses();
		while(itClass.hasNext())
		{
			OntClass superClass = itClass.next();
			try
			{
				if(superClass.getLocalName().equals("MeanOfTransport"))
				{
					ExtendedIterator<? extends OntResource> itInstances = superClass.listInstances();
					List<String> instances = new ArrayList<String>();
					while(itInstances.hasNext())
					{
						instances.add(itInstances.next().getLocalName());
					}
					classes.put(superClass.getLocalName(),instances);
				}
				if(superClass.getLocalName().equals("Person"))
				{
					ExtendedIterator<? extends OntResource> itInstances = superClass.listInstances();
					List<String> instances = new ArrayList<String>();

					while(itInstances.hasNext())
					{
						OntResource res = itInstances.next();
						instances.add(res.getLocalName());
						//System.out.println(res.getProperty(null).asTriple().getSubject().getLocalName()+","+res.getProperty(null).asTriple().getPredicate().getLocalName()+","+res.getProperty(null).asTriple().getObject().getLocalName());
					}
					classes.put(superClass.getLocalName(),instances);
				}
				if(superClass.getLocalName().equals("Place"))
				{
					ExtendedIterator<? extends OntResource> itInstances = superClass.listInstances();
					List<String> instances = new ArrayList<String>();
					while(itInstances.hasNext())
					{
						instances.add(itInstances.next().getLocalName());
					}
					classes.put(superClass.getLocalName(),instances);
				}
				if(superClass.getLocalName().equals("Travel"))
				{
					ExtendedIterator<? extends OntResource> itInstances = superClass.listInstances();
					List<String> instances = new ArrayList<String>();
					while(itInstances.hasNext())
					{
						instances.add(itInstances.next().getLocalName());
					}
					classes.put(superClass.getLocalName(),instances);
				}

			}
			catch(NullPointerException e)
			{
			}

		}
		return classes;
	}
	public List<String> getObjects()
	{
		ExtendedIterator<ObjectProperty> itObject = myModel.listObjectProperties();
		while(itObject.hasNext())
		{
			objects.add(itObject.next().getLocalName());
		}
		return objects;
	}
	public List<String> getDatas()
	{
		ExtendedIterator<DatatypeProperty> itData = myModel.listDatatypeProperties();
		while(itData.hasNext())
		{
			datas.add(itData.next().getLocalName());
		}
		return datas;
	}
	public void readTriples()
	{
		ExtendedIterator<OntClass> itClass = myModel.listClasses();
		while(itClass.hasNext())
		{
			OntClass superClass = itClass.next();
			try
			{
				if(superClass.getLocalName().equals("Person"))
				{
					ExtendedIterator<? extends OntResource> itInstances = superClass.listInstances();
					while(itInstances.hasNext())
					{
						OntResource res = itInstances.next();
						StmtIterator itRes = res.listProperties();
						List<String> meanoftransport_stravel = new ArrayList<String>();
						List<String> meanoftransport_schoose = new ArrayList<String>();
						List<String> meanoftransport_btravel = new ArrayList<String>();
						List<String> meanoftransport_bchoose = new ArrayList<String>();
						List<String> meanoftransport_rtravel = new ArrayList<String>();
						List<String> meanoftransport_rchoose = new ArrayList<String>();
						while(itRes.hasNext())
						{
							Statement state = itRes.next();
							if(state.asTriple().getSubject().getLocalName().equals("Student"))
							{
								if(state.asTriple().getPredicate().getLocalName().equals("travelsBy"))
								{
									meanoftransport_stravel.add(state.asTriple().getObject().getLocalName());
									student.put(state.asTriple().getPredicate().getLocalName(), meanoftransport_stravel);
								}
								if(state.asTriple().getPredicate().getLocalName().equals("chooseTravelType"))
								{
									meanoftransport_schoose.add(state.asTriple().getObject().getLocalName());
									student.put(state.asTriple().getPredicate().getLocalName(), meanoftransport_schoose);
								}
							}
							if(state.asTriple().getSubject().getLocalName().equals("BusinessMan"))
							{
								if(state.asTriple().getPredicate().getLocalName().equals("travelsBy"))
								{
									meanoftransport_btravel.add(state.asTriple().getObject().getLocalName());
									businessman.put(state.asTriple().getPredicate().getLocalName(), meanoftransport_btravel);
								}
								if(state.asTriple().getPredicate().getLocalName().equals("chooseTravelType"))
								{
									meanoftransport_bchoose.add(state.asTriple().getObject().getLocalName());
									businessman.put(state.asTriple().getPredicate().getLocalName(), meanoftransport_bchoose);
								}
							}
							if(state.asTriple().getSubject().getLocalName().equals("Random"))
							{
								if(state.asTriple().getPredicate().getLocalName().equals("travelsBy"))
								{
									meanoftransport_rtravel.add(state.asTriple().getObject().getLocalName());
									random.put(state.asTriple().getPredicate().getLocalName(), meanoftransport_rtravel);
								}
								if(state.asTriple().getPredicate().getLocalName().equals("chooseTravelType"))
								{
									meanoftransport_rchoose.add(state.asTriple().getObject().getLocalName());
									random.put(state.asTriple().getPredicate().getLocalName(), meanoftransport_rchoose);
								}
							}
						}
					}
				}

			}
			catch(Exception e)
			{

			}
		}
		SearchParameters.setStudentData(student);
		SearchParameters.setBusinessmanData(businessman);
		SearchParameters.setRandomData(random);
		System.out.println("Student : " +student);
		System.out.println("BusinessMan : "+businessman);
		System.out.println("Random : "+random);

	}

}
