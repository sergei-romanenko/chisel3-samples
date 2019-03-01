package ch3s.fsm

import chisel3._
import chisel3.util._

import ch3s.lib.DividerP1

case class Oscillator(N: Int, delay: Long)
  extends Module {
  val width = log2Ceil(N)
  val io = IO(new Bundle {
    val ampl = Output(UInt(width.W))
  })

  val divider = Module(DividerP1(delay))

  val counter = RegInit(0.U(width.W))
  counter := counter
  io.ampl := counter

  val sFORTH :: sBACK :: Nil = Enum(2)
  val state = RegInit(sFORTH)

  when (divider.io.tick) {
    switch(state) {
      is(sFORTH) {
        when(counter === (N - 1).U) {
          counter := counter - 1.U
          state := sBACK
        } otherwise {
          counter := counter + 1.U
        }

      }
      is(sBACK) {
        when(counter === 0.U) {
          counter := counter + 1.U
          state := sFORTH
        } otherwise {
          counter := counter - 1.U
        }
      }
    }
  }
}
