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
			"6", "7", "8", "9", "A", "B", "C", "D", "E", "F" };

	/* 转换字节数组为16进制字串 */
	private static String byteToString(byte[] b) {
		StringBuffer strBuffer = new StringBuffer();
		for (int i = 0; i < b.length; i++) {
			strBuffer.append(strDigits[(b[i] & 0xf0) >>> 4]);
			strBuffer.append(strDigits[b[i] & 0x0f]);
		}
		return strBuffer.toString();
	}

	public static String getMD5Code(String str) {
		String result = null;
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			byte[] arr = str.getBytes();
			md.update(arr);
			result = byteToString(md.digest(arr));
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return result;
	}

	public static void main(String[] args) {
		System.out.println(getMD5Code("password"));
	}
}
