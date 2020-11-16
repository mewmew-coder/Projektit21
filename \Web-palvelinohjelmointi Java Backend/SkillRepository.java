
package projekti;

import java.util.List;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SkillRepository extends JpaRepository<Skill, Long> {
    
    List<Skill> findByAccount(Account account, Pageable pageable);
    Skill findByAccountAndName(Account account, String name); // tämä kusee jotenkin
}
