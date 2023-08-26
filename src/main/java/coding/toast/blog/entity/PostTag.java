package coding.toast.blog.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@SequenceGenerator(
	name = "postTagIdSequence",
	schema = "blog",
	sequenceName = "postTag_id_seq",
	allocationSize = 1
)
@Getter
@NoArgsConstructor
public class PostTag {
	@Id @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "postTagIdSequence")
	private Long postTagId;
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "post_id")
	private Post post;
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "tag_id")
	private Tag tag;
}
