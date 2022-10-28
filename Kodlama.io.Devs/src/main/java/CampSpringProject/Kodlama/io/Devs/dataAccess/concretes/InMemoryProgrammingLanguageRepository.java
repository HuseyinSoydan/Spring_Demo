package CampSpringProject.Kodlama.io.Devs.dataAccess.concretes;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import CampSpringProject.Kodlama.io.Devs.dataAccess.abstracts.ProgrammingLanguageRepository;
import CampSpringProject.Kodlama.io.Devs.entities.concretes.ProgrammingLanguage;

@Repository
public class InMemoryProgrammingLanguageRepository implements ProgrammingLanguageRepository{

	List<ProgrammingLanguage> programmingLanguages;
	
	public InMemoryProgrammingLanguageRepository() {
		programmingLanguages = new ArrayList<ProgrammingLanguage>();
		
		programmingLanguages.add(new ProgrammingLanguage(1, "C#"));
		programmingLanguages.add(new ProgrammingLanguage(2, "Java"));
		programmingLanguages.add(new ProgrammingLanguage(3, "Python"));
		programmingLanguages.add(new ProgrammingLanguage(4, "C++"));
		programmingLanguages.add(new ProgrammingLanguage(5, "Javascript"));
	}

	@Override
	public List<ProgrammingLanguage> getAll() {
		
		return programmingLanguages;
	}
	
	@Override
	public void add(ProgrammingLanguage language) {
		this.programmingLanguages.add(language);
	}

	@Override
	public void delete(int id) {
		this.programmingLanguages.remove(this.getById(id));
	}

	@Override
	public void update(ProgrammingLanguage language) {
		for (ProgrammingLanguage programmingLanguage : programmingLanguages) {
			if(programmingLanguage.getId() == language.getId()) {
				programmingLanguage.setName(language.getName());
			}
		}
	}

	@Override
	public ProgrammingLanguage getById(int id) {
		for (ProgrammingLanguage programmingLanguage : programmingLanguages) {
			if (programmingLanguage.getId() == id) {
				return programmingLanguage;
			}
		}
		return null;
	}
}