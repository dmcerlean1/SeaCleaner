package com.mcerlean.techtest;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * The main controller. Serves as an entry point for the program even if it isn't exactly
 * RESTful
 */
@RestController
public class InstructionController {

    @PostMapping("/")
    CleaningReport newCleaner(@RequestBody @Valid Instructions cleaningInstructions) {
        return RobotFactory.getRobot(cleaningInstructions).clean();
    }
}
