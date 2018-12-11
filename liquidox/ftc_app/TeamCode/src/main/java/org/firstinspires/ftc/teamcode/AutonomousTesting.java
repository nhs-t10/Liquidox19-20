package org.firstinspires.ftc.teamcode;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.hardware.DcMotor;
import java.util.concurrent.TimeUnit;


@Autonomous(name="LO2 Auto")
public class AutonomousTesting extends OpMode {
    float timer1;
    DcMotor frontLeft, backLeft, frontRight, backRight;
    public int step;

    public void drive(double FL, double BL, double FR, double BR){
        frontLeft.setPower(-FL);
        backRight.setPower(BR);
        frontRight.setPower(FR);
        backLeft.setPower(-BL);
    }

    public void init() {
        //Naming the Motors for phone
        frontLeft = hardwareMap.dcMotor.get("FL");
        backLeft = hardwareMap.dcMotor.get("BL");
        frontRight = hardwareMap.dcMotor.get("FR");
        backRight = hardwareMap.dcMotor.get("BR");
        step = 1;
    }
    public void loop(){

        if(step == 1){
           unLatch();
           drive(1 ,1, 1, 1 );
           if(timer1 >= 20000){
               step++;
           }
        }
        if(step == 2){
            drive(-0.5, -0.5, 0.5, 0.5);
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
        timer1 = System.currentTimeMillis();
//        if(current == currentState.Turning){
//            turn();
//        }
        telemetry.addData("Front Left Power: ", frontLeft.getPower());
        telemetry.addData("Front Right Power: ", frontRight.getPower());
        telemetry.addData("Back Left Power: ", backLeft.getPower());
        telemetry.addData("Back Right Power: ", backRight.getPower());

    }


    public void unLatch() {
        //code to unlatch
    }
}