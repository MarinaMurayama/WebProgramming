package model;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.sun.org.apache.xerces.internal.impl.xpath.regex.ParseException;

import common.Common;

/**
 * Userテーブルのデータを格納するためのBeans
 * @author takano
 *
 */
public class User {
	private int id;
	private String loginId;
	private String name;
	private Date birthDate;
	private String password;
	private String createDate;
	private String updateDate;

	// ログインセッションを保存するためのコンストラクタ
	public User(String loginId, String name) {
		this.loginId = loginId;
		this.name = name;
	}

	// 詳細情報を保存するためのコンストラクタ(ﾊﾟｽﾜｰﾄﾞ含むﾊﾞｰｼﾞｮﾝ)
		public User(String loginId, String name,Date birthDate,String createDate,String updateDate,String password) {
			this.loginId = loginId;
			this.name = name;
			this.birthDate = birthDate;
			this.createDate = createDate;
			this.updateDate = updateDate;
			this.password = password;
		}
	// 詳細情報を保存するためのコンストラクタ(ﾊﾟｽﾜｰﾄﾞは更新しないﾊﾞｰｼﾞｮﾝ)
		public User(String loginId, String name,Date birthDate,String createDate,String updateDate) {
			this.loginId = loginId;
			this.name = name;
			this.birthDate = birthDate;
			this.createDate = createDate;
			this.updateDate = updateDate;
		}

	// 全てのデータをセットするコンストラクタ
	public User(int id, String loginId, String name, Date birthDate, String password, String createDate,
			String updateDate) {
		this.id = id;
		this.loginId = loginId;
		this.name = name;
		this.birthDate = birthDate;
		this.createDate = createDate;
		this.password = password;
		this.updateDate = updateDate;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getLoginId() {
		return loginId;
	}
	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getBirthDate() {
		return birthDate;
	}

	public String getBirthDateStr() {
		String str = null;
		try {
            str = new SimpleDateFormat("yyyy-MM-dd").format(birthDate);

        } catch (ParseException e) {
            e.printStackTrace();
        }
		return str;
	}

	public String getBirthDateFmt() {
		String str = null;
		try {
            str = new SimpleDateFormat("yyyy年MM月dd日").format(birthDate);

        } catch (ParseException e) {
            e.printStackTrace();
        }
		return str;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getCreateDate() {
		return createDate;
	}

	public String getCreateDateFmt() {
		String str = null;
		try {
            str = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss").format(Common.dateTimeConversion(createDate));

        } catch (ParseException e) {
            e.printStackTrace();
        }
		return str;
	}

	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}
	public String getUpdateDate() {
		return updateDate;
	}

	public String getUpdateDateFmt() {
		String str = null;
		try {
            str = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss").format(Common.dateTimeConversion(updateDate));

        } catch (ParseException e) {
            e.printStackTrace();
        }
		return str;
	}

	public void setUpdateDate(String updateDate) {
		this.updateDate = updateDate;
	}





}

