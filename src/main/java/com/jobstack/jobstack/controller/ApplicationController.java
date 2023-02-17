package com.jobstack.jobstack.controller;

import com.jobstack.jobstack.model.Application;
import com.jobstack.jobstack.repos.ApplicationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.annotations.ApiIgnore;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RestController
public class ApplicationController {

    @Autowired
    ApplicationRepository appRepo;

    @ApiIgnore
    @RequestMapping(value="/application")
    public void redirect(HttpServletResponse response) throws IOException {
        response.sendRedirect("/swagger-ui.html");
    }

    @PostMapping("/application")
    private Application addApplication(Application application)
    {
        return appRepo.save(application);
    }
}
