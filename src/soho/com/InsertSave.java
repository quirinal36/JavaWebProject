package soho.com;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONObject;

/**
 * Servlet implementation class InsertSave
 */
@WebServlet("/insert/save")
public class InsertSave extends HttpServlet {
	public final static String FILENAME = "users.txt";
	
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertSave() {
        super();
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");

		String login = request.getParameter("login");
		String password = request.getParameter("password");
		String phone = request.getParameter("phone");
		String email = request.getParameter("email");
		String address = request.getParameter("address");
		String username = request.getParameter("username");
		
		User user = new User();
		user.setLogin(login);
		user.setPassword(password);
		user.setPhone(phone);
		user.setEmail(email);
		user.setAddress(address);
		user.setUsername(username);
		
		FileControl fileControl = new FileControl();
		String readFile = fileControl.readFile(FILENAME);
		
		if(readFile.length() > 0) {
			JSONObject json = new JSONObject(readFile);
			JSONArray array = json.getJSONArray("list");
			array.put(new JSONObject(user.toString()));
			fileControl.writeFile(FILENAME, json.toString());
		}else {
			JSONObject json = new JSONObject();
			JSONArray array = new JSONArray();
			array.put(new JSONObject(user.toString()));
			json.put("list", array);
			fileControl.writeFile(FILENAME, json.toString());
		}
		
		response.getWriter().append("입력에 성공했습니다.<br>");
		response.getWriter().append("<a href='/list.jsp'>리스트보기</a>");
	}

}
