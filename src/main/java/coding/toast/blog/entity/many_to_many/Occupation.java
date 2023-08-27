package coding.toast.blog.entity.many_to_many;

import coding.toast.blog.entity.User;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

/**
 * 그냥 ManyToMany Test 를 위한 엔티티 클래스이며, 한명의 사용자는 다수의 직업이 있을 수 있고,<br>
 * 직업은 다수의 사용자를 포함시킬 수 있다는 개념으로 만들어봤습니다.
 */
@Entity
@SequenceGenerator(
	name = "occupationIdSequence",
	schema = "blog",
	sequenceName = "occupation_id_seq",
	allocationSize = 1
)
@Getter @NoArgsConstructor
public class Occupation {
	@Id @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "occupationIdSequence")
	@Column(name = "occupation_id")
	private Long id;
	private String name;
	
	@ManyToMany(mappedBy = "occupationList")
	@OrderBy("userId desc")
	private List<User> userList;
	
	@Builder
	public Occupation(String name) {
		this.name = name;
	}
}
