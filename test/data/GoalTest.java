package data;

import data.interfaces.GoalTestInterface;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class GoalTest implements GoalTestInterface {

    Goal goal;

    @BeforeEach
    public void setUp() {
        GoalTypes goalType = GoalTypes.GAMESECTOR;
        goal = new Goal(goalType);
    }

    @Override
    @Test
    public void getGoalTest() {
        GoalTypes goalType = GoalTypes.GAMESECTOR;
        assertEquals(goalType, goal.getGoal());
    }

    @Override
    @Test
    public void nullGoalTest() {
        assertThrows(NullPointerException.class, () -> goal = new Goal(null));
    }

    @Override
    @Test
    public void equalsGoalTest() {
        GoalTypes goalType = GoalTypes.GAMESECTOR;
        Goal goal2 = new Goal(goalType);
        assertEquals(goal, goal2);
    }

    @Override
    @Test
    public void notEqualsGoalTest() {
        GoalTypes goalType = GoalTypes.PUBLICWORKERS;
        Goal goal2 = new Goal(goalType);
        assertNotEquals(goal, goal2);
    }
}