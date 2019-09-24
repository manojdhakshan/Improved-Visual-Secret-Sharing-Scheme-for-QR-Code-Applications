/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algorithm;
import java.io.UnsupportedEncodingException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.AlgorithmParameterSpec;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

import org.apache.commons.codec.binary.Base64;



/**
 *
 * @author DLK-F2
 */
public class AES128Cipher {
    private static String key = "123"; // use your own
    
	private static byte[] ivBytes = { 
		// use your own.
		0x10, 0x00, 0x01, 0x00,
		0x11, 0x00, 0x00, 0x11,
		0x00, 0x00, 0x00, 0x00,
		0x00, 0x00, 0x00, 0x00
	};

    public static String encrypt(String text) throws java.io.UnsupportedEncodingException, 
						     NoSuchAlgorithmException, 
						     NoSuchPaddingException, 
						     InvalidKeyException, 
						     InvalidAlgorithmParameterException, 
						     IllegalBlockSizeException, 
						     BadPaddingException {
        byte[] keyBytes = key.getBytes();
    
	AlgorithmParameterSpec ivSpec = new IvParameterSpec(ivBytes);
        SecretKeySpec newKey = new SecretKeySpec(keyBytes, "AES");
        
	Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        cipher.init(Cipher.ENCRYPT_MODE, newKey, ivSpec);
		
        byte[] encryptedBytes = cipher.doFinal(text.getBytes("UTF-8"));

        return Base64.encodeBase64String(encryptedBytes);
    }

    public static String decrypt(String text) throws java.io.UnsupportedEncodingException, 
						     NoSuchAlgorithmException, 
						     NoSuchPaddingException, 
						     InvalidKeyException, 
						     InvalidAlgorithmParameterException, 
						     IllegalBlockSizeException, 
						     BadPaddingException {
        byte[] textBytes = Base64.decodeBase64(text);

        byte[] keyBytes = key.getBytes();
        
	AlgorithmParameterSpec ivSpec = new IvParameterSpec(ivBytes);
        SecretKeySpec newKey = new SecretKeySpec(keyBytes, "AES");
        
	Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        cipher.init(Cipher.DECRYPT_MODE, newKey, ivSpec);
		
        byte[] decodedBytes = cipher.doFinal(textBytes);
        
	return new String(decodedBytes, "UTF-8");
    }
    public static void main(String[] args) {
        try {
            AES128Cipher c=new AES128Cipher();
            encrypt("ths is moni");
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(AES128Cipher.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(AES128Cipher.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NoSuchPaddingException ex) {
            Logger.getLogger(AES128Cipher.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InvalidKeyException ex) {
            Logger.getLogger(AES128Cipher.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InvalidAlgorithmParameterException ex) {
            Logger.getLogger(AES128Cipher.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalBlockSizeException ex) {
            Logger.getLogger(AES128Cipher.class.getName()).log(Level.SEVERE, null, ex);
        } catch (BadPaddingException ex) {
            Logger.getLogger(AES128Cipher.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
