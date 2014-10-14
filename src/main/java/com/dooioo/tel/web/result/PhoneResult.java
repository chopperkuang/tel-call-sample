package com.dooioo.tel.web.result;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "info")
public class PhoneResult {

    private int id;
    private String phoneCome;
    private String phoneGo;
    private String phoneView;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPhoneCome() {
        return phoneCome;
    }

    public void setPhoneCome(String phoneCome) {
        this.phoneCome = phoneCome;
    }

    public String getPhoneGo() {
        return phoneGo;
    }

    public void setPhoneGo(String phoneGo) {
        this.phoneGo = phoneGo;
    }

    public String getPhoneView() {
        return phoneView;
    }

    public void setPhoneView(String phoneView) {
        this.phoneView = phoneView;
    }
}
