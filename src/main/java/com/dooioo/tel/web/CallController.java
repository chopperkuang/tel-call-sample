package com.dooioo.tel.web;

import com.dooioo.tel.service.PhoneService;
import com.mongodb.util.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value = "/call/*")
public class CallController {

    @Autowired
    private PhoneService phoneService;

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public @ResponseBody String add() {
        phoneService.insert("闷骚乔巴", "15601622811");
        return JSON.serialize("{status:ok}");
    }

}
