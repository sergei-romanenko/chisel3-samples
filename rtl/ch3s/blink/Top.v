module Top (
  output [7:0] io_leds,
  input   clk
);

  reg reset = 1;

  always @(posedge clk)
    reset <= 0;

  Blink blink_1(.clock(clk), .reset(reset), .io_leds(io_leds));

endmodule
