计算器实体：Calculator
各种不同操作由 Operation 进行封装
测试类：com.amway.CalculatorTest

设计思想：通过在每个操作中维护操作前的值以及操作数，来达到快速undo和redo的目的