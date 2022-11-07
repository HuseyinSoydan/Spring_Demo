package CampSpringProject.Kodlama.io.Devs.webApi.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import Kodlama.io.Devs.business.abstracts.ProgrammingLanguageTechnologyService;
import Kodlama.io.Devs.business.requests.programmingLanguageTechnology.CreateProgrammingLanguageTechnologyRequest;
import Kodlama.io.Devs.business.requests.programmingLanguageTechnology.DeleteProgrammingLanguageTechnologyRequest;
import Kodlama.io.Devs.business.requests.programmingLanguageTechnology.UpdateProgrammingLanguageTechnologyRequest;
import Kodlama.io.Devs.business.response.programmingLanguageTechnology.GetAllProgrammingLanguageTechnologyResponse;
import Kodlama.io.Devs.business.response.programmingLanguageTechnology.GetByIdProgrammingLanguageTechnologyResponse;
@RestController
@RequestMapping("/api/programmingLanguageTechnologies")
public class ProgrammingLanguageTechnologiesController {

	private ProgrammingLanguageTechnologyService languageTechnologyService;

	@Autowired
	public ProgrammingLanguageTechnologiesController(ProgrammingLanguageTechnologyService programmingLanguageTechnologyService) {
		this.languageTechnologyService = programmingLanguageTechnologyService;
	}
	
	
	@GetMapping("/getall")
	public List<GetAllProgrammingLanguageTechnologyResponse> getAll(){
		return languageTechnologyService.getAll();
		
	}
	
	@GetMapping("/{id}")
	public GetByIdProgrammingLanguageTechnologyResponse getById(@PathVariable int id) {
		return languageTechnologyService.getById(id);
		
	}
	
	@PostMapping("/add")
	public void add(@RequestBody CreateProgrammingLanguageTechnologyRequest createProgrammingLanguageTechnologyRequest) throws Exception {
		languageTechnologyService.create(createProgrammingLanguageTechnologyRequest);
		
	}
	
	@PostMapping("/update")
	public void update(@RequestBody UpdateProgrammingLanguageTechnologyRequest updateProgrammingLanguageTechnologyRequest) {
		languageTechnologyService.update(updateProgrammingLanguageTechnologyRequest);
		
	}
	
	@DeleteMapping("/delete")
	public void delete( DeleteProgrammingLanguageTechnologyRequest deleteProgrammingLanguageTechnologyRequest) {
		languageTechnologyService.delete(deleteProgrammingLanguageTechnologyRequest);
		
	}
}