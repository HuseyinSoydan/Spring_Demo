package CampSpringProject.Kodlama.io.Devs.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import CampSpringProject.Kodlama.io.Devs.business.abstracts.ProgrammingLanguageService;
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
	public List<ProgrammingLanguage> getAll() {
		
		return repository.getAll();
	}
	
	@Override
	public void add(ProgrammingLanguage language) {
		if (this.checkIfExists(language)) {
			return;
		} else {
			if (!language.getName().isBlank())
				this.repository.add(language);
		}
	}

	@Override
	public void delete(int id) {
		this.repository.delete(id);
	}

	@Override
	public void update(ProgrammingLanguage language) {
		this.repository.update(language);
	}

	@Override
	public ProgrammingLanguage getById(int id) {
		return this.repository.getById(id);
	}
	
	public boolean checkIfExists(ProgrammingLanguage language) {
		for (ProgrammingLanguage programmingLanguage : this.repository.getAll()) {
			if (programmingLanguage.getName().equals(language.getName())
					|| programmingLanguage.getId() == language.getId()) {
				return true;
			}
		}
		return false;
	}
}