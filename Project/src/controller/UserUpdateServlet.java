package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.Common;
import dao.UserDao;
import model.User;

/**
 * Servlet implementation class UserUpdateServlet
 */
@WebServlet("/UserUpdateServlet")
public class UserUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserUpdateServlet() {
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
		User user = userDao.findByUserDetail(id);

		request.setCharacterEncoding("UTF-8");
		request.setAttribute("User", user);  //ﾘｸｴｽﾄｽｺｰﾌﾟにｲﾝｽﾀﾝｽを保存(属性名、ｲﾝｽﾀﾝｽ)
		User u = (User)request.getAttribute("user");

		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/update.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		request.setAttribute("errMsg1", "入力された内容は正しくありません。");

		// 入力した情報を全て取得する
		String loginId = request.getParameter("loginId");
        String name = request.getParameter("name");
        String birthDate = request.getParameter("birth_date");
        String password = request.getParameter("password");
        String passwordCheck = request.getParameter("passwordcheck");

        if ( passwordCheck == null ||  password == null ) {
        	UserDao userDao = new UserDao();
    		userDao.update(loginId,name,birthDate);
    		response.sendRedirect("UserListServlet");  //responseでユーザ一覧画面に戻る
        }


        if (password.equals(passwordCheck)) {
        	UserDao userDao = new UserDao();
    		userDao.update(loginId,name,birthDate,password);

    		response.sendRedirect("UserListServlet");  //responseでユーザ一覧画面に戻る
		}else {
			 request.setAttribute("errMsg1", "入力された内容は正しくありません。");

			 User user = new User(loginId, name, Common.dateConversion(birthDate), null, null, password);  //date型がうまく変換できないのでCommonｸﾗｽを新たに作成して変換メソッドをつくる

			request.setAttribute("User", user);  //ﾘｸｴｽﾄｽｺｰﾌﾟにｲﾝｽﾀﾝｽを保存(属性名、ｲﾝｽﾀﾝｽ)

			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/update.jsp");
			dispatcher.forward(request, response);
			return;
		}


	}

}
