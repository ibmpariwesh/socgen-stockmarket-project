package socgen.iiht.authenticationservice.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Credentials {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String userName;
    private String password;
    private String role;
    private String email;
    private int mobileNumber;
    private boolean confirmed;

    public Credentials(String userName, String password, String role, String email, int mobileNumber, boolean confirmed) {
        this.userName = userName;
        this.password = password;
        this.role = role;
        this.email = email;
        this.mobileNumber = mobileNumber;
        this.confirmed = confirmed;
    }
}
