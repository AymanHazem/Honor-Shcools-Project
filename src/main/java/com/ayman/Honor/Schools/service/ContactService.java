package com.ayman.Honor.Schools.service;

import com.ayman.Honor.Schools.controller.ContactController;
import com.ayman.Honor.Schools.model.Contact;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.ApplicationScope;
import org.springframework.web.context.annotation.RequestScope;
import org.springframework.web.context.annotation.SessionScope;

/*
@Slf4j, is a Lombok-provided annotation that will automatically generate an SLF4J
Logger static property in the class at compilation time.
* */
@Service
@Slf4j
@SessionScope //is the default
//@RequestScope
//@ApplicationScope
public class ContactService
{
    private int counter =0;

    public ContactService() {
        System.out.println("Contact Service Bean initialized");
    }

    public boolean saveMessageDetails (Contact contact)
    {
        boolean isSaved = true;
        log.info (contact.toString());
        return isSaved;
    }

    public int getCounter() {
        return counter;
    }

    public void setCounter(int counter) {
        this.counter = counter;
    }
}
