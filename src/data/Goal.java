package data;

/**
 * Essential data classes
 */

final public class Goal {

    // The finality of the criminal record

    private final GoalTypes goalType;

    public Goal(GoalTypes goalType) {
        this.goalType = goalType;
    }

    public GoalTypes getGoal() {
        return goalType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Goal goal = (Goal) o;

        return goalType == goal.goalType;
    }

    @Override
    public int hashCode() {
        return goalType != null ? goalType.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "Goal{" +
                "goalType=" + goalType +
                '}';
    }
}