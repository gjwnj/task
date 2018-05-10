package com.example.demo.utils;

import java.io.UnsupportedEncodingException;

import org.apache.tomcat.util.codec.binary.Base64;

import com.example.demo.data.ResponseResult;

public class JieMi
{
	public ResponseResult<String> rr=null;
	public ResponseResult<String> jiemi(String encryptedData,String session_key,String iv)
	{
		byte[] resultByte= AES.decrypt(Base64.decodeBase64(encryptedData), 
				Base64.decodeBase64(session_key), 
				Base64.decodeBase64(iv));
		if(resultByte!=null&&resultByte.length>0)
		{
			try
			{
				String userinfo=new String(resultByte,"UTF-8");
				rr=new ResponseResult<String>("200","解密成功",userinfo);
				return rr;
			} catch (UnsupportedEncodingException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return null;
	}

}
