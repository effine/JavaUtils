/**
 * @author verphen
 * @date 2014年6月11日  下午1:50:58
 */

package com.verphen.mail;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;

public class Email_Autherticatorbean extends Authenticator {
	private String m_username = null;
	private String m_userpass = null;

	public void setUsername(String username) {
		m_username = username;
	}

	public void setUserpass(String userpass) {
		m_userpass = userpass;
	}

	public Email_Autherticatorbean(String username, String userpass) {
		super();
		setUsername(username);
		setUserpass(userpass);

	}

	public PasswordAuthentication getPasswordAuthentication() {

		return new PasswordAuthentication(m_username, m_userpass);
	}
}
