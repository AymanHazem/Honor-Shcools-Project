package com.ayman.Honor.Schools.service;

import com.ayman.Honor.Schools.controller.ContactController;
import com.ayman.Honor.Schools.model.Contact;
import org.springframework.stereotype.Service;

import java.util.logging.Logger;
@Service
public class ContactService
{
    private static Logger log=Logger.getLogger(ContactService.class.getName());
    public boolean saveMessageDetails (Contact contact)
    {
        boolean isSaved = true;
        //TODO - Need to persist the data into the DB table
        log.info (contact.toString());
        return isSaved;
    }
}
