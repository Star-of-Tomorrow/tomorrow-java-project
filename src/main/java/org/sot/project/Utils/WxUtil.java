package org.sot.project.Utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import java.util.HashMap;
import java.util.Map;

/**
* @description:
* @author:maidang
* @date:2021/11/03
**/
public class WxUtil {
	/**
	 * 获得openID和sessionkey
	 *
	 * @param code
	 * @return
	 */
	public static JSONObject getSessionKeyOrOpenId(String code) {
		String requestUrl = "https://api.weixin.qq.com/sns/jscode2session";
		Map<String, String> requestUrlParam = new HashMap<>();
		// https://mp.weixin.qq.com/wxopen/devprofile?action=get_profile&token=164113089&lang=zh_CN
		//小程序appId
		requestUrlParam.put("appid", "wxb5a5938bdda04dba");
		//小程序secret
		requestUrlParam.put("secret", "b100b39c24eb6b3d8b12e0e831fdcf7d");
		//小程序端返回的code
		requestUrlParam.put("js_code", code);
		//默认参数
		requestUrlParam.put("grant_type", "authorization_code");
		//发送post请求读取调用微信接口获取openid用户唯一标识
		JSONObject jsonObject = JSON.parseObject(HttpClientUtil.doGet(requestUrl, requestUrlParam));
		return jsonObject;
	}

//	/**
//	 * 获取用户信息
//	 *
//	 * @param encryptedData
//	 * @param sessionKey
//	 * @param iv
//	 * @return
//	 */
//	public static JSONObject getUserInfo(String encryptedData, String sessionKey, String iv) {
//		// 被加密的数据
//		byte[] dataByte = Base64.decode(encryptedData);
//		// 加密秘钥
//		byte[] keyByte = Base64.decode(sessionKey);
//		// 偏移量
//		byte[] ivByte = Base64.decode(iv);
//		try {
//			// 如果密钥不足16位，那么就补足.  这个if 中的内容很重要
//			int base = 16;
//			if (keyByte.length % base != 0) {
//				int groups = keyByte.length / base + (keyByte.length % base != 0 ? 1 : 0);
//				byte[] temp = new byte[groups * base];
//				Arrays.fill(temp, (byte) 0);
//				System.arraycopy(keyByte, 0, temp, 0, keyByte.length);
//				keyByte = temp;
//			}
//			// 初始化
//			Security.addProvider(new BouncyCastleProvider());
//			Cipher cipher = Cipher.getInstance("AES/CBC/PKCS7Padding", "BC");
//			SecretKeySpec spec = new SecretKeySpec(keyByte, "AES");
//			AlgorithmParameters parameters = AlgorithmParameters.getInstance("AES");
//			parameters.init(new IvParameterSpec(ivByte));
//			cipher.init(Cipher.DECRYPT_MODE, spec, parameters);// 初始化
//			byte[] resultByte = cipher.doFinal(dataByte);
//			if (null != resultByte && resultByte.length > 0) {
//				String result = new String(resultByte, "UTF-8");
//				return JSON.parseObject(result);
//			}
//		} catch (Exception e) {
//		}
//		return null;
//	}
}
