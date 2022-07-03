package com.bit68.paymobsdk_.model;

public class FingerprintData {

    private String requestId;

    private String visitorId;

    private Meta meta;

    private Confidence confidence;

    public FingerprintData(String requestId, String visitorId, Meta meta, Confidence confidence) {
        this.requestId = requestId;
        this.visitorId = visitorId;
        this.meta = meta;
        this.confidence = confidence;
    }

    public String getRequestId() {
        return requestId;
    }

    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }

    public String getVisitorId() {
        return visitorId;
    }

    public void setVisitorId(String visitorId) {
        this.visitorId = visitorId;
    }

    public Meta getMeta() {
        return meta;
    }

    public void setMeta(Meta meta) {
        this.meta = meta;
    }

    public Confidence getConfidence() {
        return confidence;
    }

    public void setConfidence(Confidence confidence) {
        this.confidence = confidence;
    }
}
