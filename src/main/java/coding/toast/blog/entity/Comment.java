package coding.toast.blog.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@SequenceGenerator(
	name = "commentIdSequence",
	schema = "blog",
	sequenceName = "comment_id_seq",
	allocationSize = 1
)
@Getter
@NoArgsConstructor
/**
 * 댓글에도 비밀댓글, 일반댓글이 나뉜다고 생각해봤고,
 * 그걸 나눠서 table 을 만들기 위해 @Inheritance 기능을 사용해봤습니다.
 */
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "comment_type", discriminatorType = DiscriminatorType.STRING) // DB 에서 직관적으로 알기 좋게 넣어두는 게 좋다고 한다.
// InheritanceType.SINGLE_TABLE 사용하면 DiscriminatorColumn 을 표기 안해도 DTYPE 이라는 명칭으로 생긴다.
public class Comment {
	
	@Id @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "commentIdSequence")
	private Long commentId;
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "post_id")
	private Post post;
	
	@Column(length = 500, nullable = false)
	private String content;

//
//	@Column(nullable = false)
//	private Long writerId;
}
