package coding.toast;

import coding.toast.entity.Member;
import coding.toast.entity.QMember;
import com.querydsl.jpa.impl.JPAQueryFactory;

import java.util.List;

import static coding.toast.DefaultExecutionWrapper.wrapAndExecute;

public class MainClass {
	public static void main(String[] args) {
		wrapAndExecute((emf, em, tx) -> {
			Member member = new Member();
			member.setName("hi");
			em.persist(member);
			
			JPAQueryFactory queryFactory = new JPAQueryFactory(em);
			List<Member> fetchList = queryFactory
				.select(QMember.member)
				.from(QMember.member)
				.fetch();
			
			for (Member m : fetchList) {
				System.out.println("name = " + m.getName());
			}
		});
	}
}
