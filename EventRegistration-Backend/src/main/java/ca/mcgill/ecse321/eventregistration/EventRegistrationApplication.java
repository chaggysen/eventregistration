package ca.mcgill.ecse321.eventregistration;

import ca.mcgill.ecse321.eventregistration.dao.PersonRepository;
import ca.mcgill.ecse321.eventregistration.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.SpringApplication;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@SpringBootApplication
public class EventRegistrationApplication {

  public static void main(String[] args) {
    SpringApplication.run(EventRegistrationApplication.class, args);
  }

  @Autowired
  PersonRepository personRepository;

  @RequestMapping("/")
  public String greeting(){
    return "Hello world!";
  }

  @RequestMapping("/test")
  public Person result(){
    Person person = new Person();
    person.setName("chaggy");
    personRepository.save(person);
    return personRepository.findPersonByName("chaggy");
  }

}
