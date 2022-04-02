package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;

@TeleOp(name = "legoWorld (Blocks to Java)", group = "")
public class legoWorld extends LinearOpMode {

  private DcMotor rightFront;
  private DcMotor leftFront;
  private DcMotor rightRear;
  private DcMotor leftRear;
  private DcMotor armMotor;
  private DcMotor clawMotor;

  /**
   * This function is executed when this Op Mode is selected from the Driver Station.
   */
  @Override
  public void runOpMode() {
    rightFront = hardwareMap.dcMotor.get("rightFront");
    leftFront = hardwareMap.dcMotor.get("leftFront");
    rightRear = hardwareMap.dcMotor.get("rightRear");
    leftRear = hardwareMap.dcMotor.get("leftRear");
    armMotor = hardwareMap.dcMotor.get("armMotor");
    clawMotor = hardwareMap.dcMotor.get("clawMotor");

    waitForStart();
    if (opModeIsActive()) {
      // Put run blocks here.
      while (opModeIsActive()) {
        // Put loop blocks here.
        rightFront.setPower(gamepad1.left_stick_y - (gamepad1.left_stick_x - gamepad1.right_stick_x));
        leftFront.setPower(gamepad1.left_stick_y - (gamepad1.left_stick_x + gamepad1.right_stick_x));
        rightRear.setPower(gamepad1.left_stick_y + (gamepad1.left_stick_x - gamepad1.right_stick_x));
        leftRear.setPower(gamepad1.left_stick_y + gamepad1.left_stick_x + gamepad1.right_stick_x);
        if (gamepad1.left_bumper) {
          armMotor.setPower(-1);
        } else {
          if (gamepad1.right_bumper) {
            armMotor.setPower(1);
          } else {
            armMotor.setPower(0);
          }
        }
        if (gamepad1.a) {
          clawMotor.setPower(0.5);
        } else {
          if (gamepad1.b) {
            clawMotor.setPower(-0.5);
          } else {
            clawMotor.setPower(0);
          }
        }
        telemetry.update();
      }
    }
  }
}
