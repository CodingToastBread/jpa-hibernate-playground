package coding.toast.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.proxy.HibernateProxy;

import java.time.LocalDate;
import java.util.Date;
import java.util.Objects;

@Entity
@SequenceGenerator(
	name = "member_sequence",
	schema = "jpa",
	sequenceName = "member_seq",
	allocationSize = 1
)
@Getter @Setter @ToString
@Builder @NoArgsConstructor @AllArgsConstructor
public class Member {
	
	@Id @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "member_sequence")
	private Long id;
	
	@Column(nullable = false)
	private String name;
	
	private Integer age;
	
	@CreationTimestamp
	@Column(updatable = false, nullable = false)
	private LocalDate signupDate;

	@Column(nullable = false)
	@Enumerated(EnumType.STRING)
	private RoleType roleType = RoleType.USER;
	
	@Override
	public final boolean equals(Object o) {
		if (this == o) return true;
		if (o == null) return false;
		Class<?> oEffectiveClass = o instanceof HibernateProxy ? ((HibernateProxy) o).getHibernateLazyInitializer().getPersistentClass() : o.getClass();
		Class<?> thisEffectiveClass = this instanceof HibernateProxy ? ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass() : this.getClass();
		if (thisEffectiveClass != oEffectiveClass) return false;
		Member member = (Member) o;
		return getId() != null && Objects.equals(getId(), member.getId());
	}
	
	@Override
	public final int hashCode() {
		return this instanceof HibernateProxy ? ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass().hashCode() : getClass().hashCode();
	}
	
}

