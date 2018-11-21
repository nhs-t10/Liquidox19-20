package org.firstinspires.ftc.teamcode;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;

import java.util.concurrent.TimeUnit;
//Hello! This entire section is just going to be a sort of logbook for all of the changes I intend to make
//This used to be called "OpModeTwo"
//Right now I am working on simplifying my cascading if statements into methods.
//This will probably take a while but it will be worth it in the end.
//Work on autonomus has started
@TeleOp
public class TeleOpExperiments extends OpMode {
    DcMotor frontLeft, backLeft, frontRight, backRight;
   // Servo servoOne;
    /**int  sanic; */
    double lsx, lsy, rsx, rsy;
    public int boostSpeed (boolean boost){
        if (boost == false){
            return 1;
        }else{
            return 2;
        }
    }
    public boolean boost (boolean a, boolean b, boolean x, boolean y){
        if (a == true && b == true && x == true && y == false){
            return true;
        }else{
            return false;
        }
    }
/** 0 is turn, 1 is normal, 2 will be strafing */
    public int dir (){

        if (Math.abs(rsx) >= 0.3){
            return 666 /**This number can be anything*/;
        }
            else if (Math.abs(lsy)>Math.abs(lsx)) {
                return 1;
            }else{
                return 0;
            }
        }




//    public double servoUno (float rTrig){
//        servoOne.setPosition(rTrig);
//        return rTrig;
//    }
    public void drive(double FL, double BL, double FR, double BR){
        frontLeft.setPower(FL);
        backRight.setPower(BR);
        frontRight.setPower(FR);
        backLeft.setPower(BL);
    }
    public void init() {
        //Naming the Motors for phone
        frontLeft = hardwareMap.dcMotor.get("FL");
        backLeft = hardwareMap.dcMotor.get("BL");
        frontRight = hardwareMap.dcMotor.get("FR");
        backRight = hardwareMap.dcMotor.get("BR");
     //   sanic = 1/2;
//        servoOne = hardwareMap.servo.get("S1");
    }
    public void loop() {
        lsx=gamepad1.left_stick_x;
        lsy=gamepad1.left_stick_y;
        rsx=gamepad1.right_stick_x;
        rsy=gamepad1.right_stick_y;
        //boost test
      /**  if (gamepad1.start == true){
            if ((boost (gamepad1.a, gamepad1.b, gamepad1.x, gamepad1.y)) == true){
                sanic = 1;
            }
            sanic = 1/2;
        } */
//        //servo method
//        servoUno(gamepad1.right_trigger);
        //lag
        try {
            TimeUnit.SECONDS.sleep(1/100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        if (dir() == 0){
            drive(lsx*9/10, lsx*9/10, lsx*5.5/10, lsx*5.5/10);
        }
        if (dir() == 1) {
            drive(-lsy*9/10, -lsy*9/10, lsy*5.5/10, lsy*5.5/10);
        }
        if (dir() == 666){
            drive(-rsx*9/10, rsx*9/10, -rsx*7/10, rsx*7/10);
        }

    }
}
