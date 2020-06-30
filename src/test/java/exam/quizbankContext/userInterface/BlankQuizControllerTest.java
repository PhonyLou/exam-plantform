package exam.quizbankContext.userInterface;

import exam.quizbankContext.domain.model.quiz.BlankQuiz;
import exam.quizbankContext.domain.model.quiz.BlankQuizId;
import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class BlankQuizControllerTest {
    @Test
    void should_return_BlankQuiz_when_creating_given_BlankQuiz() {
        BlankQuizId id = new BlankQuizId("quiz-aaa-bbb-ccc");
        String quizId = "quizid-f500ee0d-3c9f-494a-bc13-993250053194";
        int score = 10;
        BlankQuiz blankQuiz = BlankQuiz.create(id, quizId, score);

        BlankQuizController blankQuizController = new BlankQuizController();
        BlankQuiz actual = blankQuizController.create(blankQuiz);

        assertThat(actual.getId(), is(blankQuiz.getId()));
    }
}
