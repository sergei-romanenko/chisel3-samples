package ch3s.blink

import chisel3._
import chisel3.util.{Cat, log2Ceil}

case class Blink
(
  clockFreq: Long,
  nleds: Int = 8,
  frequency: Long = 1
) extends Module {

  val io = IO(new Bundle {
    val leds = Output(Bits(nleds.W))
  })

  val period = clockFreq / frequency
  val half = period / 2
  val width = log2Ceil(period)

  val cnt = RegInit(0.U(width.W))

  when(cnt === (period - 1).U) {
    cnt := 0.U
  } otherwise {
    cnt := cnt + 1.U
  }

  val tick = cnt < half.U

  io.leds := Cat(0.U((width - 1).W), tick)
}
