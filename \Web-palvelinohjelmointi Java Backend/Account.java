package projekti;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Type;
import org.springframework.data.jpa.domain.AbstractPersistable;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Account extends AbstractPersistable<Long> {

    private String name;
    private String username;
    private String title;
    private String password;

    @OneToMany(mappedBy = "account")
    private List<Comment> comments = new ArrayList<>();
    
    @OneToMany(mappedBy = "account")
    private List<PostLike> likes = new ArrayList<>();
    
    @OneToMany(mappedBy = "account")
    private List<Post> posts = new ArrayList<>();
       
    @OneToMany(mappedBy = "account")
    private List<Skill> skills = new ArrayList<>();

    // nämä kolme ylempää tai kolme alempaa sitten ku heroku
//    @Basic(fetch = FetchType.LAZY)
//    @Type(type = "org.hibernate.type.BinaryType")
//    private byte[] profilePicture;
    @Lob
    @Basic(fetch = FetchType.LAZY)
    private byte[] profilePicture;
    
    @ManyToMany
    private List<Account> sentInvites = new ArrayList<>();
    @ManyToMany
    private List<Account> receivedInvites = new ArrayList<>();
    @ManyToMany
    private List<Account> connections = new ArrayList<>();
    
    
}
