module Top(
  output io_ch0,
  output io_ch1,
  output io_ch2,
  output io_ch3,
  input clk
);

  reg reset = 1;

  always @(posedge clk)
    reset <= 0;

  Tones counter_1(.clock(clk), .reset(reset),
    .io_ch0(io_ch0), .io_ch1(io_ch1), .io_ch2(io_ch2), .io_ch3(io_ch3));

endmodule
