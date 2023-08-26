package coding.toast.blog.entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
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
@ToString(exclude = "user")
@NoArgsConstructor
public class Blog {

	@Id @GeneratedValue(generator = "blogIdSequence")
	private Long blogId;
	
	@Column(nullable = false)
	private String blogName;
	
	@CreationTimestamp
	@Column(nullable = false)
	private LocalDate blogCreateDate;
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false/*, cascade = CascadeType.PERSIST*/)
	@JoinColumn(name = "user_id")
	private User user;
	
	@Builder(builderMethodName = "newBlogBuilder")
	public Blog(String blogName, LocalDate blogCreateDate) {
		this.blogName = blogName;
		this.blogCreateDate = blogCreateDate;
	}
	
	/**
	 * 블로그 주인을 지정
	 * @param user 블로그 주인장
	 */
	public void decideOwner(User user) {
		this.user = user;
		user.getBlogList().add(this);
	}
	
	/**
	 * 말도 안되지만, 블로그의 소유자가 바뀌는 상황도 가정하고 메소드를 만들어봤습니다.
	 */
	public void changeOwner(User user) {
		// 기존 주인장에 있던 블로그 리스트에서 현재 블로그를 없애주고,
		this.user.getBlogList().remove(this);
		
		// 그 다음에 새로운 주인장을 모셔옵니다.
		this.user = user;
		
		// 새로운 주인장의 블로그 목록에 추가됩니다.
		user.getBlogList().add(this);
	}
}
