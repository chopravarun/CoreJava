package exp;

import java.util.HashMap;

public class java {
	 public static void main(String[] args) {
		 boolean isInserted = true;
		 HashMap<String, String> mappingIds = new HashMap<String, String>();
		 String stableId = "test";
		 if (isInserted && !mappingIds.containsKey(stableId) ) {			 
			 mappingIds.put(stableId, "lhlklk");
			 System.out.println("sssss");
		 }
		 if (isInserted && !mappingIds.containsKey(stableId) ) {
			 System.out.println("sssss");
		 }
	}
}
