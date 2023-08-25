package coding.toast.blog.entity;

import jakarta.persistence.*;

@Entity
@SequenceGenerator(
	name = "menuIdSequence",
	schema = "blog",
	sequenceName = "menu_id_seq",
	allocationSize = 1
)
public class Menu {
	@Id
	@GeneratedValue(generator = "menuIdSequence")
	private Long menuId;
	
	private String menuName;
	
	@Column(columnDefinition = "smallint")
	private Short menuOrder;
	
	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	@JoinColumn(name = "blog_id")
	private Blog blog;
	
}
