package modelFX;

import java.util.HashMap;
import java.util.List;

public class SearchParameters {

	private static HashMap<String,List<String>> studentData;
	private static HashMap<String,List<String>> businessmanData;
	private static HashMap<String,List<String>> randomData;


	public static HashMap<String, List<String>> getStudentData() {
		return studentData;
	}
	public static void setStudentData(HashMap<String, List<String>> studentData) {
		SearchParameters.studentData = studentData;
	}
	public static HashMap<String, List<String>> getBusinessmanData() {
		return businessmanData;
	}
	public static void setBusinessmanData(HashMap<String, List<String>> businessmanData) {
		SearchParameters.businessmanData = businessmanData;
	}
	public static HashMap<String, List<String>> getRandomData() {
		return randomData;
	}
	public static void setRandomData(HashMap<String, List<String>> randomData) {
		SearchParameters.randomData = randomData;
	}


}
