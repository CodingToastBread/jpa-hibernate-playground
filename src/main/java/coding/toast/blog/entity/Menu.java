package coding.toast.blog.entity;

import jakarta.persistence.*;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Entity
@SequenceGenerator(
	name = "menuIdSequence",
	schema = "blog",
	sequenceName = "menu_id_seq",
	allocationSize = 1
)
@Getter
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
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "parent_menu_id")
	private Menu menu;
	
	@OneToMany(mappedBy = "menu")
	private List<Menu> childMenuList = new ArrayList<>();
}
