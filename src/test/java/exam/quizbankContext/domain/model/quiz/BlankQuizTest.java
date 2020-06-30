package exam.quizbankContext.domain.model.quiz;

import org.junit.jupiter.api.Test;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.is;


public class BlankQuizTest {

    @Test
    void should_return_id_when_creating_given_blankQuiz_id() {
        BlankQuizId id = new BlankQuizId("quiz-aaa-bbb-ccc");
        String quizId = "quizid-f500ee0d-3c9f-494a-bc13-993250053194";
        int score = 10;
        BlankQuiz blankQuiz = BlankQuiz.create(id, quizId, score);

        assertThat(blankQuiz.getId(), is(id));
    }
}
