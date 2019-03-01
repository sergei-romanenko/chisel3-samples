package ch3s.fsm

import chisel3.iotesters.{ChiselFlatSpec, Driver, PeekPokeTester}

class OscillatorTester(dut: Oscillator) extends PeekPokeTester(dut) {
  for (_ <- 0 until 100) {
    step(1)
  }
}

class OscillatorSim extends ChiselFlatSpec {
  "Oscillator" should "run" in {
    Driver.execute(
      Array("--backend-name", "firrtl", "--generate-vcd-output", "on"),
      () => Oscillator(N = 4, delay = 2)) {
      new OscillatorTester(_)
    } should be(true)
  }
}