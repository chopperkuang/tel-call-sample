package com.dooioo.tel.web;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "info")
public class XmlResult {

    private int id;
    private String msg;

    public XmlResult(int id, String msg) {
        this.id = id;
        this.msg = msg;
    }

    public XmlResult(String msg) {
        this.msg = msg;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
