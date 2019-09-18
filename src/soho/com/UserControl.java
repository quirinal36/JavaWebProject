package soho.com;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

public class UserControl {

	public User getUser(String input, int id) {
		User user = null;
		
		JSONObject json = new JSONObject(input);
		JSONArray array = json.getJSONArray("list");
		int i = 0;
		while(user == null) {
			if(id == i) {
				JSONObject item = array.getJSONObject(i);
				user = User.parse(item);
			}
			i++;
		}
		user.setId(id);
		return user;
	}
	
	public List<User> getUsersFromString(String input){
		List<User> result = new ArrayList<User>();
		JSONObject obj = new JSONObject(input);
		JSONArray array = obj.getJSONArray("list");
		for(int i=0; i<array.length(); i++) {
			User user = new User();
			JSONObject item = array.getJSONObject(i);
			user = User.parse(item);
			result.add(user);
		}
		return result;
	}
}
