package com.augylabs.facade.controller;

import com.augylabs.facade.Versions;
import com.google.common.collect.Maps;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * Created by adarshpandey on 12/6/14.
 */
@RestController("Hello world testing")
@RequestMapping("/greeting")
public class HelloWorldController {

    @RequestMapping(method = RequestMethod.GET, value = "/{userName}", produces = {Versions.APPLICATION_JSON})
    public Map<String, String> greeting(@PathVariable String userName) {
        Map<String, String> responseMap = Maps.newHashMap();
        responseMap.put("name", userName);

        return responseMap;
    }

}
