package com.ayman.Honor.Schools.service;

import com.ayman.Honor.Schools.constants.HonorSchoolConstants;
import com.ayman.Honor.Schools.model.Person;
import com.ayman.Honor.Schools.model.Roles;
import com.ayman.Honor.Schools.repository.PersonRepository;
import com.ayman.Honor.Schools.repository.RolesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonService
{
    @Autowired
    private PersonRepository personRepository;
    @Autowired
    private RolesRepository rolesRepository;
    public Boolean createNewPerson (Person person)
    {
        boolean isSaved = false;
        Roles role = rolesRepository.getByRoleName(HonorSchoolConstants.STUDENT_ROLE);
        person.setRoles(role);
        person=personRepository.save(person);
        if (null!=person && person.getPersonId()>0)
            isSaved=true;
        return isSaved;
    }
}
