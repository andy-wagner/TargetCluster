import target.Target;

/**
 * @author EuiJin.Ham
 * @version 1.0.0
 * @description A Main entrance for igniting this application.
 */
public class Main {

    public static void main(String... args) {
        Target target = Target.builder()
                .debug()
                .addCategory("Keyword").addKeywords("test")
                .addKeywords("Keyword", "Keyword2", "Keyw3ord", "Keyword1")
                .addSynonym("Keyword", "Keyword1")
                .addSynonyms("Keyword", "Keyword1", "asdf")
                .addSynonym("Keyword", "Keyword2")
                .build();
    }

}
