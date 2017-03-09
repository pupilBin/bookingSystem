package service;

import javax.crypto.Cipher;
import java.security.KeyFactory;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;

/**
 * Created by pupil on 2017/3/6.
 */
public class rsa {
    public static String data="hello world";
    public static String publicKeyString="MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEA4wz+DG7qDhArBzoXk6B5AnithBUgJMwB3DaCABqXvHaTYD93CM3E9kd465Ei6K8bydLklvrE1PsjN36BDlGmA8Q/dAfCzjbNZv6e8ME/GtH52sRpJ3vKyfo8bdDFBRkpMMZuSAp1XOiWu8lVaBbTqB7/dycolBZb57QZwJIeh78silVl025jSd9DUhvEFXm0549/BspCxx+xU0rRtS7Zcor2/WVYmPwjzeY/djNcpfh4caaJmnjlP/FHzAtUD1rQnSk76EW5qOBWNTl2XrkXJ/sbhZwyLm0xGHluANIkrj+LGWX07MMb9IW4HjedBE2bh6MDm2AsL1MdL6Kh9W+TYQIDAQAB";
    public static String privateKeyString="MIIEvgIBADANBgkqhkiG9w0BAQEFAASCBKgwggSkAgEAAoIBAQDjDP4MbuoOECsHOheToHkCeK2EFSAkzAHcNoIAGpe8dpNgP3cIzcT2R3jrkSLorxvJ0uSW+sTU+yM3foEOUaYDxD90B8LONs1m/p7wwT8a0fnaxGkne8rJ+jxt0MUFGSkwxm5ICnVc6Ja7yVVoFtOoHv93JyiUFlvntBnAkh6HvyyKVWXTbmNJ30NSG8QVebTnj38GykLHH7FTStG1Ltlyivb9ZViY/CPN5j92M1yl+HhxpomaeOU/8UfMC1QPWtCdKTvoRbmo4FY1OXZeuRcn+xuFnDIubTEYeW4A0iSuP4sZZfTswxv0hbgeN50ETZuHowObYCwvUx0voqH1b5NhAgMBAAECggEBAKz2p83G7Kxb6rttqKpAdA7K6bwV78+4Ta55I516pJ7gYbLPhhmBz4qhtd8WSFajlvKvoo3VaP6qdhB/YUcMMgDqjkAQ7Xj0TJMqYuAbBryiusjKGSUH69rjswchJAWXPka20yo0NWXalYFmhZZu1TxcqNYXUZVGVyryiy+k4HcdXyhb/nFyxVvMmBMnQNovBNaDjcEcHS5OBxi0heU3gKTXAkolTq6ZiUBqY+6OELTtMuz0pawViijRVdSkHkMtmrZnGDVTjr4UFYku/p3fxCLg2muG6WsEpJcTItqI/ew1iR7kgWfib5sbtr6gmQs/OtKsY1QuF31Q9gAtRmw+pfECgYEA9aaT3YjTo3zDBMvCGAZLUWl4NsNFXeFaKhXyO9itHaVSpoYqCMbI2EsAPLT2Twenz2yIXUPOvhOtJx6rHsobLswjD20XjPZ3gMDTtM8pIApexKffDCUkeVq88IeIlD0yAcVjyvIBiBoDqK7kB8CVuo3YdXOQXeO4JC8VSG4Z6L0CgYEA7J3O8TuEiXxcFFsgleKKSXoevy/YR3cLDCaYrv+mYcXjn+x1OY6gZHpx20RKw2fHBgPX39xCrMnZCaDeoG6/ZjuRetCUAUxJi+618adx998K6+0cJ5xfH2TNkiKLAbDWyVB+Jmic1cr5gWgEjThQGV7fUTsB9iP566YhB3+Q2XUCgYAE7NwWGwIzSvMWC4fOt4GXFkhEwNGJOlV2do4uyP9fksr/b700A9hPDeHpVa+CkiK5M/Hf/NYOVZKpMCI6Mc8ttwYU7xkDyIVI3ZThES4/6DVSOBNuyOfcTwduwyjn3/o6stx3WzbQpcThAvCrfx8BaIqogDKqz0AH6bHBjAOU+QKBgQDTzygylZ69HA+pQTHYOmSkBaeEaaXnw06mX96JuNwN5gEvZZJCJcS6bUmCiI2MgleMsOALyrX8yut4TQM9BiZbs7M1B4WV695iXxuL6OKCiqzSKPztEHOuPKQwzq80okKDD4T9iOPsFbhn+N8qM2CwdVbe9j15QxcztREYDz9xCQKBgFqyoa/mauDImgRgV/2LMka1m9YM4IfQghX9gcxm2bu1H95fOUvrNtu2ZcawurwJfXMIz+qrFa2RkjIrngEZlW0ZLNopNyuzSN4UxSze2ogBezPpTHEWH4RbzFLgTDcmsCnNYy7ZHyqADYIwAXkWpgXGHesbZaFckKt0p5QM1duZ";

    public static void main(String[] args) throws Exception {
        // TODO Auto-generated method stub


        //获取公钥
        PublicKey publicKey=getPublicKey(publicKeyString);

        //获取私钥
        PrivateKey privateKey=getPrivateKey(privateKeyString);

        //公钥加密
        byte[] encryptedBytes=encrypt(data.getBytes(), publicKey);
        System.out.println("加密后："+new String(encryptedBytes));

        //私钥解密
        byte[] decryptedBytes=decrypt(encryptedBytes, privateKey);
        System.out.println("解密后："+new String(decryptedBytes));
    }

    //将base64编码后的公钥字符串转成PublicKey实例
    public static PublicKey getPublicKey(String publicKey) throws Exception{
        byte[ ] keyBytes= Base64.getDecoder().decode(publicKey.getBytes());
        X509EncodedKeySpec keySpec=new X509EncodedKeySpec(keyBytes);
        KeyFactory keyFactory=KeyFactory.getInstance("RSA");
        return keyFactory.generatePublic(keySpec);
    }

    //将base64编码后的私钥字符串转成PrivateKey实例
    public static PrivateKey getPrivateKey(String privateKey) throws Exception{
        byte[ ] keyBytes=Base64.getDecoder().decode(privateKey.getBytes());
        PKCS8EncodedKeySpec keySpec=new PKCS8EncodedKeySpec(keyBytes);
        KeyFactory keyFactory=KeyFactory.getInstance("RSA");
        return keyFactory.generatePrivate(keySpec);
    }

    //公钥加密
    public static byte[] encrypt(byte[] content, PublicKey publicKey) throws Exception{
        Cipher cipher=Cipher.getInstance("RSA");//java默认"RSA"="RSA/ECB/PKCS1Padding"
        cipher.init(Cipher.ENCRYPT_MODE, publicKey);
        return cipher.doFinal(content);
    }

    //私钥解密
    public static byte[] decrypt(byte[] content, PrivateKey privateKey) throws Exception{
        Cipher cipher=Cipher.getInstance("RSA");
        cipher.init(Cipher.DECRYPT_MODE, privateKey);
        return cipher.doFinal(content);
    }
}
