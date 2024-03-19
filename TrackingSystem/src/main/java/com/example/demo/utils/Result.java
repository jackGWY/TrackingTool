package com.example.demo.utils;


import java.io.Serializable;

public class Result<T> implements Serializable {
    private int code = 0;
    private String msg;
    private T value;

    public Result() {
    }

//    public static <T> Result<T> success() {
//        return success((Object)null);
//    }

    public static <T> Result<T> success(T value) {
        Result result = new Result();
        result.code = 1;
        result.value = value;
        result.msg = "success";
        return result;
    }

    public static <T> Result<T> success(int code) {
        Result result = new Result();
        result.code = code;
        result.value = null;
        result.msg = "success";
        return result;
    }

    public static Result error() {
        return error("error", 0);
    }

    public static Result error(String msg, int code) {
        Result result = new Result();
        result.code = code;
        result.msg = msg;
        return result;
    }

    public static Result error(String message) {
        return error(message, 0);
    }

    public static Result error(Result message) {
        Result result = new Result();
        result.setCode(message.getCode());
        result.setMsg(message.getMsg());
        return result;
    }

    public static <T> Result<T> error(String message, T value) {
        Result result = new Result();
        result.code = 0;
        result.value = value;
        result.msg = message;
        return result;
    }

    public static <T> Result<T> error(int code, String message, T value) {
        Result result = new Result();
        result.code = code;
        result.value = value;
        result.msg = message;
        return result;
    }

    public static boolean isSuccess(Result result) {
        if (result == null) {
            return false;
        } else {
            return 1 == result.getCode() || 100 == result.getCode();
        }
    }

    public static boolean isError(Result result) {
        return !isSuccess(result);
    }

    public int getCode() {
        return this.code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return this.msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getValue() {
        return this.value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public String toString() {
        return "Result{code=" + this.code + ", msg='" + this.msg + '\'' + ", value=" + this.value + '}';
    }
}
