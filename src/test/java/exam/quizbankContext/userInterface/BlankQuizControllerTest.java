package exam.quizbankContext.userInterface;

import exam.quizbankContext.application.BlankQuizApplicationService;
import exam.quizbankContext.application.CreateBlankQuizCommand;
import exam.quizbankContext.domain.model.quiz.BlankQuiz;
import exam.quizbankContext.domain.model.quiz.BlankQuizId;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;

public class BlankQuizControllerTest {
    @Test
    void should_return_BlankQuiz_when_creating_given_BlankQuiz() {
        BlankQuizId id = new BlankQuizId("quiz-aaa-bbb-ccc");
        String quizId = "quizid-f500ee0d-3c9f-494a-bc13-993250053194";
        int score = 10;
        CreateBlankQuizCommand command = new CreateBlankQuizCommand(quizId, score);

        BlankQuizApplicationService blankQuizApplicationService = mock(BlankQuizApplicationService.class);
        doReturn(new BlankQuizId(id.getId()))
                .when(blankQuizApplicationService)
                .create(any(CreateBlankQuizCommand.class));

        BlankQuizController blankQuizController = new BlankQuizController(blankQuizApplicationService);
        BlankQuizDTO actual = blankQuizController.create(command);

        assertThat(actual.getUri(), is("blankQuiz/" + id.getId()));
    }

    @Test
    void should_return_BlankQuiz_when_getBlankQuiz_given_BlankQuizId() {
        BlankQuizId id = new BlankQuizId("quiz-aaa-bbb-ccc");
        String quizId = "quizid-f500ee0d-3c9f-494a-bc13-993250053194";
        int score = 10;

        BlankQuizApplicationService blankQuizApplicationService = mock(BlankQuizApplicationService.class);
        doReturn(BlankQuiz.create(id, quizId, score))
                .when(blankQuizApplicationService)
                .getBlankQuiz(eq(quizId));

        BlankQuizController blankQuizController = new BlankQuizController(blankQuizApplicationService);
        BlankQuiz actual = blankQuizController.getBlankQuiz(quizId);

        assertThat(actual.getQuizId(), is(quizId));
    }

    @Test
    void should_return_list_of_BlankQuiz_when_getAll_given_no_argument() {
        BlankQuizId id = new BlankQuizId("quiz-aaa-bbb-ccc");
        String quizId = "quizid-f500ee0d-3c9f-494a-bc13-993250053194";
        int score = 10;

        BlankQuizApplicationService blankQuizApplicationService = mock(BlankQuizApplicationService.class);
        doReturn(Collections.singletonList(BlankQuiz.create(id, quizId, score)))
                .when(blankQuizApplicationService).getAll();

        BlankQuizController blankQuizController = new BlankQuizController(blankQuizApplicationService);
        List<BlankQuiz> actual = blankQuizController.getAll();

        assertThat(actual.get(0).getQuizId(), is(quizId));
    }
}
