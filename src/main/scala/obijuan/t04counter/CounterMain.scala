package obijuan.t04counter

object CounterMain extends App {
  chisel3.Driver.execute(
    Array("-td", "rtl/obijuan/t04counter"), () => Counter())
}
