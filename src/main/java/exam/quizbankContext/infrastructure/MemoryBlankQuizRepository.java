package exam.quizbankContext.infrastructure;

import exam.quizbankContext.domain.model.quiz.BlankQuiz;
import exam.quizbankContext.domain.model.quiz.BlankQuizId;
import exam.quizbankContext.domain.model.quiz.BlankQuizRepository;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Component
public class MemoryBlankQuizRepository implements BlankQuizRepository {
    private final Set<BlankQuiz> blankQuizs = new HashSet<>();

    @Override
    public BlankQuiz find(BlankQuizId id) {
        return blankQuizs.stream().filter(blankQuiz -> blankQuiz.getId().getId()
                .equals(id.getId()))
                .findFirst()
                .orElseThrow(NullPointerException::new);
    }

    @Override
    public void save(BlankQuiz blankQuiz) {
        blankQuizs.add(blankQuiz);
    }

    @Override
    public List<BlankQuiz> getAll() {
        return new ArrayList<>(blankQuizs);
    }
}
