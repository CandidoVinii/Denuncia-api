package com.example.apidenuncias.model;

import java.util.Map;

public class Response<T> {
    private T data;
    private Map<String, Object> error;

    public Response(T data) {
        this.data = data;
    }

    public Response(Map<String, Object> error) {
        this.error = error;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public Map<String, Object> getError() {
        return error;
    }

    public void setError(Map<String, Object> error) {
        this.error = error;
    }
}
