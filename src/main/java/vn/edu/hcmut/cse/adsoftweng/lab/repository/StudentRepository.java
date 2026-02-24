package vn.edu.hcmut.cse.adsoftweng.lab.repository;

import vn.edu.hcmut.cse.adsoftweng.lab.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
@Repository
public interface StudentRepository extends JpaRepository<Student, String> {
    List<Student> findByNameContainingIgnoreCase(String name);
}
