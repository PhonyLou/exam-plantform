package exam.quizbankContext.domain.model.quiz;

import exam.paperContext.domain.shared.Entity;

public class BlankQuiz implements Entity<BlankQuiz> {
    private final BlankQuizId id;
    private final String quizId;
    private final int score;

    private BlankQuiz(final BlankQuizId id, final String quizId, final int score) {
        this.id = id;
        this.quizId = quizId;
        this.score = score;
    }

    public BlankQuizId getId() {
        return id;
    }

    @Override
    public boolean sameIdentityAs(final BlankQuiz other) {
        return id.sameValueAs(other.getId());
    }

    public static BlankQuiz create(final BlankQuizId id, final String quizId, final int score) {
        return new BlankQuiz(id, quizId, score);
    }
}
