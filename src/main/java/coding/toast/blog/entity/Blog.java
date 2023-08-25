package coding.toast.blog.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDate;

@Entity
@SequenceGenerator(
	name = "blogIdSequence",
	schema = "blog",
	sequenceName = "blog_id_seq",
	allocationSize = 1
)
@Getter
@ToString
public class Blog {

	@Id @GeneratedValue(generator = "blogIdSequence")
	private Long blogId;
	
	@Column(nullable = false)
	private String blogName;
	
	@CreationTimestamp
	@Column(nullable = false)
	private LocalDate blogCreateDate;
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "user_id")
	@ToString.Exclude
	private User user;
	
}
