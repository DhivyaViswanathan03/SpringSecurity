package in.ineuron.model;

import java.util.Set;

import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Table;
import lombok.Data;
	
@Entity
@Table(name = "SECURITY_USERS")
@Data
public class UserDetails {
	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private Integer uid;
	
	@Column(nullable = false,unique = true,length = 20)
	private String uname;
	
	@Column(nullable = false,unique = true,length = 150)
	private String pwd;
	
	@Column(nullable = false,unique = true,length = 20)
	private String email;
	
	private Boolean status=true;
	
	@CollectionTable(name = "SECURITY_ROLES",
			joinColumns = @JoinColumn(name="USER_ID",referencedColumnName = "uid"))
	@Column(name = "role")
	@ElementCollection(fetch = FetchType.EAGER)
	private Set<String> roles;
	

}
