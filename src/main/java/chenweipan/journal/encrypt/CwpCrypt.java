package chenweipan.journal.encrypt;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import java.security.SecureRandom;

public class CwpCrypt {

    static String password = "102933819847123";

    static byte[] salt = {1,6,11,92,4,42,11,2};

    public static String cwpEncrypt(String data) throws Exception {
        byte[] desByte = encrypt(data.getBytes("utf-8"),password);
        byte[] mixed = mix(desByte);
        return new BASE64Encoder().encode(mixed);
    }

    public static String cwpDecrypt(String crypted) throws Exception {
        byte[] mixed = new BASE64Decoder().decodeBuffer(crypted);
        byte[] desed = back(mixed);
        byte[] info = decrypt(desed,password);
        return new String(info,"utf-8");
    }

    public static byte[] mix(byte[] info){
        byte[] result = new byte[info.length];
        for(int i=0;i<info.length;i++){
            result[i] = addByte(info[i],salt[i%salt.length]);
        }
        return result;
    }

    public static byte[] back(byte[] mixed){
        byte[] result = new byte[mixed.length];
        for(int i =0;i<mixed.length;i++){
            result[i] = removeByte(mixed[i],salt[i%salt.length]);
        }
        return result;
    }

    /**
     * 加密
     * @param datasource byte[]
     * @param password String
     * @return byte[]
     */
    public static byte[] encrypt(byte[] datasource, String password) throws Exception {
            SecureRandom random = new SecureRandom();
            DESKeySpec desKey = new DESKeySpec(password.getBytes());
            //创建一个密匙工厂，然后用它把DESKeySpec转换成
            SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
            SecretKey securekey = keyFactory.generateSecret(desKey);
            //Cipher对象实际完成加密操作
            Cipher cipher = Cipher.getInstance("DES");
            //用密匙初始化Cipher对象
            cipher.init(Cipher.ENCRYPT_MODE, securekey, random);
            //现在，获取数据并加密
            //正式执行加密操作
            return cipher.doFinal(datasource);
    }
    /**
     * 解密
     * @param src byte[]
     * @param password String
     * @return byte[]
     * @throws Exception
     */
    public static byte[] decrypt(byte[] src, String password) throws Exception {
        // DES算法要求有一个可信任的随机数源
        SecureRandom random = new SecureRandom();
        // 创建一个DESKeySpec对象
        DESKeySpec desKey = new DESKeySpec(password.getBytes());
        // 创建一个密匙工厂
        SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
        // 将DESKeySpec对象转换成SecretKey对象
        SecretKey securekey = keyFactory.generateSecret(desKey);
        // Cipher对象实际完成解密操作
        Cipher cipher = Cipher.getInstance("DES");
        // 用密匙初始化Cipher对象
        cipher.init(Cipher.DECRYPT_MODE, securekey, random);
        // 真正开始解密操作
        return cipher.doFinal(src);
    }

    public static byte addByte(byte data,byte add){
        int added = data+add;
        if(added>127)
            return (byte) (added-256);
        else
            return (byte) added;
    }

    public static byte removeByte(byte data,byte remove){
        int removed = data -remove;
        if(removed<-128)
            return (byte) (256+removed);
        else
            return (byte) removed;
    }
}
