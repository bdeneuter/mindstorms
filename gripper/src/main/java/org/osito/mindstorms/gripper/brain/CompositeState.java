package org.osito.mindstorms.gripper.brain;

import static java.util.Arrays.asList;

import java.util.Arrays;
import java.util.List;

import org.osito.mindstorms.gripper.body.Body;

public class CompositeState implements State {

	private List<State> states;

	public CompositeState(State... states) {
		this(Arrays.asList(states));
	}
	
	public CompositeState(List<State> states) {
		this.states = states;
	}
	
	public static State states(State... states) {
		return new CompositeState(asList(states));
	}
	
	@Override
	public void start(Body body, Brain brain) {
		states.stream().forEachOrdered((e) -> e.start(body, brain));
	}

	@Override
	public void stop() {
		states.stream().forEachOrdered((e) -> e.stop());
	}

}
