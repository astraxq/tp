package seedu.address.model.score;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static seedu.address.testutil.TypicalScores.SCORE_1;

import java.util.List;

import org.junit.jupiter.api.Test;

import seedu.address.model.score.exceptions.DuplicateScoreException;
import seedu.address.model.score.exceptions.ScoreNotFoundException;

public class ScoreListTest {
    private final ScoreList scoreList = new ScoreList();

    @Test
    public void contains_nullScore_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> scoreList.contains(null));
    }

    @Test
    public void contains_scoreNotInList_returnFalse() {
        assertFalse(scoreList.contains(SCORE_1));
    }

    @Test
    public void contains_scoreInList_returnTrue() {
        scoreList.add(SCORE_1);
        assertTrue(scoreList.contains(SCORE_1));
    }

    @Test
    public void add_nullScore_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> scoreList.add(null));
    }

    @Test
    public void add_duplicateScore_throwsDuplicateScoreException() {
        scoreList.add(SCORE_1);
        assertThrows(DuplicateScoreException.class, () -> scoreList.add(SCORE_1));
    }

    @Test
    public void remove_nullScore_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> scoreList.remove(null));
    }

    @Test
    public void remove_scoreDoesNotExist_throwsScoreNotFoundException() {
        assertThrows(ScoreNotFoundException.class, () -> scoreList.remove(SCORE_1));
    }

    @Test
    public void remove_existingScore_removesScore() {
        scoreList.add(SCORE_1);
        scoreList.remove(SCORE_1);
        ScoreList expectedScoreList = new ScoreList();
        assertTrue(scoreList.equals(expectedScoreList));
    }

    @Test
    public void setScores_nullUniqueScoreList_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> scoreList.setScores((ScoreList) null));
    }

    @Test
    public void setScores_nullList_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> scoreList.setScores((List<Score>) null));
    }

    @Test
    public void asUnmodifiableObservableList_modifyList_throwsUnsupportedOperationException() {
        assertThrows(UnsupportedOperationException.class, () -> scoreList.asUnmodifiableObservableList().remove(0));
    }
}
