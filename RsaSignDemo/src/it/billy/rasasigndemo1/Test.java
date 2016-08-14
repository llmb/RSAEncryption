package it.billy.rasasigndemo1;

import java.io.UnsupportedEncodingException;
import java.util.Map;

public class Test {
	public static void main(String[] args) {
		// System.out.println(Constants.RSA_PRILICKEY.equals(Constants.RSA_PRILICKEY1));
		try {
			Map<String, Object> genKeyPair = RSACrypt.genKeyPair();
			String privateKey = RSACrypt.getPrivateKey(genKeyPair);
			String publicKey = RSACrypt.getPublicKey(genKeyPair);

			System.out.println("privateKey:\r\n" + privateKey);
			System.out.println("publicKey:\r\n" + publicKey);
			String source = "强大的黑马8期";
			System.out.println("--------------私钥加密,公钥解密--------------");

			System.out.println("加密前：\r\n" + source);
			byte[] data = source.getBytes();// 因为参数接收字节数组,所以我们转换成字节数组
			byte[] encodedData = RSACrypt.encryptByPrivateKey(data, privateKey);
			String enBaseDate = RSACrypt.encode(encodedData);// 这里就不要用new string,要补得到的数据就会乱码
			System.out.println("私钥加密后：\r\n" + enBaseDate);


			System.out.println("--------------------------------");
			byte[] decryptByPrivateKey = RSACrypt.decryptByPublicKey(encodedData, publicKey);// encodedData不能用enBaseDate.getBytes()替换
			System.out.println("公钥解密后：\r\n" + new String(decryptByPrivateKey));// 不要用RSACrypt.encode(decryptByPrivateKey);
			
			/*		System.out.println("--------------公钥加密,私钥解密--------------");
					System.out.println("加密前：\r\n" + source);
					byte[] data = source.getBytes();
					byte[] encodedData = RSACrypt.encryptByPublicKey(data, publicKey);
					String enBaseDate = RSACrypt.encode(encodedData);
					System.out.println("公钥加密后：\r\n" + enBaseDate);
					System.out.println("--------------------------------");
					byte[] decryptByPrivateKey = RSACrypt.decryptByPrivateKey(encodedData, privateKey);// encodedData不能用enBaseDate.getBytes()替换
					System.out.println("私钥解密后：\r\n" + new String(decryptByPrivateKey));// RSACrypt.encode(decryptByPrivateKey)和new
																						// String(decryptByPrivateKey)不同
			*/
//			System.out.println("--------------签名,验证--------------");
//			String str = "A同学,借我1w块";
//			// sign和verfy
//			byte[] data = str.getBytes();
//			// 商户给支付宝
//			String sign = RSACrypt.sign(data, privateKey);// 想借钱的.B同学
//			System.out.println("sign\r\n:" + sign);
//			
//			
//			
//			// sign和verfy
//			boolean verify = RSACrypt.verify(data, publicKey, sign);// 借钱的人 A同学
//			if (verify) {
//				System.out.println("verfiy成功,确实是B同学给我打的欠条");
//			} else {
//				System.out.println("verfiy不成功");
//			}

		} catch (UnsupportedEncodingException e) {
			;
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
