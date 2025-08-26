package com.ayman.Honor.Schools.controller;

import com.ayman.Honor.Schools.model.Person;
import com.ayman.Honor.Schools.repository.PersonRepository;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Slf4j
@RequiredArgsConstructor
public class DashboardController
{
    private final PersonRepository personRepository;
    @RequestMapping(value = "/dashboard")
    public String displayDashboard (Model model , Authentication authentication , HttpSession session)
    {
        Person person = personRepository.getByEmail(authentication.getName());
        model.addAttribute("username", person.getName());
        model.addAttribute("roles",authentication.getAuthorities().toString());
        if (null != person.getEazyClass() && null != person.getEazyClass().getName())
            model.addAttribute("enrolledClass", person.getEazyClass().getName());
        session.setAttribute("loggedInPerson",person);
        return "dashboard.html";
    }
}
