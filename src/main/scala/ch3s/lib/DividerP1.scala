package ch3s.lib

import chisel3._
import chisel3.util._

case class DividerP1(delay: Long) extends Module {
  val io = IO(new Bundle {
    val tick = Output(Bool())
  })

  val width = log2Ceil(delay)
  val max = (delay - 1).U(width.W)

  val cnt = RegInit(0.U(width.W))
  cnt := Mux(cnt === max, 0.U, cnt + 1.U)
  io.tick := cnt === 0.U
}
