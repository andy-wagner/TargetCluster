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
                .addCategories("Seoul", "Tokyo").addKeywords("Food")
                .addDetail("Seoul", "Tour")
                .addDetails("Tokyo", "Tour", "Ramen")
                .addKeywords("Keyword", "Keyword2", "Keyw3ord", "Keyword1")
                .addSynonym("Seoul", "Seoul-Si")
                .addSynonyms("Seoul", "Tokyo", "seoul-si") // Tokyo - Error(Existing in category)
                .build();

        // Tried to put synonym which is existing in domain category set[Tokyo]. Ignoring this operation since the operation can occur recursive error.

        // Target{
        // targetConfig=TargetConfig{
        // category={Seoul=[[NOT_CLASSIFIED], Tour], Tokyo=[Ramen, [NOT_CLASSIFIED], Tour]},
        // synonym={seoul-si=Seoul, Seoul-Si=Seoul},
        // keywords=[Keyword2, Keyword1, Keyword, Keyw3ord, Food],
        // caseSensitive=true,
        // debug=true}
        // }

    }

}
