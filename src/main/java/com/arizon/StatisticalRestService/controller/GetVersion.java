package com.arizon.StatisticalRestService.controller;


import com.arizon.StatisticalRestService.model.VersionResponse;
import io.swagger.annotations.Api;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.Properties;

@Api(tags = "GetVersion")
@RestController
public class GetVersion {
    private Logger log = LoggerFactory.getLogger(this.getClass());

    @RequestMapping(value = "/getVersion", method = RequestMethod.GET)
    @ResponseBody
    public VersionResponse GetVersion() {

        return new VersionResponse();

    }

}
