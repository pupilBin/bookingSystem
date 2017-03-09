/**
 * Created by pupil on 2017/3/6.
 */
var crypt = new JSEncrypt();
// crypt.setKey(__YOUR_OPENSSL_PRIVATE_OR_PUBLIC_KEY__); //You can use also setPrivateKey and setPublicKey, they are both alias to setKey
//Eventhough the methods are called setPublicKey and setPrivateKey, remember
//that they are only alias to setKey, so you can pass them both a private or
//a public openssl key, just remember that setting a public key allows you to only encrypt.
crypt.setPublicKey('MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEA4wz+DG7qDhArBzoXk6B5AnithBUgJMwB3DaCABqXvHaTYD93CM3E9kd465Ei6K8bydLklvrE1PsjN36BDlGmA8Q/dAfCzjbNZv6e8ME/GtH52sRpJ3vKyfo8bdDFBRkpMMZuSAp1XOiWu8lVaBbTqB7/dycolBZb57QZwJIeh78silVl025jSd9DUhvEFXm0549/BspCxx+xU0rRtS7Zcor2/WVYmPwjzeY/djNcpfh4caaJmnjlP/FHzAtUD1rQnSk76EW5qOBWNTl2XrkXJ/sbhZwyLm0xGHluANIkrj+LGWX07MMb9IW4HjedBE2bh6MDm2AsL1MdL6Kh9W+TYQIDAQAB');
crypt.setPrivateKey('MIIEvgIBADANBgkqhkiG9w0BAQEFAASCBKgwggSkAgEAAoIBAQDjDP4MbuoOECsHOheToHkCeK2EFSAkzAHcNoIAGpe8dpNgP3cIzcT2R3jrkSLorxvJ0uSW+sTU+yM3foEOUaYDxD90B8LONs1m/p7wwT8a0fnaxGkne8rJ+jxt0MUFGSkwxm5ICnVc6Ja7yVVoFtOoHv93JyiUFlvntBnAkh6HvyyKVWXTbmNJ30NSG8QVebTnj38GykLHH7FTStG1Ltlyivb9ZViY/CPN5j92M1yl+HhxpomaeOU/8UfMC1QPWtCdKTvoRbmo4FY1OXZeuRcn+xuFnDIubTEYeW4A0iSuP4sZZfTswxv0hbgeN50ETZuHowObYCwvUx0voqH1b5NhAgMBAAECggEBAKz2p83G7Kxb6rttqKpAdA7K6bwV78+4Ta55I516pJ7gYbLPhhmBz4qhtd8WSFajlvKvoo3VaP6qdhB/YUcMMgDqjkAQ7Xj0TJMqYuAbBryiusjKGSUH69rjswchJAWXPka20yo0NWXalYFmhZZu1TxcqNYXUZVGVyryiy+k4HcdXyhb/nFyxVvMmBMnQNovBNaDjcEcHS5OBxi0heU3gKTXAkolTq6ZiUBqY+6OELTtMuz0pawViijRVdSkHkMtmrZnGDVTjr4UFYku/p3fxCLg2muG6WsEpJcTItqI/ew1iR7kgWfib5sbtr6gmQs/OtKsY1QuF31Q9gAtRmw+pfECgYEA9aaT3YjTo3zDBMvCGAZLUWl4NsNFXeFaKhXyO9itHaVSpoYqCMbI2EsAPLT2Twenz2yIXUPOvhOtJx6rHsobLswjD20XjPZ3gMDTtM8pIApexKffDCUkeVq88IeIlD0yAcVjyvIBiBoDqK7kB8CVuo3YdXOQXeO4JC8VSG4Z6L0CgYEA7J3O8TuEiXxcFFsgleKKSXoevy/YR3cLDCaYrv+mYcXjn+x1OY6gZHpx20RKw2fHBgPX39xCrMnZCaDeoG6/ZjuRetCUAUxJi+618adx998K6+0cJ5xfH2TNkiKLAbDWyVB+Jmic1cr5gWgEjThQGV7fUTsB9iP566YhB3+Q2XUCgYAE7NwWGwIzSvMWC4fOt4GXFkhEwNGJOlV2do4uyP9fksr/b700A9hPDeHpVa+CkiK5M/Hf/NYOVZKpMCI6Mc8ttwYU7xkDyIVI3ZThES4/6DVSOBNuyOfcTwduwyjn3/o6stx3WzbQpcThAvCrfx8BaIqogDKqz0AH6bHBjAOU+QKBgQDTzygylZ69HA+pQTHYOmSkBaeEaaXnw06mX96JuNwN5gEvZZJCJcS6bUmCiI2MgleMsOALyrX8yut4TQM9BiZbs7M1B4WV695iXxuL6OKCiqzSKPztEHOuPKQwzq80okKDD4T9iOPsFbhn+N8qM2CwdVbe9j15QxcztREYDz9xCQKBgFqyoa/mauDImgRgV/2LMka1m9YM4IfQghX9gcxm2bu1H95fOUvrNtu2ZcawurwJfXMIz+qrFa2RkjIrngEZlW0ZLNopNyuzSN4UxSze2ogBezPpTHEWH4RbzFLgTDcmsCnNYy7ZHyqADYIwAXkWpgXGHesbZaFckKt0p5QM1duZ');
var text = 'test';
// Encrypt the data with the public key.
var enc = crypt.encrypt(text);
console.log(enc);
// Now decrypt the crypted text with the private key.
var dec = crypt.decrypt(enc);
console.log(dec);
// Now a simple check to see if the round-trip worked.
if (dec === text){
    alert('It works!!!');
} else {
    alert('Something went wrong....');
}


// var plaintText = 'aaaaaaaaaaaaaaaa';
// var keyStr = 'bbbbbbbbbbbbbbbb';
// var key = CryptoJS.enc.Utf8.parse(keyStr);
// var encryptedData = CryptoJS.AES.encrypt(plaintText, key, {
//     mode: CryptoJS.mode.ECB,
//     padding: CryptoJS.pad.Pkcs7
// });
// var encryptedBase64Str = encryptedData.toString();
// // 输出：'RJcecVhTqCHHnlibzTypzuDvG8kjWC+ot8JuxWVdLgY='
// console.log(encryptedBase64Str);
//
// // 需要读取encryptedData上的ciphertext.toString()才能拿到跟Java一样的密文
// var encryptedStr = encryptedData.ciphertext.toString();
// // 输出：'44971e715853a821c79e589bcd3ca9cee0ef1bc923582fa8b7c26ec5655d2e06'
// console.log(encryptedStr);
// // 拿到字符串类型的密文需要先将其用Hex方法parse一下
// var encryptedHexStr = CryptoJS.enc.Hex.parse(encryptedStr);
//
// // 将密文转为Base64的字符串
// // 只有Base64类型的字符串密文才能对其进行解密
// var encryptedBase64Str = CryptoJS.enc.Base64.stringify(encryptedHexStr);
// // 解密
// var decryptedData = CryptoJS.AES.decrypt(encryptedBase64Str, key, {
//     mode: CryptoJS.mode.ECB,
//     padding: CryptoJS.pad.Pkcs7
// });
// // 解密后，需要按照Utf8的方式将明文转位字符串
// var decryptedStr = decryptedData.toString(CryptoJS.enc.Utf8);
// console.log(decryptedStr); // 'aaaaaaaaaaaaaaaa'




var str = '123456';
// 密钥 16 位
var key = '0123456789abcdef0123456789abcdef';
// 初始向量 initial vector 16 位
var iv = '0123456789abcdef0123456789abcdef0123456789abcdef0123456789abcdef';
// key 和 iv 可以一致

key = CryptoJS.enc.Utf8.parse(key);
iv = CryptoJS.enc.Utf8.parse(iv);

var encrypted = CryptoJS.AES.encrypt(str, key, {
    iv: iv,
    mode: CryptoJS.mode.CBC,
    padding: CryptoJS.pad.Pkcs7
});

// 转换为字符串
encrypted = encrypted.toString();
console.log(encrypted);

// mode 支持 CBC、CFB、CTR、ECB、OFB, 默认 CBC
// padding 支持 Pkcs7、AnsiX923、Iso10126
// 、NoPadding、ZeroPadding, 默认 Pkcs7, 即 Pkcs5

var decrypted = CryptoJS.AES.decrypt(encrypted, key, {
    iv: iv,
    mode: CryptoJS.mode.CBC,
    padding: CryptoJS.pad.Pkcs7
});

// 转换为 utf8 字符串
decrypted = CryptoJS.enc.Utf8.stringify(decrypted);
console.log(decrypted);