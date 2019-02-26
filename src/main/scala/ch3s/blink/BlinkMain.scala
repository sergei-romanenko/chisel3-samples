package ch3s.blink

object BlinkMain extends App {

  val iCE40HX8K_clock_freq = 12000000

  chisel3.Driver.execute(
    Array("-td", "rtl/ch3s/blink"), () => Blink(iCE40HX8K_clock_freq))
}

