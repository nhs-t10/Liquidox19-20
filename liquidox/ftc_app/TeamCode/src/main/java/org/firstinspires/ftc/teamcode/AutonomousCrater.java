package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import org.firstinspires.ftc.teamcode.Turning;

@Autonomous
public class AutonomousCrater extends AutonomousTesting {

    public void loop() {

        init();

//        if (step == 1) {
//            unLatch();
//            if (timer1 >= 5000) {
//                step++;
//            }
//        }
        step == 2

        if (step == 2) {
            drive(1,1,1,1);
            if (timer1 >= 2000) {
                step++;
            }

        }

        if (step==3) {
            setDestination(90);
            update();
            if (error == 0) {
                step++
            }
        }

    }
}


