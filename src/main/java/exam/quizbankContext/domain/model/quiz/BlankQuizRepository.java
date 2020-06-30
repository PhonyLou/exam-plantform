package exam.quizbankContext.domain.model.quiz;

import java.util.List;

public interface BlankQuizRepository {
    BlankQuiz find(final BlankQuizId id);

    void save(final BlankQuiz blankQuiz);

    List<BlankQuiz> getAll();
}
