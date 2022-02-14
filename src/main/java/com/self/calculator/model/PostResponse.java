package com.self.calculator.model;

public class PostResponse {

    private String message;
    private long id;
    private String error;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    @Override
    public String toString() {
        return "PostResponse{" +
                "message='" + message + '\'' +
                ", id=" + id +
                ", error='" + error + '\'' +
                '}';
    }

}
