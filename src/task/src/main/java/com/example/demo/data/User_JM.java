package com.example.demo.data;

import java.io.Serializable;

public class User_JM implements Serializable
{
	public String encryptedData;
	public String iv;
	public String code;
	//public String appid;
	//public String secret;
	public String getEncryptedData()
	{
		return encryptedData;
	}
	public void setEncryptedData(String encryptedData)
	{
		this.encryptedData = encryptedData;
	}
	public String getIv()
	{
		return iv;
	}
	public void setIv(String iv)
	{
		this.iv = iv;
	}
	public String getCode()
	{
		return code;
	}
	public void setCode(String code)
	{
		this.code = code;
	}

}
