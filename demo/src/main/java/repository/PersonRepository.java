package repository;

import org.springframework.data.jpa.repository.JpaRepository;

import entity.PersonEntity;

public interface PersonRepository extends JpaRepository<PersonEntity, Long> {

}
