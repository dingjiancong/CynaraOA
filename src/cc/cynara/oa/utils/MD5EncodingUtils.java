package cc.cynara.oa.utils;

import java.security.MessageDigest;

import sun.misc.BASE64Encoder;


public class MD5EncodingUtils {
	public static String getMD5(String message){
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			byte[] b = md.digest(message.getBytes());
			return new BASE64Encoder().encode(b);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}
