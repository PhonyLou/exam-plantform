package exam.quizbankContext.userInterface;

import exam.quizbankContext.domain.model.quiz.BlankQuizId;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class BlankQuizDTO {
    private final String uri;

    public static BlankQuizDTO from(final BlankQuizId blankQuizId) {
        return new BlankQuizDTO("blankQuiz/" + blankQuizId);
    };
}
