package coding.toast;

import coding.toast.blog.entity.Blog;
import coding.toast.blog.entity.User;
import org.hibernate.Hibernate;

import java.time.LocalDate;
import java.util.List;

import static coding.toast.DefaultExecutionWrapper.wrapAndExecute;

public class MainClass {
	public static void main(String[] args) {
		wrapAndExecute("postgresUnit", (emf, em, tx) -> {
			User newUser = User.newUserBuilder()
				.nickname("codingToastBread")
				.email("alicia@velog.io")
				.phoneNumber("010-2222-2222")
				.age((short) 31)
				.build();
			
			em.persist(newUser);
			
			Blog newBlog = Blog.newBlogBuilder()
				.blogName("Alicia Blog")
				.blogCreateDate(LocalDate.now()).build();
			
			newBlog.decideOwner(newUser);
			
			em.persist(newBlog);
		});
	}
}
