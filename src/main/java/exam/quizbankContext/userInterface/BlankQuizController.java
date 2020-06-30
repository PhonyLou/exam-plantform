package exam.quizbankContext.userInterface;

import exam.quizbankContext.application.BlankQuizApplicationService;
import exam.quizbankContext.application.CreateBlankQuizCommand;
import exam.quizbankContext.domain.model.quiz.BlankQuizId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;


@RestController
public class BlankQuizController {

    private BlankQuizApplicationService blankQuizApplicationService;

    @Autowired
    public BlankQuizController(BlankQuizApplicationService blankQuizApplicationService) {
        this.blankQuizApplicationService = blankQuizApplicationService;
    }

    @PostMapping("/blankQuiz")
    @ResponseBody
    @ResponseStatus(HttpStatus.CREATED)
    public BlankQuizDTO create(@RequestBody CreateBlankQuizCommand command) {
        BlankQuizId id = blankQuizApplicationService.create(command);
        return BlankQuizDTO.from(id);
    }
}
