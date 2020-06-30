package exam.quizbankContext.userInterface;

import exam.quizbankContext.application.BlankQuizApplicationService;
import exam.quizbankContext.application.CreateBlankQuizCommand;
import exam.quizbankContext.domain.model.quiz.BlankQuiz;
import exam.quizbankContext.domain.model.quiz.BlankQuizId;
import exam.quizbankContext.infrastructure.MemoryBlankQuizReadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class BlankQuizController {

    private final BlankQuizApplicationService blankQuizApplicationService;
    private final MemoryBlankQuizReadRepository blankQuizReadRepository;

    @Autowired
    public BlankQuizController(BlankQuizApplicationService blankQuizApplicationService,
                               MemoryBlankQuizReadRepository blankQuizReadRepository) {
        this.blankQuizApplicationService = blankQuizApplicationService;
        this.blankQuizReadRepository = blankQuizReadRepository;
    }

    @PostMapping("/blankQuiz")
    @ResponseBody
    @ResponseStatus(HttpStatus.CREATED)
    public BlankQuizDTO create(@RequestBody CreateBlankQuizCommand command) {
        BlankQuizId id = blankQuizApplicationService.create(command);
        return BlankQuizDTO.from(id);
    }

    @GetMapping("/blankQuiz/{blankQuizId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    BlankQuiz getBlankQuiz(@PathVariable String blankQuizId) {
        return blankQuizApplicationService.getBlankQuiz(blankQuizId);
    }

    @GetMapping("/blankQuiz")
    List<BlankQuiz> getAll() {
        return blankQuizReadRepository.getAllByReversedOrder();
    }
}
