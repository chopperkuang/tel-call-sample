package com.dooioo.tel.web;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "info")
public class XmlResult {

    private int extId;
    private String phone;
    private String empPhone;

    public XmlResult() {}

    public XmlResult(int extId, String phone, String empPhone) {
        this.extId = extId;
        this.phone = phone;
        this.empPhone = empPhone;
    }

    public int getExtId() {
        return extId;
    }

    public void setExtId(int extId) {
        this.extId = extId;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmpPhone() {
        return empPhone;
    }

    public void setEmpPhone(String empPhone) {
        this.empPhone = empPhone;
    }
}
