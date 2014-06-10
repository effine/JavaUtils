/**
 * @author verphen
 * @date 2014年6月10日  下午4:02:57
 */

package com.verphen.security;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * MD5 加密算法
 */
public class MD5Utils {

	/* 全局数组 */
	private final static String[] strDigits = { "0", "1", "2", "3", "4", "5",
			"6", "7", "8", "9", "a", "b", "c", "d", "e", "f" };

	/* 返回形式为数字跟字符串 */
	private static String byteToArrayString(byte b) {
		int temp = b;
		if (temp < 0) {
			temp += 256;
		}
		int D1 = temp / 16;
		int D2 = temp % 16;
		return strDigits[D1] + strDigits[D2];
	}

	/* 返回形式只为数字 */
	private static String byteToNum(byte b) {
		int temp = b;
		if (temp < 0) {
			temp += 256;
		}
		return String.valueOf(temp);
	}

	/* 转换字节数组为16进制字串 */
	private static String byteToString(byte[] b) {
		StringBuffer strBuffer = new StringBuffer();
		for (int i = 0; i < b.length; i++) {
			strBuffer.append(byteToArrayString(b[i]));
		}
		return strBuffer.toString();
	}

	public static String getMD5Code(String str) {
		String result = null;
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			result = byteToString(md.digest(str.getBytes()));
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return result;
	}

	public static void main(String[] args) {
		System.out.println(getMD5Code("张亚"));
	}
}
