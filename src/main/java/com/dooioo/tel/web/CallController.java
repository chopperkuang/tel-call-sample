package com.dooioo.tel.web;

import com.dooioo.tel.service.PhoneService;
import com.dooioo.tel.websocket.CallHandler;
import com.dooioo.tel.websocket.SocketSession;
import com.mongodb.util.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

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


    @RequestMapping(value = "/startCall", method = RequestMethod.GET)
    public @ResponseBody String startCall(@RequestParam(value = "id", required = true) int id,
                                          @RequestParam(value = "phoneGo", required = true) String phoneGo,
                                          @RequestParam(value = "phoneCome", required = false) String phoneCome) {

        System.out.println("startCall => " + id);
        Map<String, Object> ret = new HashMap<String, Object>();
        ret.put("id", id);
        ret.put("type", "startCall");
        SocketSession.sendMessage(JSON.serialize(ret));
        return "200";
    }

    @RequestMapping(value = "/answered", method = RequestMethod.GET)
    public @ResponseBody String answered(@RequestParam(value = "id", required = true) int id,
                                          @RequestParam(value = "phoneGo", required = true) String phoneGo,
                                          @RequestParam(value = "phoneCome", required = false) String phoneCome) {

        System.out.println("answered => " + id);
        Map<String, Object> ret = new HashMap<String, Object>();
        ret.put("id", id);
        ret.put("type", "answered");
        SocketSession.sendMessage(JSON.serialize(ret));
        return "200";
    }

    @RequestMapping(value = "/ticket", method = RequestMethod.GET)
    public @ResponseBody String ticket(@RequestParam(value = "id", required = true) int id,
                                         @RequestParam(value = "phoneGo", required = true) String phoneGo,
                                         @RequestParam(value = "keepTime", required = true) int keepTime,
                                         @RequestParam(value = "phoneCome", required = false) String phoneCome) {

        System.out.println("answered => " + id);
        Map<String, Object> ret = new HashMap<String, Object>();
        ret.put("id", id);
        ret.put("keepTime", keepTime);
        ret.put("type", "ticket");
        SocketSession.sendMessage(JSON.serialize(ret));
        return "200";
    }

}
