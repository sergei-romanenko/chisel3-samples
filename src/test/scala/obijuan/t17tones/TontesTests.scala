package obijuan.t17tones

import chisel3.iotesters.{ChiselFlatSpec, Driver, PeekPokeTester}


class TonesTests(dut: Tones) extends PeekPokeTester(dut) {
  step(1) // Reset!
  step(49)
}

class TonesTester extends ChiselFlatSpec {
  "Tones" should "run" in {
    Driver.execute(
      Array("--backend-name", "firrtl", "--generate-vcd-output", "on"),
      () => Tones(F0 = 3, F1 = 5, F2 = 7, F3 = 10)) {
      new TonesTests(_)
    } should be(true)
  }
}
