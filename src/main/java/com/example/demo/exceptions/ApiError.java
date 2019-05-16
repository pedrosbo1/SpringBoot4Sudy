package com.example.demo.exceptions;

public class ApiError extends Exception{

  public ApiError(){
    super();
  }
  public ApiError(String message){
    super(message);
  }

}
