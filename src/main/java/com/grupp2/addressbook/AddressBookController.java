
package com.grupp2.addressbook;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AddressBookController {
    
    @Autowired
    private PersonRepository personRepository;
    
    @RequestMapping("/")
    public String getAllPersons(Model model) {
        model.addAttribute("persons", personRepository.findAll());
        return "index";
    }
}
