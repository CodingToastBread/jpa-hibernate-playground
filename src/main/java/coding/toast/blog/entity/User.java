package coding.toast.blog.entity;

import coding.toast.blog.entity.many_to_many.Occupation;
import coding.toast.blog.entity.one_to_one.Address;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Entity
@Table(schema = "blog", name = "users")
@SequenceGenerator(
	name="userIdSequence",
	schema = "blog",
	sequenceName = "users_id_seq",
	allocationSize = 1 // increment size 와 동일해야 함
)
@Getter
@ToString(exclude = {"blogList", "address", "occupationList"})
@NoArgsConstructor
public class User {
	@Id
	@GeneratedValue(generator = "userIdSequence")
	private Long userId;
	
	@Column(nullable = false)
	private String nickname;
	
	@Column(nullable = false)
	private String email;
	
	@Column(nullable = false, length = 30)
	private String phoneNumber;
	
	// smallint 같은 타입들은 columnDefinition 으로 직접 세팅해주는 게 좋다.
	@Column(columnDefinition = "smallint check ((age > 0) AND (age <= 140))",
			nullable = false)
	private Short age;

	@OneToMany(mappedBy = "user")
	private List<Blog> blogList = new ArrayList<>();
	
	@Builder(builderMethodName = "newUserBuilder")
	public User(String nickname, String email, String phoneNumber, Short age) {
		this.nickname = nickname;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.age = age;
	}

	// Testing OneToOne + LazyLoading
	// it is super important to set "optional = false", if you don't? lazy loading will not work properly!!!
	@OneToOne(mappedBy = "user", optional = false, fetch = FetchType.LAZY)
	private Address address;
	
	// Testing ManyToMany
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(
		schema = "blog",
		name = "user_occup",
		joinColumns = @JoinColumn(name = "user_id"), // ==> foreign key (user_id)
		inverseJoinColumns = @JoinColumn(name = "occupation_id"),
		foreignKey = @ForeignKey(name = "user_id_fk"), // ==> add constraint user_id_fk
		inverseForeignKey = @ForeignKey(name = "occupation_id_fk")
	)
	@OrderBy("name asc")
	private List<Occupation> occupationList;
}
