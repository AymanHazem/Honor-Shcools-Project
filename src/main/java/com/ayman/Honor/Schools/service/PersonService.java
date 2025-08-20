package com.ayman.Honor.Schools.service;

import com.ayman.Honor.Schools.constants.HonorSchoolConstants;
import com.ayman.Honor.Schools.model.Person;
import com.ayman.Honor.Schools.model.Roles;
import com.ayman.Honor.Schools.repository.PersonRepository;
import com.ayman.Honor.Schools.repository.RolesRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PersonService
{
    private final PersonRepository personRepository;
    private final RolesRepository rolesRepository;
    private final PasswordEncoder passwordEncoder;
    public Boolean createNewPerson (Person person)
    {
        boolean isSaved = false;
        Roles role = rolesRepository.getByRoleName(HonorSchoolConstants.STUDENT_ROLE);
        person.setRoles(role);
        person.setPwd(passwordEncoder.encode(person.getPwd()));
        person=personRepository.save(person);
        if (null!=person && person.getPersonId()>0)
            isSaved=true;
        return isSaved;
    }
}
