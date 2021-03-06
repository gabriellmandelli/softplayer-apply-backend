package com.greentower.api.rules.person.service.impl;

import com.greentower.api.rules.person.domain.entity.Person;
import com.greentower.api.rules.person.domain.repository.PersonRepository;
import com.greentower.api.rules.person.service.PersonService;
import com.greentower.api.rules.person.util.exception.PersonNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class PersonServiceImpl implements PersonService {

    private final PersonRepository personRepository;

    public PersonServiceImpl(PersonRepository personRepository){
        this.personRepository = personRepository;
    }

    @Override
    public Person save(Person person) {
        return personRepository.save(person);
    }

    @Override
    public Person update(UUID id, Person person) {
        person.setId(id);
        return personRepository.save(person);
    }

    @Override
    public void delete(UUID personId) {
        personRepository.deleteById(personId);
    }

    @Override
    public List<Person> findAll() {
        return personRepository.findAllByOrderByName();
    }

    @Override
    public Person findById(UUID personId) {
        return personRepository.findById(personId).orElseThrow(PersonNotFoundException::new);
    }
}
