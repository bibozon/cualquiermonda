package test.interactions;

import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;

public class ExplicitWait implements Interaction {

    private final long secs;

    public ExplicitWait(long secs) {
        this.secs = secs;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        try {
            Thread.sleep(secs * 1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public static ExplicitWait here(long secs){
        return Instrumented.instanceOf(ExplicitWait.class).withProperties(secs);
    }
}
