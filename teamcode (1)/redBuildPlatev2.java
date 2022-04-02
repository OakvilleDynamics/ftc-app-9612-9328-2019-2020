package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;

@Autonomous(name = "redBuildPlatev2 (Blocks to Java)", group = "")
public class redBuildPlatev2 extends LinearOpMode {

  private DcMotor armMotor;
  private Servo buildPlateServo;
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
    buildPlateServo = hardwareMap.servo.get("buildPlateServo");
    rightRear = hardwareMap.dcMotor.get("rightRear");
    rightFront = hardwareMap.dcMotor.get("rightFront");
    leftFront = hardwareMap.dcMotor.get("leftFront");
    leftRear = hardwareMap.dcMotor.get("leftRear");
    clawMotor = hardwareMap.dcMotor.get("clawMotor");

    // Put initialization blocks here.
    armMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
    armMotor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
    waitForStart();
    if (opModeIsActive()) {
      steps = 2360;
      moveBackwardSlow();
      buildPlateServo.setPosition(0.5);
      wait();
      wait();
      steps = 2280;
      moveForwardSlow();
      steps = 600;
      rotateClockwiseSlow();
      buildPlateServo.setPosition(0);
      wait();
    }
  }

  /**
   * Describe this function...
   */
  private void moveForwardSlow() {
    LeftStickX = 0;
    LeftStickY = -0.3;
    RightStickX = 0;
    move();
    wait();
  }

  /**
   * Describe this function...
   */
  private void moveForward() {
    LeftStickX = 0;
    LeftStickY = -0.9;
    RightStickX = 0;
    move();
    wait();
  }

  /**
   * Describe this function...
   */
  private void rotateClockwiseSlow() {
    LeftStickX = 0;
    LeftStickY = 0;
    RightStickX = 0.4;
    move();
    wait();
  }

  /**
   * Describe this function...
   */
  private void moveRight() {
    LeftStickX = 0.9;
    LeftStickY = 0;
    RightStickX = 0;
    move();
    wait();
  }

  /**
   * Describe this function...
   */
  private void moveBackwardSlow() {
    LeftStickX = 0;
    LeftStickY = 0.3;
    RightStickX = 0;
    move();
    wait();
  }

  /**
   * Describe this function...
   */
  private void rotateClockwise() {
    LeftStickX = 0;
    LeftStickY = 0;
    RightStickX = 0.9;
    move();
    wait();
  }

  /**
   * Describe this function...
   */
  private void moveBackward() {
    LeftStickX = 0;
    LeftStickY = 0.9;
    RightStickX = 0;
    move();
    wait();
  }

  /**
   * Describe this function...
   */
  private void rotateCounterClockwise() {
    LeftStickX = 0;
    LeftStickY = 0;
    RightStickX = -0.9;
    move();
    wait();
  }

  /**
   * Describe this function...
   */
  private void moveLeft() {
    LeftStickX = -1;
    LeftStickY = 0;
    RightStickX = 0;
    move();
    wait();
  }

  /**
   * Describe this function...
   */
  private void wait() {
    sleep(750);
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
    while (!(Math.abs(rightRear.getCurrentPosition()) >= steps)) {
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
    clawMotor.setPower(-0.5);
    for (int count = 0; count < 2; count++) {
      wait();
    }
    clawMotor.setPower(0);
  }

  /**
   * Describe this function...
   */
  private void closeClaw() {
    clawMotor.setPower(0.5);
    for (int count2 = 0; count2 < 2; count2++) {
      wait();
    }
    clawMotor.setPower(0);
  }

  /**
   * Describe this function...
   */
  private void retractArm() {
    armMotor.setPower(-0.5);
    while (!(armMotor.getCurrentPosition() <= 0)) {
    }
    armMotor.setPower(0);
  }

  /**
   * Describe this function...
   */
  private void extendArm() {
    armMotor.setPower(0.5);
    while (!(armMotor.getCurrentPosition() >= 2950)) {
    }
    armMotor.setPower(0);
  }
}
