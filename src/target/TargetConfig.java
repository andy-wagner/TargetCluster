package target;

import java.util.Map;
import java.util.Set;

/**
 * @author Euijin.Ham
 * @version 1.0.0
 * @description A Capsule Class for target class configuration for builder pattern
 */
public class TargetConfig {
    /**
     * Member properties Declarations
     */
    private Map<String, Set<String>> category;
    private Map<String, String> synonym;
    private Set<String> keywords;
    private boolean caseSensitive;
    private boolean debug;

    public TargetConfig() {
    }

    public TargetConfig(Map<String, Set<String>> category, Map<String, String> synonym, Set<String> keywords, boolean caseSensitive, boolean debug) {
        this.category = category;
        this.synonym = synonym;
        this.keywords = keywords;
        this.caseSensitive = caseSensitive;
        this.debug = debug;
    }

    public Map<String, Set<String>> getCategory() {
        return category;
    }

    public void setCategory(Map<String, Set<String>> category) {
        this.category = category;
    }

    public Map<String, String> getSynonym() {
        return synonym;
    }

    public void setSynonym(Map<String, String> synonym) {
        this.synonym = synonym;
    }

    public Set<String> getKeywords() {
        return keywords;
    }

    public void setKeywords(Set<String> keywords) {
        this.keywords = keywords;
    }

    public boolean isCaseSensitive() {
        return caseSensitive;
    }

    public void setCaseSensitive(boolean caseSensitive) {
        this.caseSensitive = caseSensitive;
    }

    public boolean isDebug() {
        return debug;
    }

    public void setDebug(boolean debug) {
        this.debug = debug;
    }

    @Override
    public String toString() {
        return "TargetConfig{" +
                "category=" + category +
                ", synonym=" + synonym +
                ", keywords=" + keywords +
                ", caseSensitive=" + caseSensitive +
                ", debug=" + debug +
                '}';
    }
}
