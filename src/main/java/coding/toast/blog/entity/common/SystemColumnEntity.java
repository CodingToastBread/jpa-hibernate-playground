package coding.toast.blog.entity.common;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.SourceType;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@MappedSuperclass
@Getter @Setter
public class SystemColumnEntity {

	@Column(nullable = false)
	private Long registerId;
	
	@CreationTimestamp
	@Column(nullable = false, updatable = false)
	private LocalDateTime registTimestamp;
	
	@Column(nullable = false)
	private Long updateId;
	
	@UpdateTimestamp
	@Column(nullable = false)
	private LocalDateTime updateTimestamp;
	
}
