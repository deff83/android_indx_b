package com.example.index.Models;

import com.example.index.Config;

public class ApiContext {
    private String Login;
    private String Wmid;
    private String Culture;
    private String Signature;

    public ApiContext() {
        Login = Config.LOGIN;
        Wmid = Config.WMID;
        Culture = Config.CULTURE;
    }

    public void setSignature(String signature) {
        Signature = signature;
    }
}
