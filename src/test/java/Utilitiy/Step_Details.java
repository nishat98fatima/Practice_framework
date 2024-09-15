package Utilitiy;

import io.cucumber.plugin.ConcurrentEventListener;
import io.cucumber.plugin.event.EventHandler;
//import dev.failsafe.internal.EventHandler;
import io.cucumber.plugin.event.EventPublisher;
import io.cucumber.plugin.event.PickleStepTestStep;
import io.cucumber.plugin.event.TestStepStarted;

public class Step_Details implements ConcurrentEventListener {
	public static String stepName;

    public EventHandler<TestStepStarted> stepHandler = new EventHandler<TestStepStarted>() {
        @Override
        public void receive(TestStepStarted event) {
            handleTestStepStarted(event);
        }

    };

    @Override
    public void setEventPublisher(EventPublisher publisher) {
        publisher.registerHandlerFor(TestStepStarted.class, stepHandler);
    }

    private void handleTestStepStarted(TestStepStarted event) {
        if (event.getTestStep() instanceof PickleStepTestStep) {
            PickleStepTestStep testStep = (PickleStepTestStep)event.getTestStep();
            stepName = testStep.getStep().getText();
            System.out.println(stepName);
        }


    }

}
