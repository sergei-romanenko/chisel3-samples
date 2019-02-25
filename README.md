# Some experiments with Chisel3

## What is Chisel3?

Chisel3 is an open-source hardware construction language developed at UC Berkeley that supports advanced hardware design using highly parameterized generators and layered domain-specific hardware languages.

* <https://chisel.eecs.berkeley.edu/>
* <https://github.com/freechipsproject/chisel3/>

## What is in this repository?

### src/main/scala/obijuan/

A number of expamples from the tutorial by Juan Gonzalez-Gomez (Obijuan)

> Diseño Digital para FPGAs, con herramientas libres  
> (Digital Design for FPGAs, with free tools)  
> <https://github.com/Obijuan/open-fpga-verilog-tutorial/wiki>

rewritten from Verilog to Chisel3 and tested with
[iCE40-HX8K Breakout Board - Lattice
Semiconductor](http://www.latticesemi.com/Products/DevelopmentBoardsAndKits/iCE40HX8KBreakoutBoard.aspx).

### src/main/scala/ch3s/

A collection of various **Ch**iesel**3** **s**amples.

## How to actually build and upload the designs to an FPGA board?

The Verilog programs generated by SpinalHDL can be built and
uploaded to iCE40-HX8K by means of the tools, provided by
<https://github.com/FPGAwars>.

## Prerequisits

In order for this stuff to be up and running, there has to be installed some
additional software. The details can be found at

* <https://github.com/freechipsproject/chisel-template>
