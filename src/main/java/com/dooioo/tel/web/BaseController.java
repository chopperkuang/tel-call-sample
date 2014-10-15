package com.dooioo.tel.web;

public abstract class BaseController {

    public XmlResult ok() {
        return new XmlResult("ok");
    }

    public XmlResult ok(int id) {
        return new XmlResult(id ,"ok");
    }

}
