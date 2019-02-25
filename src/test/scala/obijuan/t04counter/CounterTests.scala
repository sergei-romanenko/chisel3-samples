package obijuan.t04counter

import chisel3.iotesters.{ChiselFlatSpec, Driver, PeekPokeTester}

class CounterTests(dut: Counter) extends PeekPokeTester(dut) {

  var cnt = 0

  for (_ <- 0 until 100) {
    val high = cnt >> (dut.width - dut.nleds)
    expect(dut.io.leds, high)
    cnt = (cnt + 1) & 0x3F
    step(1)
  }
}

class CounterTester extends ChiselFlatSpec {
  "Counter" should "run" in {
    Driver.execute(
      Array(
        "--backend-name", "firrtl",
        //"--backend-name", "verilator",
        "--generate-vcd-output", "on"
      ),
      () => Counter(6, 4)) {
      new CounterTests(_)
    } should be(true)
  }

}
