package com.bit68.paymobsdk_.model;

public class MethodsModel {
    String methodId;
    String methodName;
    int methodImage;

    public MethodsModel(String methodId, String methodName, int methodImage) {
        this.methodId = methodId;
        this.methodName = methodName;
        this.methodImage = methodImage;
    }

    public int getMethodImage() {
        return methodImage;
    }

    public void setMethodImage(int methodImage) {
        this.methodImage = methodImage;
    }

    public String getMethodId() {
        return methodId;
    }

    public void setMethodId(String methodId) {
        this.methodId = methodId;
    }

    public String getMethodName() {
        return methodName;
    }

    public void setMethodName(String methodName) {
        this.methodName = methodName;
    }
}
