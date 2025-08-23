package com.ayman.Honor.Schools.service;

import com.ayman.Honor.Schools.model.Person;
import com.ayman.Honor.Schools.model.Profile;
import com.ayman.Honor.Schools.repository.PersonRepository;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.servlet.ModelAndView;

@Service
@RequiredArgsConstructor
public class ProfileService
{
    private final PersonRepository personRepository;
    public void displayMessages()
    {
        Person person = new Person();
        Profile profile = new Profile();
        profile.setName(person.getName());
        profile.setMobileNumber(person.getMobileNumber());
        profile.setEmail(person.getEmail());
        if (null != person.getAddress() && person.getAddress().getAddressId()>0)
        {
            profile.setAddress1(person.getAddress().getAddress1());
            profile.setAddress2(person.getAddress().getAddress2());
            profile.setCity(person.getAddress().getCity());
            profile.setState(person.getAddress().getState());
            profile.setZipCode(person.getAddress().getZipCode());
        }
    }

}
