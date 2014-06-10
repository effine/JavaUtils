/**
 * @author verphen
 * @date 2014年6月10日  下午2:55:52
 */

package com.verphen.mail;

import javax.mail.PasswordAuthentication;

public class MyAuthenticator {
	String userName = null;
	String password = null;

	public MyAuthenticator() {
	}

	public MyAuthenticator(String username, String password) {
		this.userName = username;
		this.password = password;
	}

	protected PasswordAuthentication getPasswordAuthentication() {
		return new PasswordAuthentication(userName, password);
	}
}
