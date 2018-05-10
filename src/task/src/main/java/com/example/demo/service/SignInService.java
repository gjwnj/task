package com.example.demo.service;

import com.example.demo.data.ResponseResult;

public interface SignInService
{
	public ResponseResult isSignIn(String uid);
	public ResponseResult SignIn(String uid);

}
