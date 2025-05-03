package com.ayman.Honor.Schools.service;
import com.ayman.Honor.Schools.constants.HonorSchoolConstants;
import com.ayman.Honor.Schools.model.Contact;
import com.ayman.Honor.Schools.repository.ContactRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
/*
@Slf4j, is a Lombok-provided annotation that will automatically generate an SLF4J
Logger static property in the class at compilation time.
* */
@Service
@Slf4j
public class ContactService
{
    @Autowired
    private ContactRepository contactRepository;
    public boolean saveMessageDetails (Contact contact)
    {
        boolean isSaved = false;
        contact.setStatus(HonorSchoolConstants.OPEN);
        Contact savedContact =contactRepository.save(contact);
        if (null !=savedContact && savedContact.getContactId()>0)
            isSaved=true;
        return isSaved;
    }
    public List<Contact> findMsgsWithOpenStatus ()
    {
        List<Contact> contactMsgs = contactRepository.findByStatus(HonorSchoolConstants.OPEN);
        return contactMsgs;
    }
    public Boolean updateMsgStatus (int contactId )
    {
        Boolean isUpdated  = false;
        Optional<Contact> contact=contactRepository.findById(contactId);
        contact.ifPresent(contact1 -> {contact1.setStatus(HonorSchoolConstants.CLOSE);});
        Contact updatedContact=contactRepository.save(contact.get());
        if (null!=updatedContact && updatedContact.getContactId()>0)
            isUpdated=true;
        return isUpdated;
    }
}
