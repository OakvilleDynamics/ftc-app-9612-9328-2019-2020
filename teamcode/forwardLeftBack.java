package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;

@Autonomous(name = "forwardLeftBack (Blocks to Java)", group = "")
@Disabled
public class forwardLeftBack extends LinearOpMode {

  private DcMotor rearRight;
  private DcMotor frontRight;
  private DcMotor frontLeft;
  private DcMotor rearLeft;

  /**
   * This function is executed when this Op Mode is selected from the Driver Station.
   */
  @Override
  public void runOpMode() {
    rearRight = hardwareMap.dcMotor.get("rearRight");
    frontRight = hardwareMap.dcMotor.get("frontRight");
    frontLeft = hardwareMap.dcMotor.get("frontLeft");
    rearLeft = hardwareMap.dcMotor.get("rearLeft");

    // Put initialization blocks here.
    waitForStart();
    if (opModeIsActive()) {
      // Move forward
      leftStickX = 0;
      leftStickY = -1;
      rightStickX = 0;
      steps = 2500;
      move();
      wait();
      // Move left
      leftStickX = -1;
      leftStickY = 0;
      rightStickX = 0;
      steps = 5500;
      move();
      wait();
      // Move backward
      leftStickX = 0;
      leftStickY = 1;
      rightStickX = 0;
      steps = 2500;
      move();
      // End
    }
  }

  /**
   * Describe this function...
   */
  private void wait() {
    sleep(1000);
  }

  /**
   * Describe this function...
   */
  private void move() {
    rearRight.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
    rearRight.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
    frontRight.setPower(0 + leftStickY + leftStickX + rightStickX);
    frontLeft.setPower(0 - (leftStickY - (leftStickX + rightStickX)));
    rearRight.setPower(0 + (leftStickY - (leftStickX - rightStickX)));
    rearLeft.setPower(0 - (leftStickY + (leftStickX - rightStickX)));
    while (!(Math.abs(rearRight.getCurrentPosition()) >= steps)) {
    }
    frontRight.setPower(0);
    frontLeft.setPower(0);
    rearRight.setPower(0);
    rearLeft.setPower(0);
  }
}
