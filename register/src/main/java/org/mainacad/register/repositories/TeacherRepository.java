package org.mainacad.register.repositories;

import org.mainacad.register.domain.Groups;
import org.mainacad.register.domain.Teacher;
import org.springframework.data.repository.CrudRepository;

import java.util.Set;


public interface TeacherRepository extends CrudRepository<Teacher,Long> {

}
