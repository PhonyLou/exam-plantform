package exam.quizbankContext.application;

import exam.quizbankContext.domain.model.quiz.BlankQuiz;
import exam.quizbankContext.domain.model.quiz.BlankQuizId;
import exam.quizbankContext.domain.model.quiz.BlankQuizRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlankQuizApplicationService {
    private final BlankQuizRepository blankQuizRepository;

    @Autowired
    public BlankQuizApplicationService(final BlankQuizRepository blankQuizRepository) {
        this.blankQuizRepository = blankQuizRepository;
    }

    public BlankQuizId create(CreateBlankQuizCommand command) {
        final String quizId = command.getQuizId();
        final int score = command.getScore();
        final BlankQuizId id = BlankQuizId.nextId();

        final BlankQuiz blankQuiz = BlankQuiz.create(id, quizId, score);

        blankQuizRepository.save(blankQuiz);

        return id;
    }

    public List<BlankQuiz> getAll() {
        return blankQuizRepository.getAll();
    }

    public BlankQuiz getBlankQuiz(String blankQuizId) {
        return blankQuizRepository.find(new BlankQuizId(blankQuizId));
    }
}
