package org.firstinspires.ftc.teamcode;


import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import org.firstinspires.ftc.teamcode.Turning;
import org.firstinspires.ftc.teamcode.BasicTankMode;

@Autonomous
public class AutonomousDepot extends AutonomousTesting {

    public void loop(){

        init();

//        if(step == 1){
//            unLatch();
//            if(timer1 >= 5000){
//                step++;
//            }
//        }
        step = 2;

        if(step == 2){
            drive(0.5, 0.5, 0.5, 0.5);
            if(timer1 >= 2000){
                drive(0,0,0,0);
                timer1 = 0;
                step++;
            }
        }

        if(step == 3) {
            Turning.setDestination(45);
            Turning.update(Turning.currentAngle);
            if (Turning.error < 3) {
                drive(0, 0,0,0);
                timer1 = 0;
                step++;
            }
        }

        if(step == 4) {
            drive(-0.2f,0.2f,0.2f,-0.2f);
            if(timer1 == 500) {
                drive(0,0,0,0);
                timer1 = 0;
                step++;
            }
        }

        if(step == 5) {
            drive(-1,-1,-1,-1);
            if (timer1 == 2000) {
                drive(0,0,0,0);
            }
        }

    }
}
