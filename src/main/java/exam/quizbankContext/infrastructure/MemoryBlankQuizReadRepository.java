package exam.quizbankContext.infrastructure;

import exam.quizbankContext.domain.model.quiz.BlankQuiz;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class MemoryBlankQuizReadRepository {
    public List<BlankQuiz> getAllByReversedOrder() {
        return null;
    }
}
