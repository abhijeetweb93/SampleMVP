/*
 * Copyright (C) 2017. Avalon information System : Project ASMAN
 */

package com.abhijeet.samplemvp.data_model;
/*
 * Created by nksingh on 11/2/2017.
 */

public class TokenValue {
    private Data data;

    private String success;

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }

    public String getSuccess() {
        return success;
    }

    public void setSuccess(String success) {
        this.success = success;
    }

    @Override
    public String toString() {
        return "{" +
                "data=" + data +
                ", success='" + success + '\'' +
                '}';
    }

    public class Data {
        private String token;

        public String getToken() {
            return token;
        }

        public void setToken(String token) {
            this.token = token;
        }

        @Override
        public String toString() {
            return "ClassPojo [token = " + token + "]";
        }
    }
}
