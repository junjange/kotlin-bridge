package bridge

import org.junit.jupiter.api.Test
import org.assertj.core.api.Assertions.assertThat

class BridgeGameTest {
    @Test
    fun `다리의 끝까지 이동한 경우 게임이 종료된다`() {
        val bridgeMaker = BridgeMaker(TestNumberGenerator(listOf(1, 1, 0))).makeBridge(3)
        val bridgeGame = BridgeGame()

        println(bridgeMaker)
        bridgeGame.move(bridgeMaker, "U")
        bridgeGame.move(bridgeMaker, "U")
        bridgeGame.move(bridgeMaker, "D")
        assertThat(bridgeGame.isGameEnd(bridgeMaker)).isEqualTo(true)
    }

    @Test
    fun `마지막 다리에서 실패하더라도 게임이 종료된다`() {
        val bridgeMaker = BridgeMaker(TestNumberGenerator(listOf(1, 1, 0))).makeBridge(3)
        val bridgeGame = BridgeGame()

        bridgeGame.move(bridgeMaker, "U")
        bridgeGame.move(bridgeMaker, "U")
        bridgeGame.move(bridgeMaker, "U")
        assertThat(bridgeGame.isGameEnd(bridgeMaker)).isEqualTo(true)
    }

    @Test
    fun `다리를 건너다가 실패하면 게임이 종료된다`() {

        val bridgeMaker = BridgeMaker(TestNumberGenerator(listOf(1, 1, 0))).makeBridge(3)
        val bridgeGame = BridgeGame()

        bridgeGame.move(bridgeMaker, "U")
        bridgeGame.move(bridgeMaker, "D")
        assertThat(bridgeGame.isGameEnd(bridgeMaker)).isEqualTo(true)
    }

    @Test
    fun `다리를 끝까지 건너면 게임을 성공한다`() {
        val bridgeMaker = BridgeMaker(TestNumberGenerator(listOf(1, 1, 0))).makeBridge(3)
        val bridgeGame = BridgeGame()
        bridgeGame.move(bridgeMaker,"U")
        bridgeGame.move(bridgeMaker,"U")
        bridgeGame.move(bridgeMaker,"D")
        assertThat(bridgeGame.isSuccess).isEqualTo(true)
    }

    @Test
    fun `다리를 건너다가 사용자 입력 값과 다리의 값이 다른 경우 게임이 실패한다`() {
        val bridgeMaker = BridgeMaker(TestNumberGenerator(listOf(1, 1, 0))).makeBridge(3)
        val bridgeGame = BridgeGame()
        bridgeGame.move(bridgeMaker,"U")
        bridgeGame.move(bridgeMaker,"U")
        bridgeGame.move(bridgeMaker,"U")
        assertThat(bridgeGame.isSuccess).isEqualTo(false)
    }

    class TestNumberGenerator(numbers: List<Int>) : BridgeNumberGenerator {
        private val numbers: MutableList<Int> = numbers.toMutableList()

        override fun generate(): Int {
            return numbers.removeAt(0)
        }
    }
}