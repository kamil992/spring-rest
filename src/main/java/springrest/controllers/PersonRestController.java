package springrest.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import springrest.entity.Adress;
import springrest.entity.Person;
import springrest.entity.PersonErrorResponse;

@RestController
@RequestMapping("/api")
public class PersonRestController {

	// define endpoint for "/students" - return list of students
	private List<Person> personList = new ArrayList<>();
	
	//before run is creating list of persons
	@PostConstruct
	public void createList(){
		
		personList.add(new Person("Janusz", "Kowalski", new Adress("Poland", "Warsaw", "33-303 Warsaw")));
		personList.add(new Person("Mario", "Bros", new Adress("Italy", "Napoli", "20-202 Napoli")));
		personList.add(new Person("George", "Smith", new Adress("USA", "Chicago", "10-101 Chicago")));		
	}
	
	@GetMapping("/persons")
	public List<Person> getPersons() {

		//List<Student> theStudents = new ArrayList<>();
		
		return personList;
	}
	
	@GetMapping("/persons/{personId}")
	public Person getPersons(@PathVariable int personId){
		
		if(personId >= personList.size() || personId < 0){
			throw new PersonNotFoundException("Student is not found : " + personId);
		}
		return personList.get(personId);
	}
	

}









