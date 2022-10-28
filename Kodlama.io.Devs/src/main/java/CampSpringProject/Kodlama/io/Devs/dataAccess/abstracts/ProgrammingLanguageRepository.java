package CampSpringProject.Kodlama.io.Devs.dataAccess.abstracts;

import java.util.List;

import CampSpringProject.Kodlama.io.Devs.entities.concretes.ProgrammingLanguage;

public interface ProgrammingLanguageRepository {
	List<ProgrammingLanguage> getAll();

	void add(ProgrammingLanguage language);

	ProgrammingLanguage getById(int id);

	void delete(int id);

	void update(ProgrammingLanguage language);
}