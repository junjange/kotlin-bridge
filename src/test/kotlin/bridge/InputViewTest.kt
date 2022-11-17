package bridge

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class InputViewTest {

    @ValueSource(strings = ["a"])
    @ParameterizedTest
    fun `입력된 다리길이가 숫자가 아닌 경우 예외 테스트`(input: String) {
        assertThrows<IllegalArgumentException> {
            input.bridgeSizeInputTypeException()

        }
    }
}