package CampSpringProject.Kodlama.io.Devs.business.abstracts;

import java.util.List;

import CampSpringProject.Kodlama.io.Devs.entities.concretes.ProgrammingLanguage;

public interface ProgrammingLanguageService {
	List<ProgrammingLanguage> getAll();

	void add(ProgrammingLanguage language);

	void delete(int id);

	void update(ProgrammingLanguage language);

	ProgrammingLanguage getById(int id);
	
	boolean checkIfExists(ProgrammingLanguage language);
}