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
public class Comment {
	
	@Id @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "commentIdSequence")
	private Long commentId;
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "post_id")
	private Post post;
	
	@Column(length = 500, nullable = false)
	private String content;
	
	@Column(nullable = false)
	private String writerId;
}
