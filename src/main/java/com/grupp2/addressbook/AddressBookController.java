
package com.grupp2.addressbook;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class AddressBookController {
 
    @Autowired
    private PersonRepository personRepository;
    
    @RequestMapping
    public String getAllPersons(Model model) {
        model.addAttribute("persons", personRepository.findAllActivePersons());
        return "index";
    }
    
    @GetMapping("signup")
    public String showSignUpForm(Person person) {
        return "addperson";
    }
    
    @GetMapping("edit/{id}")
    public String showUpdateForm(Person person) {
        return "updateperson";
    }
    
    @RequestMapping("list")
    public String updateForm(Model model) {
        model.addAttribute("persons", personRepository.findAllActivePersons());
        return "index";
    }
    
    @RequestMapping("recreatelist")
    public String reCreatePerson(Model model) {
        model.addAttribute("persons", personRepository.findAllDeletedPersons());
        return "recreateperson";
    }
    
    @PostMapping("add")
    public String addPerson(@Valid Person person, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "addperson";
        }
        person.setStatId(1);
        personRepository.save(person);
        return "redirect:list";
    }
    
    @PostMapping("update/{id}")
    public String updatePerson(@PathVariable("id") long id, @Valid Person person, BindingResult result,
        Model model) {
        if (result.hasErrors()) {
            person.setId(id);
            return "updateperson";
        }
        person.setStatId(1);
        personRepository.save(person);
        model.addAttribute("persons", personRepository.findAllActivePersons());
        return "index";
    }

    @GetMapping("delete/{id}")
    public String deletePerson(@PathVariable("id") long id, Model model) {
        Person person = personRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid person Id:" + id));
        person.setStatId(2);
        personRepository.save(person);
        model.addAttribute("persons", personRepository.findAllActivePersons());
        return "index";
    }
    
    @GetMapping("recreate/{id}")
    public String reCreatePerson(@PathVariable("id") long id, Model model) {
        Person person = personRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid person Id:" + id));
        person.setStatId(1);
        personRepository.save(person);
        model.addAttribute("persons", personRepository.findAllActivePersons());
        return "index";
    }
    
}
