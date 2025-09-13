package com.ayman.Honor.Schools.repository;
import com.ayman.Honor.Schools.model.Contact;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
/*
@Repository stereotype annotation is used to add a bean of this class
type to the Spring context and indicate that given Bean is used to perform
DB related operations and
* */
@Repository
public interface ContactRepository extends CrudRepository <Contact , Integer /*data type of PK*/>
{
    @Query("SELECT c from Contact c where c.status=:status")
    Page<Contact> findByStatus(String status , Pageable pageable);

    @Modifying
    @Transactional
    @Query("update Contact c set c.status=:status where c.contactId=:id")
    int updateStatusById(String status, int id);

    List<Contact> getByStatus(String status);
}
