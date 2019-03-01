package ch3s.fsm

import chisel3._
import chisel3.util._

import ch3s.lib._

case class OscillatorTester(N: Int = 8, delay: Long = ICE40HX8K.clock_freq)
  extends Module {

  val io = IO(new Bundle{
    val leds = Output(Bits(N.W))
  })

  val oscillator = Module(Oscillator(N, delay))

  val width = log2Ceil(N)
  val ampl = Wire(UInt(width.W))
  ampl := oscillator.io.ampl

  io.leds := 1.U << ampl
}

object OscillatorMain extends App {
  chisel3.Driver.execute(
    Array("-td", "rtl/ch3s/fsm"), () => OscillatorTester())
}
