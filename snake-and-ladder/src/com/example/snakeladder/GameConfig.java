public class GameConfig {

    private final DifficultyStrategy strategy;
    private final RuleEngine ruleEngine;

    public GameConfig(DifficultyStrategy strategy, RuleEngine ruleEngine) {
        this.strategy = strategy;
        this.ruleEngine = ruleEngine;
    }

    public DifficultyStrategy getStrategy() { return strategy; }
    public RuleEngine getRuleEngine() { return ruleEngine; }
}