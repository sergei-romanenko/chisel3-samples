package obijuan.t17tones

import chisel3._

import obijuan.lib.Freq

case class Tones
(
  F0: Long = Freq.F_1KHz,
  F1: Long = Freq.F_2KHz,
  F2: Long = Freq.F_3KHz,
  F3: Long = Freq.F_4KHz
) extends Module {
  val io = IO(new Bundle {
    val ch0, ch1, ch2, ch3 = Output(Bool())
  })

  val g0 = Module(ToneGen(F0))
  io.ch0 := g0.io.tick
  val g1 = Module(ToneGen(F1))
  io.ch1 := g1.io.tick
  val g2 = Module(ToneGen(F2))
  io.ch2 := g2.io.tick
  val g3 = Module(ToneGen(F3))
  io.ch3 := g3.io.tick
}
