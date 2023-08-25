package coding.toast;

import coding.toast.blog.entity.Blog;
import coding.toast.blog.entity.User;

import java.util.List;

import static coding.toast.DefaultExecutionWrapper.wrapAndExecute;

public class MainClass {
	public static void main(String[] args) {
		wrapAndExecute("postgresUnit", (emf, em, tx) -> {
			
			User user = em.find(User.class, 1L);
			System.out.println("user = " + user);
			
			List<Blog> blogList = user.getBlogList();
			for (Blog blog : blogList) {
				System.out.println("blog = " + blog);
			}
			
		});
	}
}
