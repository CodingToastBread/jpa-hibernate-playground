package coding.toast.blog.entity.one_to_one;

import coding.toast.blog.entity.User;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * 단순히 OneToOne 테스트를 해보고 싶어서 만들어봤습니다.<br>
 * 한명의 사용자는 하나의 주소를 갖고,
 * 주소는 한명의 사용자를 갖는다... 라는 개념으로 만들어봤습니다.
 */
@Entity
@NoArgsConstructor @Getter
public class Address {
	@Id
	// don't use @GeneratedValue while your using MapsId
	private Long id;
	private String city;
	private String zipcode;
	private String roadName;
	
	@OneToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "user_id")
	@MapsId // For OneToOne Lazy Loading Problem
	private User user;
	
	@Builder
	public Address(String city, String zipcode, String roadName, User user) {
		this.city = city;
		this.zipcode = zipcode;
		this.roadName = roadName;
		this.user = user;
	}

	@Override
	public String toString() {
		return "Address{" +
			"id=" + id +
			", city='" + city + '\'' +
			", zipcode='" + zipcode + '\'' +
			", roadName='" + roadName + '\'' +
			", user.id=" + user.getUserId() +
			", user.nickname=" + user.getNickname() +
			'}';
	}
}
