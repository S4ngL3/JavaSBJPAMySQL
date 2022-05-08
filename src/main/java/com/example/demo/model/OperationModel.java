package com.example.demo.model;

public class OperationModel {
    private int result;
    private String message;

    public void setResult(int value){
        this.result = value;
    }
    public int getResult(){
        return result;
    }
    public void setMessage(String value){
        this.message = value;
    }
    public String getMessage(){
        return message;
    }
    public OperationModel(){
        //this.result = 1;
        //this.message = "Success";
    }
}
