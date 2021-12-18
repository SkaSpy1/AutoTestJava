package lesson4;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class BoxTest {
    Box box;

    @Nested
    class WhenEmpty {
        @BeforeEach
        void initializeBox() {
            box = new Box();
        }

        @Test
        void exceptionWhenToShuffleEmptyBox() {
            Assertions.assertThrows(ZeroBallsCountException.class, () -> box.shuffleBalls());
            assertThatExceptionOfType(ZeroBallsCountException.class).isThrownBy(() -> box.shuffleBalls());
        }

        @Test
        void exceptionWhenToRemoveBallFromEmptyBox() {
            assertThatNullPointerException().isThrownBy(() -> box.shuffleBalls());
        }

        @Nested
        class WhenOneBall {
            @BeforeEach
            void addBall() {
                box.addBall();
            }
         @Test
         void   deleteBallTest(){
                box.removeBall();
                assertThat(box.getBallsCounter()).isEqualTo(0);
         }
        }
    }
}
