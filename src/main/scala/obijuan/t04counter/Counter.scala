package obijuan.t04counter

import chisel3._

case class Counter(width: Int = 30, nleds: Int = 8) extends Module {
  val io = IO(new Bundle {
    val leds = Output(Bits(nleds.W))
  })

  val cnt = RegInit(0.U(width.W))
  cnt := cnt + 1.U

  io.leds := cnt(width - 1, width - nleds)
}
