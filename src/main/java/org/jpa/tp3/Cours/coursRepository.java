package org.jpa.tp3.Cours;
import java.util.List;
import org.springframework.data.repository.CrudRepository;

public interface coursRepository extends CrudRepository<cours, Integer>{

    public List<cours> findByModuleId(Integer moduleId);
}
