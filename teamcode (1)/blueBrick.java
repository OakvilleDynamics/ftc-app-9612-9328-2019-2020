package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;

@Autonomous(name = "blueBrick (Blocks to Java)", group = "")
public class blueBrick extends LinearOpMode {

  private DcMotor armMotor;
  private DcMotor rightRear;
  private DcMotor rightFront;
  private DcMotor leftFront;
  private DcMotor leftRear;
  private DcMotor clawMotor;

  /**
   * This function is executed when this Op Mode is selected from the Driver Station.
   */
  @Override
  public void runOpMode() {
    armMotor = hardwareMap.dcMotor.get("armMotor");
    rightRear = hardwareMap.dcMotor.get("rightRear");
    rightFront = hardwareMap.dcMotor.get("rightFront");
    leftFront = hardwareMap.dcMotor.get("leftFront");
    leftRear = hardwareMap.dcMotor.get("leftRear");
    clawMotor = hardwareMap.dcMotor.get("clawMotor");

    // Put initialization blocks here.
    waitForStart();
    if (opModeIsActive()) {
      armMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
      // Rotate left
      LeftStickX = 0;
      LeftStickY = 0;
      RightStickX = -1;
      steps = 1100;
      move();
      wait();
      // Move forward
      LeftStickX = 0;
      LeftStickY = -1;
      RightStickX = 0;
      steps = 1800;
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
    rightRear.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
    rightRear.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
    rightFront.setPower(0 + LeftStickY + LeftStickX + RightStickX);
    leftFront.setPower(0 - (LeftStickY - (LeftStickX + RightStickX)));
    rightRear.setPower(0 + (LeftStickY - (LeftStickX - RightStickX)));
    leftRear.setPower(0 - (LeftStickY + (LeftStickX - RightStickX)));
    while (!(Math.abs(rightRear.getCurrentPosition()) > steps)) {
      telemetry.addData("autonomous", "moving");
    }
    rightFront.setPower(0);
    leftFront.setPower(0);
    rightRear.setPower(0);
    leftRear.setPower(0);
  }

  /**
   * Describe this function...
   */
  private void openClaw() {
    clawMotor.setPower(0.5);
  }

  /**
   * Describe this function...
   */
  private void closeClaw() {
    clawMotor.setPower(-0.5);
  }

  /**
   * Describe this function...
   */
  private void restClaw() {
    clawMotor.setPower(0);
  }

  /**
   * Describe this function...
   */
  private void raiseArm() {
    armMotor.setTargetPosition(-100);
    armMotor.setPower(0.25);
    armMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
    while (!(armMotor.getCurrentPosition() > -200)) {
    }
  }

  /**
   * Describe this function...
   */
  private void lowerArm() {
    armMotor.setTargetPosition(-1200);
    armMotor.setPower(0.6);
    armMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
    while (!(armMotor.getCurrentPosition() < -1100)) {
    }
  }
}
