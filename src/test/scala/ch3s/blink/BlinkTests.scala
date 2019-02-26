package ch3s.blink

import chisel3.iotesters.{ChiselFlatSpec, Driver, PeekPokeTester}

class BlinkTests(dut: Blink) extends PeekPokeTester(dut) {
  step(1) // Reset!
  step(99)
}

class BlinkTester extends ChiselFlatSpec {
  "Counter" should "run" in {
    Driver.execute(
      Array(
        "--backend-name", "firrtl",
        //"--backend-name", "verilator",
        "--generate-vcd-output", "on"
      ),
      () => Blink(clockFreq = 10, nleds = 3, frequency = 2)) {
      new BlinkTests(_)
    } should be(true)
  }

}
