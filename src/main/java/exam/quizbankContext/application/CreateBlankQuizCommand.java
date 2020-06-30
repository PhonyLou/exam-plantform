package exam.quizbankContext.application;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CreateBlankQuizCommand {
    private String quizId;
    private int score;
}
