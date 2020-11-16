/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projekti;

import java.util.List;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author kknp8
 */
public interface PostRepository extends JpaRepository<Post, Long> {
    List<Post> findByAccount(Account account);
    List<Post> findByAccountIn(List<Account> connections, Pageable pageable);
    
}
