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
public class Tag {
	@Id @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "commentIdSequence")
	private Long tagId;
	private String tagName;
}
