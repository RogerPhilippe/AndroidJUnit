package br.com.philippesis.androidjunit.db;

import androidx.annotation.NonNull;

public class Message {

    private int id = 0;
    private String message = "empty";
    private int status = 0;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @NonNull
    @Override
    public String toString() {
        return "ID: " + id + " Message: " + message + " Status: " + getBooleanStatus(status);
    }

    private boolean getBooleanStatus(int statusInt) { return statusInt == 1; }

    public boolean isValid() {
        return message != null && !message.isEmpty();
    }

}
