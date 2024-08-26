package springsocket.k2.controller;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import springsocket.k2.entity.NumberEntity;
import springsocket.k2.repository.NumberRepository;

@Controller
public class NumberController {

    private final NumberRepository numberRepository;

    public NumberController(NumberRepository numberRepository) {
        this.numberRepository = numberRepository;
    }

    @MessageMapping("/incrementNumber")
    @SendTo("/topic/numberUpdate")
    public NumberEntity incrementNumber() {
        NumberEntity numberEntity = numberRepository.findByIdentifier("magic");
        numberEntity.setValue(numberEntity.getValue() + 1);
        numberRepository.save(numberEntity);
        return numberEntity;
    }
}
