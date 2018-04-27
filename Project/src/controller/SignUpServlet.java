package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UserDao;

/**
 * Servlet implementation class SingnUpServlet
 */
@WebServlet("/SignUpServlet")
public class SignUpServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public SignUpServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 新規作成画面のjspにフォワード
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/signUp.jsp");
		dispatcher.forward(request, response);


	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// リクエストパラメータの文字コードを指定
        request.setCharacterEncoding("UTF-8");

		// 入力した情報を全て取得する
		String loginId = request.getParameter("loginId");
        String name = request.getParameter("name");
        String birthDate = request.getParameter("birth_date");
        String password = request.getParameter("password");
        String passwordCheck = request.getParameter("passwordcheck");

        if (!password.equals(passwordCheck)) {
            request.setAttribute("errMsg1", "入力された内容は正しくありません。");
    		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/signUp.jsp");
    		dispatcher.forward(request, response);
      		return;
		}

        UserDao user = new UserDao();
  		boolean i = user.matchingId(loginId);

  		if (i) {
			request.setAttribute("errMsg2", "既に存在しているログインIDです。再入力をして下さい。");

			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/signUp.jsp");
			dispatcher.forward(request, response);
			return;
		}

    	UserDao userDao = new UserDao(); //ｲﾝｽﾀﾝｽを作って
  		userDao.create(loginId,name,birthDate,password);  //createメソッドに値を渡す

  		response.sendRedirect("UserListServlet");  //responseでユーザ一覧画面に戻る



	}

}
