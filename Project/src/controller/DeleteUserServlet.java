package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UserDao;
import model.User;

/**
 * Servlet implementation class DeleteUserServlet
 */
@WebServlet("/DeleteUserServlet")
public class DeleteUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteUserServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String id = request.getParameter("id");
		System.out.println(id);

		UserDao userDao = new UserDao();
		User user = userDao.findByUserDetail(id); //idを使用して削除したい対象データを検索する

		request.setAttribute("User", user);  //ﾘｸｴｽﾄｽｺｰﾌﾟにｲﾝｽﾀﾝｽを保存(属性名、ｲﾝｽﾀﾝｽ)
		User u = (User)request.getAttribute("user");

		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/DeleteUser.jsp");
		dispatcher.forward(request, response);   //削除画面にﾃﾞｰﾀを渡す。
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String id = request.getParameter("id");  //削除画面でokﾎﾞﾀﾝを押したらformでidﾃﾞｰﾀが送られてくるので取得する
		System.out.println(id);  //念のためｺﾝｿｰﾙに出力

		UserDao userDao = new UserDao();
		userDao.delete(id);

		response.sendRedirect("UserListServlet");  //削除処理終了。もう処理することないのでﾘﾀﾞｲﾚｸﾄでﾕｰｻﾞ一覧画面へ

	}

}
