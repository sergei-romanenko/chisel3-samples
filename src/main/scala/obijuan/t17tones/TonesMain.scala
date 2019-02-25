package obijuan.t17tones

object TonesMain extends App {
  chisel3.Driver.execute(
    Array("-td", "rtl/obijuan/t17tones"), () => Tones())
}
