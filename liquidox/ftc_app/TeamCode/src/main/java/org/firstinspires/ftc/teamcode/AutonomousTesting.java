package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.Range;
import org.firstinspires.ftc.robotcore.external.*;
import java.util.concurrent.TimeUnit;

@TeleOp
public class AutonomousTesting extends OpMode {
    float timer1 = 0;
    DcMotor frontLeft, backLeft, frontRight, backRight;

    Servo rightChestShoulder, leftChestShoulder, leftOuterShoulder, rightOuterShoulder;

    int step = 1;

    float speed = .5f  /* 3f */;
    public void init() {
        /*Naming the Motors for phone*/
        frontLeft = hardwareMap.dcMotor.get("FL");
        backLeft = hardwareMap.dcMotor.get("BL");
        frontRight = hardwareMap.dcMotor.get("FR");
        backRight = hardwareMap.dcMotor.get("BR");

        rightChestShoulder = hardwareMap.servo.get("RCS");
        leftChestShoulder = hardwareMap.servo.get("LCS");
        rightOuterShoulder = hardwareMap.servo.get("ROS");
        leftOuterShoulder = hardwareMap.servo.get("LOS");

    }
    public final void drive(float bl, float fl, float fr, float br ) {

        frontLeft.setPower(-fl*speed /* *9/10 */);
        backRight.setPower(br*speed  /* *4.5/10 */);
        frontRight.setPower(fr*speed /* *4.5/10 */);
        backLeft.setPower(-bl*speed /* *9/10 */ );

    }

    float[] sum = {0,0,0,0};



    public void loop() {

        float lX = Range.clip(gamepad1.left_stick_x, -1, 1);
        float lY = Range.clip(gamepad1.left_stick_y, -1, 1);
        float rX = Range.clip(gamepad1.right_stick_x, -1, 1);


        float[] vertical = { /* 0.7f * */  lY, /* 0.7f * */ lY, /* 0.7f * */  lY, /* 0.7f * */ lY};
        float[] horizontal = {-lX, lX, lX, -lX};
        float[] rotational = {-rX, -rX, rX, rX};

        for(int i=0; i<4; i++) {
            sum[i] = vertical[i] + horizontal[i] + rotational[i];
        }

        if(step == 2){
            drive(-0.5f, -0.5f, 0.5f, 0.5f);
            if(timer1 >= 10000){
              //  drive(0,0,0,0);
                step++;
            }
            if(step == 3){
                drive(1, 1,1 , 1 );
                if(timer1 >= 15000){
                    step++;
                }
            }
        }

//        if(current == currentState.Turning){
//            turn();
//        }

        telemetry.addData("Front Left Power: ", frontLeft.getPower());
        telemetry.addData("Front Right Power: ", frontRight.getPower());
        telemetry.addData("Back Left Power: ", backLeft.getPower());
        telemetry.addData("Back Right Power: ", backRight.getPower());
        telemetry.addData("Left Gamepad X-Coordinate: ", lX);
        telemetry.addData("Left Gamepad X-Coordinate: ", lY);
        telemetry.addData("Data we  fed into `drive()`: ", sum);
        telemetry.addData("Current speed: ", speed);
        telemetry.update();
    }


}