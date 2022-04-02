package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;

@TeleOp(name = "driveCode (Blocks to Java)", group = "")
public class driveCode extends LinearOpMode {

  private DcMotor frontRight;
  private DcMotor frontLeft;
  private DcMotor rearRight;
  private DcMotor rearLeft;
  private DcMotor liftMotor;
  private Servo rightServo;
  private Servo leftServo;

  /**
   * This function is executed when this Op Mode is selected from the Driver Station.
   */
  @Override
  public void runOpMode() {
    frontRight = hardwareMap.dcMotor.get("frontRight");
    frontLeft = hardwareMap.dcMotor.get("frontLeft");
    rearRight = hardwareMap.dcMotor.get("rearRight");
    rearLeft = hardwareMap.dcMotor.get("rearLeft");
    liftMotor = hardwareMap.dcMotor.get("liftMotor");
    rightServo = hardwareMap.servo.get("rightServo");
    leftServo = hardwareMap.servo.get("leftServo");

    waitForStart();
    if (opModeIsActive()) {
      movementMultiplier = 1;
      while (opModeIsActive()) {
        // Movement controls
        frontRight.setPower(movementMultiplier * (0 + gamepad1.left_stick_y + gamepad1.left_stick_x + gamepad1.right_stick_x));
        frontLeft.setPower(movementMultiplier * (0 - (gamepad1.left_stick_y - (gamepad1.left_stick_x + gamepad1.right_stick_x))));
        rearRight.setPower(movementMultiplier * (0 + (gamepad1.left_stick_y - (gamepad1.left_stick_x - gamepad1.right_stick_x))));
        rearLeft.setPower(movementMultiplier * (0 - (gamepad1.left_stick_y + (gamepad1.left_stick_x - gamepad1.right_stick_x))));
        // Movement multiplier
        if (gamepad1.right_bumper) {
          movementMultiplier = 0.25;
        } else {
          movementMultiplier = 1;
        }
        // Lift controls
        liftMotor.setPower(gamepad2.right_trigger - gamepad2.left_trigger);
        // Grip controls
        if (gamepad2.left_bumper) {
          rightServo.setPosition(0.4);
          leftServo.setPosition(0.85);
        } else {
          if (gamepad2.right_bumper) {
            rightServo.setPosition(1);
            leftServo.setPosition(0.4);
          }
        }
        // Reset step tracker
        if (gamepad1.y) {
          frontRight.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
          frontLeft.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
          rearRight.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
          rearLeft.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
          frontRight.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
          frontLeft.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
          rearRight.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
          rearLeft.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        }
        // Step telemetry
        telemetry.addData("frontRight", frontRight.getCurrentPosition());
        telemetry.addData("frontLeft", frontLeft.getCurrentPosition());
        telemetry.addData("rearRight", rearRight.getCurrentPosition());
        telemetry.addData("rearLeft", rearLeft.getCurrentPosition());
        telemetry.update();
      }
    }
  }
}
