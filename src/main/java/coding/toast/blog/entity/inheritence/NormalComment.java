package coding.toast.blog.entity.inheritence;

import coding.toast.blog.entity.Comment;
import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

/**
 * 일반적인 로그인 사용자의 댓글은 writerId 값을 내포한다.
 */
@Entity
@DiscriminatorValue("NORMAL")
public class NormalComment extends Comment {

    private Long writerId;
}
