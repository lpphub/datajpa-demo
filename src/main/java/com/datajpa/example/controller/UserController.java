package com.datajpa.example.controller;

import com.datajpa.example.entity.User;
import com.datajpa.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

@RestController
@RequestMapping("user")
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping("{id}")
    @ResponseBody
    public User getOne(@PathVariable("id") Integer id) {
        System.out.println("测试：" + id);
        return userService.getOne(id);
    }

    @RequestMapping("/test")
    @ResponseBody
    public Map<String, String> query(@RequestBody byte[] body, String name, HttpServletRequest request) {
        System.out.println(body.length);
        System.out.println(request.getHeader("Authorization"));
        Map<String, String> map = new HashMap<>();
        map.put("name", name);
        map.put("hash", request.getParameter("hash"));
        map.put("auth", request.getHeader("Authorization"));
        map.put("test body", "" + getBody(request).length);
        map.put("aa", new String(body));
        return map;
    }

    private byte[] getBody(HttpServletRequest request) {
        StringBuilder sb = new StringBuilder();
//        sb.append("Headers:\n");
//        Enumeration<String> headerNames = request.getHeaderNames();
//        while (headerNames.hasMoreElements()) {
//            String headerName = headerNames.nextElement();
//            Enumeration<String> headers = request.getHeaders(headerName);
//            while (headers.hasMoreElements()) {
//                String headerValue = headers.nextElement();
//                sb.append(headerName).append(':').append(headerValue).append('\n');
//            }
//        }
//        sb.append("\nParameters:\n");
        for (Map.Entry entry : request.getParameterMap().entrySet()) {
            sb.append(entry.getKey()).append(':').append(entry.getValue()).append('\n');
        }
        return sb.toString().getBytes();
    }
}
