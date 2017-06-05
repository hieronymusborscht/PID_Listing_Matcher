package rgr.ent;

public class RETSImage {
	
	//int id;
	//int l_objectid;
	
	//String pid;
	
	boolean to_keep;
	java.sql.Date date_added;

	private java.util.TreeMap<String, String> string_fields;
	private java.util.TreeMap<String, Integer> int_fields;
	
	public RETSImage(){
		string_fields = new java.util.TreeMap<String, String>();
		int_fields = new java.util.TreeMap<String, Integer>();
		
		string_fields.put("remote_uri","");
		string_fields.put("l_listingid","");
		string_fields.put("host_domain","");
		string_fields.put("l_uniqueid","");
		string_fields.put("big_path","");
		string_fields.put("eight_hundred_path","");
		string_fields.put("six_forty_path","");
		string_fields.put("three_twenty_path","");
		string_fields.put("one_sixty_path","");
		string_fields.put("pid", "");
		
		int_fields.put("id", 0);
		int_fields.put("l_objectid", 0);
		
	}

	public void setIntValue(String key, int value){
		if(int_fields.containsKey(key)){
			int_fields.put(key, value);
		}
	}
	public int getIntValue(String key){
		if(int_fields.containsKey(key)){
			return int_fields.get(key);
		}else{
			return 0;
		}
	}
	
	public void setStringValue(String key, String value){
		if(string_fields.containsKey(key)){
			string_fields.put(key, value);
		}
	}
	public String getStringValue(String key){
		if(string_fields.containsKey(key)){
			return string_fields.get(key);
		}else{
			return "";
		}
	}
	
	
}
