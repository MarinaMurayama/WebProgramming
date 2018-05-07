package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import common.Common;
import model.User;

/**
 * ユーザテーブル用のDao
 * @author takano
 *
 */
public class UserDao {

    /**
     * ログインIDとパスワードに紐づくユーザ情報を返す
     * @param loginId
     * @param password
     * @return
     */
    public User findByLoginInfo(String loginId, String password) {  //★★ログイン用
    	Connection conn = null;
        try {
            // データベースへ接続
            conn = DBManager.getConnection();
            // SELECT文を準備
            String sql = "SELECT * FROM user WHERE login_id = ? and password = ?";

             // SELECTを実行し、結果表を取得
            PreparedStatement pStmt = conn.prepareStatement(sql);  //ステートメント発行
            pStmt.setString(1, loginId);
            pStmt.setString(2, Common.encryption(password));  //?の部分に入力した値をセットしている＆暗号化
            ResultSet rs = pStmt.executeQuery();  //ﾃﾞｰﾀﾍﾞｰｽを検索する

             // 主キーに紐づくレコードは1件のみなので、rs.next()は1回だけ行う
            if (!rs.next()) {
                return null;
            }

            String loginIdData = rs.getString("login_id");
            String nameData = rs.getString("name");
            return new User(loginIdData, nameData);

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        } finally {
            // データベース切断
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                    return null;
                }
            }
        }
    }

    public boolean matchingId(String loginId) {  //★★新規登録ID確認

    	Connection conn = null;
        try {
            // データベースへ接続
            conn = DBManager.getConnection();
            // SELECT文を準備
            String sql = "SELECT login_id FROM user WHERE login_id ='?'";

             // SELECTを実行し、結果表を取得
            PreparedStatement pStmt = conn.prepareStatement(sql);
            pStmt.setString(1, loginId);
            ResultSet rs = pStmt.executeQuery();

            if (!rs.next()) {
                return false;
            }

            return true;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }

    }


    public void create(String loginId,String name,String birth_date,String password) {   //★★新規データ作成
    	Connection conn = null;
        try {
          	// データベースへ接続
            conn = DBManager.getConnection();
            // INSERT文を準備
            String sql = "INSERT INTO user(login_id,name,birth_date,password,create_date,update_date)values (?,?,?,?,now(),now())";

            PreparedStatement pStmt = conn.prepareStatement(sql);
            pStmt.setString(1, loginId);
            pStmt.setString(2, name);
            pStmt.setString(3, birth_date);
            pStmt.setString(4, Common.encryption(password));


            // INSERTを実行
            int result = pStmt.executeUpdate();
            // 追加された行数を出力
            System.out.println(result);
            pStmt.close();
        } catch (SQLException e) {
            e.printStackTrace();

        } finally {
            // データベース切断
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }


    public void update(String loginId,String name,String birth_date,String password) {   //★★データ更新
    	Connection conn = null;
        try {
          	// データベースへ接続
            conn = DBManager.getConnection();

            String sql = "UPDATE user SET name=?,birth_date=?,password=?,update_date=now()  WHERE login_id = ?";

            PreparedStatement pStmt = conn.prepareStatement(sql);
            pStmt.setString(1, name);
            pStmt.setString(2, birth_date);
            pStmt.setString(3, Common.encryption(password));
            pStmt.setString(4, loginId);


            int result = pStmt.executeUpdate();
            System.out.println(result);

            pStmt.close();

        } catch (SQLException e) {
            e.printStackTrace();

        } finally {
            // データベース切断
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void update(String loginId,String name,String birth_date) {   //★★データ更新ﾊﾟｽﾜｰﾄﾞなしver
    	Connection conn = null;
        try {
          	// データベースへ接続
            conn = DBManager.getConnection();

            String sql = "UPDATE user SET name=?,birth_date=?,update_date=now()  WHERE login_id = ?";

            PreparedStatement pStmt = conn.prepareStatement(sql);
            pStmt.setString(1, name);
            pStmt.setString(2, birth_date);
            pStmt.setString(3, loginId);


            int result = pStmt.executeUpdate();
            System.out.println(result);

            pStmt.close();

        } catch (SQLException e) {
            e.printStackTrace();

        } finally {
            // データベース切断
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void delete(String id){   //★★データ削除

    	Connection conn = null;
        try {
          	// データベースへ接続
            conn = DBManager.getConnection();
            // INSERT文を準備
            String sql = "DELETE FROM user WHERE id=?";

            PreparedStatement pStmt = conn.prepareStatement(sql);
            pStmt.setString(1, id);

            int result = pStmt.executeUpdate();
            System.out.println(result);
            pStmt.close();

        } catch (SQLException e) {
            e.printStackTrace();

        } finally {
            // データベース切断
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public User findByUserDetail(String id) {    //★★ユーザ詳細

        Connection conn = null;
        try {
            // データベースへ接続
            conn = DBManager.getConnection();

            // SELECT文を準備
            String sql = "SELECT * FROM user WHERE id = ? ";

             // SELECTを実行し、結果表を取得
            PreparedStatement pStmt = conn.prepareStatement(sql);
            pStmt.setString(1, id);
            ResultSet rs = pStmt.executeQuery();

             // 主キーに紐づくレコードは1件のみなので、rs.next()は1回だけ行う
            if (!rs.next()) {
                return null;
            }

            int Id = rs.getInt("id");
            String loginIdData = rs.getString("login_id");
            String nameData = rs.getString("name");
            Date birthData = rs.getDate("birth_date");
            String createData = rs.getString("create_date");
            String updateData = rs.getString("update_date");
            String passWord = rs.getString("password");


            return new User(Id,loginIdData, nameData,birthData,passWord,createData,updateData);

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        } finally {
            // データベース切断
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                    return null;
                }
            }
        }
    }




    /**
     * 全てのユーザ情報を取得する
     * @return
     */
    public List<User> findAll() {
        Connection conn = null;
        List<User> userList = new ArrayList<User>();

        try {
            // データベースへ接続
            conn = DBManager.getConnection();

            // SELECT文を準備
            String sql = "SELECT * FROM user where login_id not in ('admin')";

             // SELECTを実行し、結果表を取得
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            // 結果表に格納されたレコードの内容を
            // Userインスタンスに設定し、ArrayListインスタンスに追加
            while (rs.next()) {
                int id = rs.getInt("id");
                String loginId = rs.getString("login_id");
                String name = rs.getString("name");
                Date birthDate = rs.getDate("birth_date");
                String password = rs.getString("password");
                String createDate = rs.getString("create_date");
                String updateDate = rs.getString("update_date");
                User user = new User(id, loginId, name, birthDate, password, createDate, updateDate);

                userList.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        } finally {
            // データベース切断
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                    return null;
                }
            }
        }
        return userList;
    }


public List<User> findConditional(String loginid,String username,String birthDate1,String birthDate2) {  //★★条件検索（ユーザ一覧画面）

	Connection conn = null;
     List<User> userList = new ArrayList<User>();

     try {
         // データベースへ接続
         conn = DBManager.getConnection();

         // SELECT文を準備
         String sql = "SELECT * FROM user where login_id not in ('admin')";  //admin以外の人を検索したいよ。

         if(!loginid.equals("")) {  //loginidの入力があったら実行
        	 sql += " and login_id = '" + loginid + "'";  //SELECT * FROM user where login_id not in ('admin') and login_id = ' 入力したID';
         }

         if(!username.equals("")) {
        	 sql += " and name LIKE '%" + username + "%'";
         }

         if( !birthDate1.equals("")) {
        	 sql += " and birth_date >= " + "'"+ birthDate1 + "'" ;
         }

         if( !birthDate2.equals("")) {
        	 sql += " and birth_date <= " + "'"+ birthDate2 + "'"  ;
         }

         System.out.println(sql);

          // SELECTを実行し、結果表を取得
         Statement stmt = conn.createStatement();
         ResultSet rs = stmt.executeQuery(sql);



//         // SELECT文を準備
//         // TODO: 未実装：管理者以外を取得するようSQLを変更する
//         String sql = "SELECT * FROM user WHERE login_id=?  OR  name LIKE ?  OR (birth_date BETWEEN ? AND ? )";
//                                                                                            ↑これだと日付を両方入力しないと検索できない。片方だけでも出来るように。
//         PreparedStatement pStmt = conn.prepareStatement(sql);
//         pStmt.setString(1, loginid);
//         pStmt.setString(2, "%"  + username + "%");
//         pStmt.setString(3, birthDate1);
//         pStmt.setString(4, birthDate2);
//
//
//          // SELECTを実行し、結果表を取得
//         ResultSet rs = pStmt.executeQuery();

         // 結果表に格納されたレコードの内容を
         // Userインスタンスに設定し、ArrayListインスタンスに追加

         while (rs.next()) {
             int id = rs.getInt("id");
             String loginId = rs.getString("login_id");
             String name = rs.getString("name");
             Date birthDate = rs.getDate("birth_date");
             String password = rs.getString("password");
             String createDate = rs.getString("create_date");
             String updateDate = rs.getString("update_date");
             User user = new User(id, loginId, name, birthDate, password, createDate, updateDate);

             userList.add(user);
         }
     } catch (SQLException e) {
         e.printStackTrace();
         return null;
     } finally {
         // データベース切断
         if (conn != null) {
             try {
                 conn.close();
             } catch (SQLException e) {
                 e.printStackTrace();
                 return null;
             }
         }
     }
     return userList;
 }
}


