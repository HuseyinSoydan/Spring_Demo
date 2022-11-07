package CampSpringProject.Kodlama.io.Devs.business.concretes;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import CampSpringProject.Kodlama.io.Devs.business.abstracts.ProgrammingLanguageService;
import CampSpringProject.Kodlama.io.Devs.business.requests.programmingLanguage.DeleteProgrammingLanguageRequest;
import CampSpringProject.Kodlama.io.Devs.business.responses.programmingLanguage.GetAllProgrammingLanguageResponse;
import CampSpringProject.Kodlama.io.Devs.dataAccess.abstracts.ProgrammingLanguageRepository;
import CampSpringProject.Kodlama.io.Devs.entities.concretes.ProgrammingLanguage;

@Service
public class ProgrammingLanguageManager implements ProgrammingLanguageService{	
	
	private ProgrammingLanguageRepository repository;
	
	@Autowired
	public ProgrammingLanguageManager(ProgrammingLanguageRepository repository) {
		this.repository = repository;
	}

	@Override
	public List<GetAllProgrammingLanguageResponse> getAll() {
		
		List<ProgrammingLanguage> programmingLanguages = repository.findAll();
		List<GetAllProgrammingLanguageResponse> programmingLanguageResponses = new ArrayList<>();
		
		for (ProgrammingLanguage programmingLanguage : programmingLanguages) {
			GetAllProgrammingLanguageResponse response = new GetAllProgrammingLanguageResponse();
			response.setId(programmingLanguage.getId());
			response.setName(programmingLanguage.getName());
			programmingLanguageResponses.add(response);
		}
	
		return programmingLanguageResponses;
	}
	
	@Override
	public void create(CreateProgrammingLanguageRequest createProgrammingLanguageRequest) throws Exception {
		if(!isLanguageExit(createProgrammingLanguageRequest)) throw new Exception("Language name already exist");
		if(isLanguageEmpty(createProgrammingLanguageRequest)) throw new Exception("Language name is not empty");
		
		 ProgrammingLanguage programmingLanguage = new ProgrammingLanguage();

         programmingLanguage.setName(createProgrammingLanguageRequest.getName());
         
		repository.save(programmingLanguage);
	}

	@Override
	public void delete(int id) {
		this.repository.deleteById(DeleteProgrammingLanguageRequest.getId());
	}

	@Override
	public void update(ProgrammingLanguage language) {
		this.repository.findById(null);
	}

	@Override
	public ProgrammingLanguage getById(int id) {
		return this.repository.getById(id);
	}
}