package coding.toast.blog.entity;

import coding.toast.blog.entity.common.SystemColumnEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

@Entity
@SequenceGenerator(
	name = "postIdSequence",
	schema = "blog",
	sequenceName = "post_id_seq",
	allocationSize = 1
)
@Getter @NoArgsConstructor
public class Post extends SystemColumnEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "postIdSequence")
	private Long postId;
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "menu_id")
	private Menu menu;
	
	@Column(nullable = false)
	private String subject;
	
	@Column(length = 1000, nullable = false)
	private String content;
	//
	// @Column(nullable = false)
	// private Long writerId;
	
	@OneToMany(mappedBy = "post", orphanRemoval = true)
	@OrderBy("commentId")
	private List<Comment> comments = new ArrayList<>();
	
}
