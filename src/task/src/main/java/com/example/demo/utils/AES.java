package com.example.demo.utils;

import java.security.AlgorithmParameters;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.security.Security;
import java.security.spec.InvalidParameterSpecException;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

import org.bouncycastle.jce.provider.BouncyCastleProvider;

public class AES
{
	public static boolean initialized=false;
	
	public static byte[] decrypt(byte[] content,byte[] keyByte,byte[] ivByte)
	{
		initialize();
		try
		{
			Cipher cipher=Cipher.getInstance("AES/CBC/PKCS7Padding");
			Key sKeyspec=new SecretKeySpec(keyByte,"AES");
			cipher.init(Cipher.DECRYPT_MODE, sKeyspec, generateIV(ivByte));
			byte[] result=cipher.doFinal(content);
			return result;
		} catch (NoSuchAlgorithmException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchPaddingException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvalidKeyException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvalidAlgorithmParameterException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvalidParameterSpecException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalBlockSizeException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (BadPaddingException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	public static void initialize()
	{
		if(initialized)
			return;
		Security.addProvider(new BouncyCastleProvider());
		initialized=true;
	}
	public static AlgorithmParameters generateIV(byte[] iv) throws NoSuchAlgorithmException, InvalidParameterSpecException
	{
		AlgorithmParameters params=AlgorithmParameters.getInstance("AES");
		params.init(new IvParameterSpec(iv));
		return params;
	}

}
