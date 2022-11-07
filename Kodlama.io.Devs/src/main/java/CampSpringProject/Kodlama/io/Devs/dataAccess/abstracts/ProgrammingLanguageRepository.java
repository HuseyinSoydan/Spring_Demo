package CampSpringProject.Kodlama.io.Devs.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import CampSpringProject.Kodlama.io.Devs.entities.concretes.ProgrammingLanguage;

public interface ProgrammingLanguageRepository extends JpaRepository<ProgrammingLanguage, Integer>{
	
}