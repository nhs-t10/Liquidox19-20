package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.Range;

import java.util.concurrent.TimeUnit;

@TeleOp
public class OpModeThree extends OpMode {

    DcMotor frontLeft, backLeft, frontRight, backRight;

    public void init() {
        //Naming the Motors for phone
        frontLeft = hardwareMap.dcMotor.get("FL");
        backLeft = hardwareMap.dcMotor.get("BL");
        frontRight = hardwareMap.dcMotor.get("FR");
        backRight = hardwareMap.dcMotor.get("BR");
    }

    public void drive(double FRBL, double FLBR) {
        frontLeft.setPower(FLBR);
        backRight.setPower(-FRBL);
        frontRight.setPower(-FRBL);
        backLeft.setPower(FLBR);
    }

    public void Sdrive(double L, double R) {
        frontLeft.setPower(L);
        backRight.setPower(-R);
        frontRight.setPower(-R);
        backLeft.setPower(L);
    }

    double angle ;
    float mAgle;
    public void loop() {
        try{
            TimeUnit.SECONDS.sleep(1/100);
        }catch (InterruptedException e){
               e.printStackTrace();
        }
        angle = 123456789;
        double lX = Range.clip(gamepad1.left_stick_x, -1, 1);
        double lY = Range.clip(gamepad1.left_stick_y, -1, 1);
        double rX = Range.clip(gamepad1.right_stick_x, -1, 1);
        double rY = Range.clip(gamepad1.right_stick_y, -1, 1);
        if(lX + lY != 0) {
            Sdrive((lY + lX) / 2, (lY - lX) / 2);
        }
        if (rX == 0) {
            if(rY > 0){
                angle = Math.PI / 2;
            } else if(rY ==0){
                angle = 123456789;
            } else{
                angle =3 *Math.PI/2;
            }
        } else if(rX > 0) {
            angle = Math.atan(rY/rX);
        } else {
            angle = Math.atan(rY/rX)+Math.PI;
        }


        //quadrant 1
       if(angle != 123456789)           {
        if (rX >= 0 && rY > 0) {
            if (rX > 0 && rX <= 45) {
                //section 1
                drive(1, -(Math.sqrt(2) * Math.cos(angle + (Math.PI / 4))));

            } else {
//section 2
                drive(1, (Math.sqrt(2) * Math.sin(angle - (Math.PI / 4))));
            }
        }
        //quadrant 2
        if (rX < 0 && rY >= 0) {
            if (angle > Math.PI / 2 && angle <= 3 * Math.PI / 4) {
                //section 3
                drive(Math.sqrt(2) * Math.sin(angle + (Math.PI / 4)), 1);
            } else {
//section 4
                drive((Math.sqrt(2) * Math.cos(angle - (Math.PI / 4))), 1);

            }          //Detailed correction has been here =)
        }
//quadrant 3
        if (rX <= 0 && rY < 0) {
            if (angle > Math.PI && angle <= 5* Math.PI /4 ) {
                //section 5
                drive(-1, -(Math.sqrt(2) * Math.cos(angle + Math.PI/4)));
            } else {
//section 6
                drive(-1, (Math.sqrt(2) * Math.sin(angle - Math.PI/4)));


            }


//quadrant 4
        } else if (angle > 3 * Math.PI/2 && angle <= (7 * Math.PI / 4)) {
            //section 7
            drive((Math.sqrt(2) * Math.sin(angle + Math.PI/4)), -1);
        } else {
            //section 8
            drive((Math.sqrt(2) * Math.cos(angle - Math.PI/4)), -1);
        }


        if (rX == 0 && rY == 0 && lX == 0 && lY == 0) {
            Sdrive(0, 0);

        }
         if(rX + rY + lX +lY == 0){
            drive(0,0);

         }
    }



    }


}
