package com.zonetest.eventdriven.demorecver2.dto;

public class EventMsgBody {
    public EventMsgBody(String msg, String sender) {
        this.msg = msg;
        this.sender = sender;
    }

    private String msg;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    private String sender;
}
