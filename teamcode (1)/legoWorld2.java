package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;

@TeleOp(name = "legoWorld2 (Blocks to Java)", group = "")
public class legoWorld2 extends LinearOpMode {

  private DcMotor rightFront;
  private DcMotor leftFront;
  private DcMotor rightRear;
  private DcMotor leftRear;
  private DcMotor clawMotor;
  private DcMotor armMotor;

  /**
   * This function is executed when this Op Mode is selected from the Driver Station.
   */
  @Override
  public void runOpMode() {
    rightFront = hardwareMap.dcMotor.get("rightFront");
    leftFront = hardwareMap.dcMotor.get("leftFront");
    rightRear = hardwareMap.dcMotor.get("rightRear");
    leftRear = hardwareMap.dcMotor.get("leftRear");
    clawMotor = hardwareMap.dcMotor.get("clawMotor");
    armMotor = hardwareMap.dcMotor.get("armMotor");

    waitForStart();
    if (opModeIsActive()) {
      // Put run blocks here.
      while (opModeIsActive()) {
        // Put loop blocks here.
        rightFront.setPower(0 + gamepad1.left_stick_y + gamepad1.left_stick_x + gamepad1.right_stick_x);
        leftFront.setPower(0 - (gamepad1.left_stick_y - (gamepad1.left_stick_x + gamepad1.right_stick_x)));
        rightRear.setPower(0 + (gamepad1.left_stick_y - (gamepad1.left_stick_x - gamepad1.right_stick_x)));
        leftRear.setPower(0 - (gamepad1.left_stick_y + (gamepad1.left_stick_x - gamepad1.right_stick_x)));
        if (gamepad2.a) {
          clawMotor.setPower(0.5);
        } else {
          if (gamepad2.b) {
            clawMotor.setPower(-0.5);
          } else {
            clawMotor.setPower(0);
          }
        }
        armMotor.setPower(gamepad2.left_stick_y * -0.8);
        telemetry.update();
      }
    }
  }
}
