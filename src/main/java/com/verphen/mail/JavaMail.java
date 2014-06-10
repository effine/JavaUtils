package com.verphen.mail;

/**
 * @author verphen
 * @date 2014年6月10日  下午3:14:46
 */

import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 * 
 * 
 * <p>Title: Java发送邮件测试类 /p>
 *
 * <p>Description: 示例 业务类</p>
 *
 * <p>Copyright: Copyright (c) 2012</p>
 *
 */

/****************************************************************
 * 对QQ邮箱使用（对于其他的使用类似的你应该也会更改了） 首先把QQ邮箱的POP3 SMTP打开 首先确定你的网络正常、非代理
 * 【确定你的QQ邮箱开启了SMTP】！！！！ 如果没有开启，那么这样设置下 设置->账户 --在下面-- 把这个选上 [√]SMTP发信后保存到服务器
 ****************************************************************/
public class JavaMail {

	// 设置服务器
	private static String KEY_SMTP = "mail.smtp.host";
	private static String VALUE_SMTP = "smtp.qq.com";
	// 服务器验证
	private static String KEY_PROPS = "mail.smtp.auth";
	private static boolean VALUE_PROPS = true;
	// 发件人用户名、密码
	// private String SEND_USER = "1136698201@qq.com";
	// private String SEND_UNAME = "张亚飞";
	// private String SEND_PWD = "taxrron90";

	private String SEND_USER = "851474818@qq.com";
	private String SEND_UNAME = "verphen";
	private String SEND_PWD = "feiai1314chuan";
	// 建立会话
	private MimeMessage message;
	private Session s;

	/*
	 * 初始化方法
	 */
	public JavaMail() {
		Properties props = System.getProperties();
		props.setProperty(KEY_SMTP, VALUE_SMTP);
		props.put(KEY_PROPS, VALUE_PROPS);
		s = Session.getInstance(props);
		/* s.setDebug(true);开启后有调试信息 */
		message = new MimeMessage(s);
	}

	/**
	 * 发送邮件
	 * 
	 * @param headName
	 *            邮件头文件名
	 * @param sendHtml
	 *            邮件内容
	 * @param receiveUser
	 *            收件人地址
	 */
	public void doSendHtmlEmail(String headName, String sendHtml,
			String receiveUser) {
		try {
			// 发件人
			InternetAddress from = new InternetAddress(SEND_USER);
			message.setFrom(from);
			// 收件人
			InternetAddress to = new InternetAddress(receiveUser);
			message.setRecipient(Message.RecipientType.TO, to);
			// 邮件标题
			message.setSubject(headName);
			String content = sendHtml.toString();
			// 邮件内容,也可以使纯文本"text/plain"
			message.setContent(content, "text/html;charset=GBK");
			message.saveChanges();
			Transport transport = s.getTransport("smtp");
			// smtp验证，就是你用来发邮件的邮箱用户名密码
			transport.connect(VALUE_SMTP, SEND_UNAME, SEND_PWD);
			// 发送
			transport.sendMessage(message, message.getAllRecipients());
			transport.close();
			System.out.println("send success!");
		} catch (AddressException e) {
			e.printStackTrace();
		} catch (MessagingException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		JavaMail se = new JavaMail();
		se.doSendHtmlEmail("测试邮件头文件名", "测试邮件内容", "verphen@163.com");
	}
}
