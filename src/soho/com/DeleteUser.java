package soho.com;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONObject;

/**
 * Servlet implementation class DeleteUser
 */
@WebServlet("/delete/user")
public class DeleteUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteUser() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		FileControl fileControl = new FileControl();
		UserControl userControl = new UserControl();
		
		String allUsers = fileControl.readFile(InsertSave.FILENAME);
		List<User> users = userControl.getUsersFromString(allUsers);
		try {
			users.remove(id);
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		JSONObject json = new JSONObject();
		JSONArray array = new JSONArray();
		for(User user : users) {
			array.put(new JSONObject(user.toString()));
		}
		json.put("list", array);
		fileControl.writeFile(InsertSave.FILENAME, json.toString());
		
		response.setContentType("text/html; charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.getWriter().append("삭제가 완료되었습니다.<br>");
		response.getWriter().append("<a href='/list.jsp'>리스트 보기</a>");
	}

}
