package obijuan.t17tones

import chisel3._
import chisel3.util.log2Ceil

import obijuan.lib.Freq

case class ToneGen(delay: Long = Freq.F_2KHz) extends Module {
  val io = IO(new Bundle {
    val tick = Output(Bool())
  })

  val width = log2Ceil(delay)
  val max = (delay - 1).U(width.W)

  val cnt = RegInit(0.U(width.W))
  io.tick := cnt(width - 1)
  cnt := Mux(cnt === max, 0.U, cnt + 1.U)
}
