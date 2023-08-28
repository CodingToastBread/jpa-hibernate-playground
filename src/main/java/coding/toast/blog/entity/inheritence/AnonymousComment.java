package coding.toast.blog.entity.inheritence;

import coding.toast.blog.entity.Comment;
import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

/**
 * 로그인하지 않은 익명사용자의 댓글을 위한 엔티티다.
 */
@Entity
@DiscriminatorValue("ANONYMOUS")
public class AnonymousComment extends Comment {

    /**
     * 표출용 명칭
     */
    private String tempNickname = "익명 사용자";

    /**
     * 삭제/수정을 위한 password
     */
    @Column(nullable = false)
    private String password;

}
