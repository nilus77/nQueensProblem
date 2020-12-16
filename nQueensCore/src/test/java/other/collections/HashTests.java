package other.collections;

import com.compilerswork.board.Position;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Objects;

public class HashTests {
    @Test
    void invertingObjectsOrderLeadsToDifferentHash() {
        // Arrange
        var p1 = new Position(0, 0);
        var p2 = new Position(1, 1);
        var hashMap = new HashMap<Integer, Boolean>();
        hashMap.put(Objects.hash(p1, p2), true);

        // Act
        var result = hashMap.get(Objects.hash(p2, p1));

        // Assert
        Assertions.assertNull(result);
    }
}
