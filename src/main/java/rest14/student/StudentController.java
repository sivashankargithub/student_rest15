package rest14.student;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentController {
	@Autowired
	StudentRepo sr;
	
	@PostMapping("/student/add")
	public String addStudent(@RequestBody StudentEntity st) {
		sr.save(st);
		return "Saved Successfully";
	}
	
	@GetMapping("/student/getAll")
	public List<StudentEntity> findAll(){
		return sr.findAll();
	}
	
	@GetMapping("/student/get/{id}")
	public Optional<StudentEntity> findById(@PathVariable int id) {
		return sr.findById(id);
	}
}
