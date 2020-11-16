/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projekti;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author kknp8
 */
public interface PostLikeRepository extends JpaRepository<PostLike, Long> {
    
    
}
