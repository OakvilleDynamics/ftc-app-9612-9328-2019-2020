package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;

@TeleOp(name = "conorsCode (Blocks to Java)", group = "")
public class conorsCode extends LinearOpMode {

  private DcMotor frontLeft;
  private DcMotor rearLeft;
  private DcMotor rearRight;
  private DcMotor frontRight;

  /**
   * This function is executed when this Op Mode is selected from the Driver Station.
   */
  @Override
  public void runOpMode() {
    frontLeft = hardwareMap.dcMotor.get("frontLeft");
    rearLeft = hardwareMap.dcMotor.get("rearLeft");
    rearRight = hardwareMap.dcMotor.get("rearRight");
    frontRight = hardwareMap.dcMotor.get("frontRight");

    // Put initialization blocks here.
    waitForStart();
    if (opModeIsActive()) {
      // Put run blocks here.
      while (opModeIsActive()) {
        // Put loop blocks here.
        frontLeft.setPower(gamepad1.right_stick_x + gamepad1.right_stick_x);
        rearLeft.setPower(gamepad1.right_stick_x + gamepad1.right_stick_x);
        rearRight.setPower(gamepad1.right_stick_x - 0);
        //This is a test
        frontRight.setPower(gamepad1.right_stick_x - 0);
        frontLeft.setPower(gamepad1.left_stick_y + gamepad1.left_stick_x);
        frontRight.setPower(gamepad1.left_stick_y + gamepad1.left_stick_x);
        rearLeft.setPower(gamepad1.left_stick_y + gamepad1.left_stick_x);
        rearRight.setPower(gamepad1.left_stick_y + gamepad1.left_stick_x);
        telemetry.update();
      }
    }
  }
}
