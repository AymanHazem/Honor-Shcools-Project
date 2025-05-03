package com.ayman.Honor.Schools.repository;
import com.ayman.Honor.Schools.model.Contact;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
/*
@Repository stereotype annotation is used to add a bean of this class
type to the Spring context and indicate that given Bean is used to perform
DB related operations and
* */
@Repository
public interface ContactRepository extends CrudRepository <Contact , Integer /*data type of PK*/>
{
    List<Contact> findByStatus(String status);
}
