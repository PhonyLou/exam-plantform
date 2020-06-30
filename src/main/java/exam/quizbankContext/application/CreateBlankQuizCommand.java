package exam.quizbankContext.application;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Value;

import java.util.List;

@Data
@AllArgsConstructor
public class CreateBlankQuizCommand {
    private String quizId;
    private int score;
}
