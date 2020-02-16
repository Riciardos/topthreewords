import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class TopThreeWordsTests {

    @Test
    void givenTestCases() {
        assertArrayEquals(new String[]{"a", "of", "on"}, Application.topThreeWords("In a village of La Mancha, the name of which I have\n" +
                "no desire to call to\n" +
                "mind, there lived not long since one of those gentlemen that keep a lance\n" +
                "in the lance-rack, an old buckler, a lean hack, and a greyhound for\n" +
                "coursing. An olla of rather more beef than mutton, a salad on most\n" +
                "nights, scraps on Saturdays, lentils on Fridays, and a pigeon or so extra\n" +
                "on Sundays, made away with three-quarters of his income."));
        assertArrayEquals(new String[]{"e", "ddd", "aa"}, Application.topThreeWords("e e e e DDD ddd DdD: ddd ddd aa aA Aa, bb cc cC e e e"));
        assertArrayEquals(new String[]{"won't", "wont"}, Application.topThreeWords(" //wont won't won't"));
    }

    @Test
    void emptyStringShouldReturnEmptyArray() {
        assertArrayEquals(new String[0], Application.topThreeWords(""));
    }

    @Test
    void singleWordShouldReturnArrayWithOneElement() {
        assertArrayEquals(Application.topThreeWords("Something"), new String[]{"something"});
    }

    @Test
    void multipleWordsShouldCutDownToThree() {
        assertArrayEquals(new String[]{"multiple", "words", "will"}, Application.topThreeWords("Multiple words will cut down"));
    }

    @Test
    void wordsWithApostrophiesShouldBeCountedSeparately() {
        assertArrayEquals(new String[]{"wont", "won't", "w'on't"}, Application.topThreeWords("wont wont wont won't won't w'on't wont won't"));

    }

    @Test
    void apostrophiesOnlyCountsAsWord() {
        // It was unclear from the spec if apostrophes only should still count as a word
        assertArrayEquals(new String[]{"'''''''", "non", "apostrophe"}, Application.topThreeWords("''''''' ''''''' ''''''' non apostrophe words"));
    }

    @Test
    void numbersShouldNotCountAsWord() {
        assertArrayEquals(new String[]{"not", "a", "number"}, Application.topThreeWords("123 123 not a number"));
    }

    @Test
    void punctuationShouldNotCountAsWord() {
        assertArrayEquals(new String[]{"punctuation", "aren't", "words"}, Application.topThreeWords("?? ?? ++ ++ -- -- !@£$%^&*()[] punctuation aren't words"));
    }

    @Test
    void itShouldBeCaseInsensitive() {
        assertArrayEquals(new String[]{"ignore", "cases"}, Application.topThreeWords("igNORE igNoRe ignore casES Cases cases"));
    }

}
