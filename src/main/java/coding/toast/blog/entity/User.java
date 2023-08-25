package coding.toast.blog.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.ToString;

import java.util.Collection;
import java.util.List;

@Entity
@Table(schema = "blog", name = "users")
@SequenceGenerator(
	name="userIdSequence",
	schema = "blog",
	sequenceName = "users_id_seq",
	allocationSize = 1 // increment size 와 동일해야 함
)
@Getter
@ToString
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
	@ToString.Exclude
	private Short age;

	@OneToMany(mappedBy = "user")
	@ToString.Exclude
	private List<Blog> blogList;
	
}
