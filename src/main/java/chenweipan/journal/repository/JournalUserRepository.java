package chenweipan.journal.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import chenweipan.journal.po.JournalUser;

public interface JournalUserRepository extends JpaRepository<JournalUser, Long> {

}
