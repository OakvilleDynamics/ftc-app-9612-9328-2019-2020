package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;

@TeleOp(name = "legoWorld3 (Blocks to Java)", group = "")
public class legoWorld3 extends LinearOpMode {

  private Servo buildPlateServo;
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
    buildPlateServo = hardwareMap.servo.get("buildPlateServo");
    rightFront = hardwareMap.dcMotor.get("rightFront");
    leftFront = hardwareMap.dcMotor.get("leftFront");
    rightRear = hardwareMap.dcMotor.get("rightRear");
    leftRear = hardwareMap.dcMotor.get("leftRear");
    clawMotor = hardwareMap.dcMotor.get("clawMotor");
    armMotor = hardwareMap.dcMotor.get("armMotor");

    buildPlateServo.setPosition(0);
    waitForStart();
    if (opModeIsActive()) {
      // Put run blocks here.
      armControllable = 1;
      movementMultiplier = 1;
      while (opModeIsActive()) {
        // Movement control
        rightFront.setPower(movementMultiplier * (0 + gamepad1.left_stick_y + gamepad1.left_stick_x + gamepad1.right_stick_x));
        leftFront.setPower(movementMultiplier * (0 - (gamepad1.left_stick_y - (gamepad1.left_stick_x + gamepad1.right_stick_x))));
        rightRear.setPower(movementMultiplier * (0 + (gamepad1.left_stick_y - (gamepad1.left_stick_x - gamepad1.right_stick_x))));
        leftRear.setPower(movementMultiplier * (0 - (gamepad1.left_stick_y + (gamepad1.left_stick_x - gamepad1.right_stick_x))));
        // Movement multiplier
        if (gamepad1.right_bumper) {
          movementMultiplier = 0.5;
        } else {
          movementMultiplier = 1;
        }
        // Claw controls
        if (gamepad2.a) {
          clawMotor.setPower(0.5);
        } else {
          if (gamepad2.b) {
            clawMotor.setPower(-0.5);
          } else {
            clawMotor.setPower(0);
          }
        }
        // Arm controls
        if (armControllable == 1) {
          if (gamepad2.left_stick_y >= 0.1 || gamepad2.left_stick_y <= -0.1) {
            armMotor.setPower(gamepad2.left_stick_y);
          } else {
            armMotor.setPower(0);
          }
        }
        // Servo Controls
        if (gamepad2.dpad_down) {
          buildPlateServo.setPosition(0.5);
        }
        if (gamepad2.dpad_up) {
          buildPlateServo.setPosition(0);
        }
        // Step measurement reset
        if (gamepad1.y) {
          rightFront.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
          leftFront.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
          rightRear.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
          leftRear.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
          rightFront.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
          leftFront.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
          rightRear.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
          leftRear.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        }
        // Step movement telemetry
        telemetry.addData("armMotor", armMotor.getCurrentPosition());
        telemetry.addData("rightRear", rightRear.getCurrentPosition());
        telemetry.addData("leftRear", leftRear.getCurrentPosition());
        telemetry.addData("rightFront", rightFront.getCurrentPosition());
        telemetry.addData("leftFront", leftFront.getCurrentPosition());
        telemetry.update();
      }
    }
  }
}
