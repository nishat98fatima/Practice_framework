package Utilitiy;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;

import org.json.JSONArray;
import org.json.JSONObject;

public class jsonread {
	public static String read_json(String Scenario_keyword) throws Throwable {
		String variable = "";
		JSONObject main_json = new JSONObject();
		HashMap<String, Object> excel_data = new HashMap<>();
		excel_data = GetDataFromExcel.read_excel_as_map(Scenario_keyword);
		
		if (String.valueOf(excel_data.get("json_file_path")).contains(".json")) {
			String file_path=System.getProperty("user.dir") + "/src/test/java/RequestBody/" + excel_data.get("json_file_path");
			variable = Files.readString(Paths.get(file_path));
			System.out.println(Scenario_keyword);
			System.out.println(excel_data);
					
			System.out.println(file_path);
		}

		else {

			main_json.put("id", Integer.parseInt(String.valueOf(excel_data.get("id"))));
			main_json.put("name", String.valueOf(excel_data.get("name")));
			main_json.put("status", String.valueOf(excel_data.get("status")));
			JSONObject category = new JSONObject();
			category.put("id", Integer.parseInt(String.valueOf(excel_data.get("category_id"))));
			category.put("name", excel_data.get("category_name"));
			main_json.put("category", category);

			JSONArray tags_arr = new JSONArray();
			JSONObject tags_obj = new JSONObject();
			tags_obj.put("id", Integer.parseInt(String.valueOf(excel_data.get("tags_id"))));
			tags_obj.put("name", String.valueOf(excel_data.get("tags_name")));

			tags_arr.put(tags_obj);
			main_json.put("tags", tags_arr);

			JSONArray photo_urls = new JSONArray();
			photo_urls.put(String.valueOf(excel_data.get("photoUrl")));

			main_json.put("photoUrls", photo_urls);
			variable = main_json.toString();
		}
		return variable;
	}

	public static void main(String args[]) throws Throwable {
		// System.out.println(jsonread.read_json("TC_01"));
		JSONObject json = new JSONObject();
		// json.put("Nishat");
	}
}
